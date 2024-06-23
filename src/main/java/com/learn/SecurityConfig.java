package com.learn;

import com.learn.filters.CsrfLoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(Customizer.withDefaults());
//        http.addFilterAfter(new CsrfLoggingFilter(), CsrfFilter.class);
        http.authorizeHttpRequests(c -> c
                .anyRequest().authenticated());
        http.formLogin(c -> c.defaultSuccessUrl("/main", true));
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails u = User.withUsername("sofiane").password("azerty").build();
        return new InMemoryUserDetailsManager(u);
    }
}
