package com.syqu.shop.config;

import com.syqu.shop.repository.UserRepository;
import com.syqu.shop.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final UserRepository userRepository;

    @Autowired
    public WebSecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(userRepository);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/", "/home", "/index", "/about", "/help", "/register", "/cart/**").permitAll()
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers("/admin/**", "/product/new").hasRole("ADMIN")
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login").permitAll()
                )

                .logout(logout -> logout
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
//                        .headers().frameOptions().sameOrigin();
                );

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(
                "/webjars/**", "/js/**", "/error/**", "/css/**", "/fonts/**", "/libs/**", "/img/**", "/h2-console/**");
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//    }
}
