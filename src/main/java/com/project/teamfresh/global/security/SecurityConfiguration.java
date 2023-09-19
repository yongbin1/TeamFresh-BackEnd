package com.project.teamfresh.global.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web ->
                web.ignoring()
                        .requestMatchers("/swagger-ui/**", "/configuration/**", "/swagger-resources/**", "/v3/api-docs/**", "/webjars/**", "/webjars/springfox-swagger-ui/*.{js,css}", "/bus/v3/api-docs/**");
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .httpBasic(HttpBasicConfigurer::disable)
                .csrf(CsrfConfigurer::disable)
                .formLogin(FormLoginConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                        .requestMatchers("/swagger-ui/**", "/configuration/**", "/swagger-resources/**", "/v3/api-docs/**", "/webjars/**",
                                "/webjars/springfox-swagger-ui/*.{js,css}", "/bus/v3/api-docs/**").permitAll()

                        // Carrier 서버
                        .requestMatchers(HttpMethod.POST, "/carrier/**").permitAll() // 운송사 등록 API

                        // Driver 서버
                        .requestMatchers(HttpMethod.POST, "/driver/**").permitAll() // 기사 등록 API

                        // Customer 서버
                        .requestMatchers(HttpMethod.POST, "/customer/**").permitAll() // 고객사 등록 API

                        // Keeper 서버
                        .requestMatchers(HttpMethod.POST, "/keeper/**").permitAll() // 담당자 등록 API

                        // VOC 서버
                        .requestMatchers(HttpMethod.POST, "/voc/**").permitAll() // VOC 등록 API
                        .requestMatchers(HttpMethod.GET, "/voc/**").permitAll() // VOC 목록 API

                        // Compensation 서버
                        .requestMatchers(HttpMethod.POST, "/compensation/**").permitAll() // 배상정보 등록 API
                        .requestMatchers(HttpMethod.GET, "/compensation/**").permitAll() // 배상정보 목록 API

                        // Penalty 서버
                        .requestMatchers(HttpMethod.POST, "/penalty/**").permitAll() // 패널티 등록 API

                        .anyRequest().denyAll()
                );

        return http.build();
    }
}
