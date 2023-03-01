package com.mycompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

//@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

    @Autowired
    private UserDetailsService userDetailsService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private AuthenticationEntryPoint unauthorizedHandler;
//
//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter() {
//        return new JwtAuthenticationFilter();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests().antMatchers("/login**").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/usersm").hasAnyAuthority("USER", "ADMIN")
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/login").permitAll();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {

//        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector).servletPath("/path");
//        http
//                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers(mvcMatcherBuilder.pattern("/users")).hasRole("ADMIN")
//                        .requestMatchers(mvcMatcherBuilder.pattern("/usersm")).hasRole("USER")
//                        .anyRequest().authenticated()
//                ).formLogin().loginPage("/login").defaultSuccessUrl("/usersm", false).permitAll()
//                .and().csrf().disable();
        http
//                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/usersm*").hasRole("ADMIN")
                .requestMatchers("/users*").permitAll()
                .requestMatchers("/filter*").hasRole("ADMIN")
//                .requestMatchers("/anonymous*")
//                .anonymous()
//                .requestMatchers("/login*").permitAll().anyRequest().authenticated()
//                .requestMatchers("/usersm*").permitAll().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/usersm", false)
                .permitAll()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/homepage.html", true)
//                .failureUrl("/login.html?error=true")
//                .failureHandler(authenticationFailureHandler())
                .and()
                .logout().logoutSuccessUrl("/login?logout").permitAll();
//                .logoutUrl("/perform_logout")
//                .deleteCookies("JSESSIONID")
//                .logoutSuccessHandler(logoutSuccessHandler());
        return http.build();
    }

}
