package com.ecommerce.ecommerceapi.service;


import com.ecommerce.ecommerceapi.entity.User;
import com.ecommerce.ecommerceapi.repository.UserRepository;
import com.ecommerce.ecommerceapi.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    // 1. Xử lý Đăng ký tài khoản
    public User register(User user) {

        //  Kiểm tra trống dữ liệu
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new RuntimeException("Tên đăng nhập không được để trống!");
        }
        if (user.getPasswordHash() == null || user.getPasswordHash().length() < 6) {
            throw new RuntimeException("Mật khẩu phải có ít nhất 6 ký tự!");
        }

        //  Kiểm tra trùng lặp (Code cũ đã có)
        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại!");
        }
        // Kiểm tra xem Username hoặc Email đã bị trùng chưa
        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Tên đăng nhập đã tồn tại!");
        }
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email đã được đăng ký!");
        }

        // BĂM MẬT KHẨU trước khi lưu xuống Database để bảo mật thông tin
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));

        return userRepository.save(user);
    }

    // 2. Xử lý Đăng nhập -> Trả về chuỗi Token JWT
    public String login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Tài khoản hoặc mật khẩu không chính xác!"));

        // So khớp mật khẩu thô người dùng gõ với chuỗi mật khẩu đã băm dưới DB
        if (!passwordEncoder.matches(password, user.getPasswordHash())) {
            throw new RuntimeException("Tài khoản hoặc mật khẩu không chính xác!");
        }

        // Đăng nhập đúng -> Gọi JwtProvider sinh Token trả về cho khách
        return jwtProvider.generateToken(username);
    }

}
