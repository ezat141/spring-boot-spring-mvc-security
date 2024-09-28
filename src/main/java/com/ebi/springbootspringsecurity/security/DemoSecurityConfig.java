package com.ebi.springbootspringsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager UserDetailsManager() {

        UserDetails ahmed = User.builder()
                .username("ahmed")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails mohamed = User.builder()
                .username("mohamed")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails ezzat = User.builder()
                .username("ezzat")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();



        return new InMemoryUserDetailsManager(ahmed, mohamed, ezzat);
    }
}
