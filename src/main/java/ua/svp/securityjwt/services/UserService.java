package ua.svp.securityjwt.services;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.svp.securityjwt.dto.UserProfileResponseDto;
import ua.svp.securityjwt.models.Role;
import ua.svp.securityjwt.models.User;
import ua.svp.securityjwt.repositories.RoleRepository;
import ua.svp.securityjwt.repositories.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(x -> new SimpleGrantedAuthority(x.getName())).collect(Collectors.toList());
    }

    public UUID saveUser(User user) {
        user.setRoles(Set.of(roleRepository.findByName("ROLE_USER").get()));
        return userRepository.save(user).getId();
    }

    public UserProfileResponseDto getUserProfile(String username) {
        User user = findByUsername(username);

        return new UserProfileResponseDto(user.getUsername(), user.getEmail(), user.getRoles()
                .stream().map(Role::getName).collect(Collectors.toList()));
    }

    public List<UserProfileResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(
                x -> new UserProfileResponseDto(
                        x.getUsername(),
                        x.getEmail(),
                        x.getRoles().stream().map(Role::getName).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }
}
