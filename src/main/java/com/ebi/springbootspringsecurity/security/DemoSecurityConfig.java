package com.ebi.springbootspringsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // add support for JDBC ... no more hardcoded users :-)

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll())
                .logout(LogoutConfigurer::permitAll)
                .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));
        return http.build();

    }

        /*@Bean
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
*/

}
