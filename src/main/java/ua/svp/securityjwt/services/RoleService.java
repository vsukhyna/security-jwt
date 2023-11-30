package ua.svp.securityjwt.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.svp.securityjwt.models.Role;
import ua.svp.securityjwt.repositories.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").orElseThrow();
    }
}
