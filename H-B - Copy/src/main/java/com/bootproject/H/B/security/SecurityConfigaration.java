package com.bootproject.H.B.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigaration {

    private final UserDetailsService userDetailsService;

    public SecurityConfigaration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(encoder());

        return provider;

    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{

        http
                .csrf(AbstractHttpConfigurer::disable
                )
                .authorizeHttpRequests((au)->au
                        .requestMatchers( "/assets/**","/public/**","/","/login")
                        .permitAll()
                        .requestMatchers("/api/**")
                        .hasRole("ADMIN")
                        .requestMatchers("/account_apple")
                        .hasRole("ADMIN")
                        .requestMatchers("/user/**")
                        .hasAnyRole("ADMIN","USER")
                        .requestMatchers("/emran")
                        .hasRole("Manager")
                        .anyRequest().authenticated()

                )
                .httpBasic(Customizer.withDefaults())

//                .formLogin(login-> login
//                        .loginPage("/login")
//                        .usernameParameter("email")
//                        .passwordParameter("password")
//                        .defaultSuccessUrl("/")
//                        .permitAll()
//                )
                .logout(logout->logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                .userDetailsService(userDetailsService);

        return http.build();

    }


}
