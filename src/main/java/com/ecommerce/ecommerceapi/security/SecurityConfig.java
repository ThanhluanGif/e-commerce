package com.ecommerce.ecommerceapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // Cấu hình mã hóa mật khẩu theo chuẩn BCrypt (Mật khẩu dưới DB sẽ lưu chuỗi băm dạng $2a$10$...)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Cấu hình mới cho CORS và CSRF (Dùng Lambda thay vì .and())
                .cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        // Truyền mảng các String trực tiếp vào requestMatchers chuẩn mã mới
                        .requestMatchers("/api/auth/**", "/api/categories/**", "/api/products/**").permitAll()
                        // Tất cả các request khác cần xác thực
                        .anyRequest().authenticated()
                )
                // Bật cấu hình basic authentication cơ bản theo chuẩn mới
                .httpBasic(Customizer.withDefaults());

        return http.build();
        }
}
