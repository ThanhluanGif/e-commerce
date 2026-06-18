package com.ecommerce.ecommerceapi.controller;


import com.ecommerce.ecommerceapi.entity.User;
import com.ecommerce.ecommerceapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private AuthService authService;

    // 1. API ĐĂNG KÝ TÀI KHOẢN (POST: http://localhost:8080/api/auth/register)
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUser = authService.register(user);
            return ResponseEntity.ok(Map.of("message", "Đăng ký tài khoản thành công!", "user", registeredUser));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // 2. API ĐĂNG NHẬP (POST: http://localhost:8080/api/auth/login)
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginRequest) {
        try {
            String username = loginRequest.get("username");
            String password = loginRequest.get("password");

            String token = authService.login(username, password);
            // Trả về chuỗi JWT Token bọc gọn gàng trong một JSON Object
            return ResponseEntity.ok(Map.of("token", token, "type", "Bearer"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
