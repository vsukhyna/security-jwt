package ua.svp.securityjwt.configurations;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

//    private final TypeResolver typeResolver;
//
//    public SwaggerConfig(TypeResolver typeResolver) {
//        this.typeResolver = typeResolver;
//    }
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.OAS_30)
//                .apiInfo(metadata())
//                .groupName("all controllers")
//                .alternateTypeRules(AlternateTypeRules.newRule(
//                        typeResolver.resolve(List.class, LocalDate.class),
//                        typeResolver.resolve(List.class, java.sql.Date.class),
//                        Ordered.HIGHEST_PRECEDENCE)
//                )
//                .directModelSubstitute(LocalDate.class, java.sql.Date.class)
//                .directModelSubstitute(OffsetDateTime.class, java.util.Date.class)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("ua.svp.securityjwt.controllers"))
//                .paths(PathSelectors.any())
//                .build()
//                .securitySchemes(Collections.singletonList(jwtScheme()))
//                .securityContexts(Collections.singletonList(securityContext()));
//    }
//
//    private ApiInfo metadata() {
//        return new ApiInfoBuilder()
//                .title("Demo authentication service")
//                .description("Authentication Server REST API")
//                .license("Apache License Version 2.0")
//                .version("1.0.0")
//                .build();
//    }
//
//    private SecurityScheme jwtScheme() {
//        return HttpAuthenticationScheme.JWT_BEARER_BUILDER
//                .name("JWT")
//                .description("Enter a token")
//                .build();
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(Collections.singletonList(defaultAuth()))
//                .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
//                .build();
//    }
//
//    private SecurityReference defaultAuth() {
//        return SecurityReference.builder()
//                .scopes(new AuthorizationScope[0])
//                .reference("JWT")
//                .build();
//    }
}