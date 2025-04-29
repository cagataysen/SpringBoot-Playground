package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {


    // there will be no more randomly generated pw after here, cuz we have our own user management
    @Bean
    public UserDetailsService userDetailsService(){
        var uds = new InMemoryUserDetailsManager();

        var u1 = User.withUsername("bill")
                .password("12345")
                .authorities("read")   // assigning role here, e.g.: "ROLE_ADMIN"
                .build();

        uds.createUser(u1);

        return uds;
    }

    //Dont use in real world example, we ll just encode our pw with that simply
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
