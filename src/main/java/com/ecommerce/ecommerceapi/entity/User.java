package com.ecommerce.ecommerceapi.entity;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(nullable = false, length = 255,name = "password_hash")
    private String passwordHash;

    @Column(nullable = false,length = 150,unique = true)
    private String email;

    // Định nghĩa kiểu ENUM lưu xuống database dưới dạng chuỗi (String) thay vì số thứ tự
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @Column(columnDefinition = "TEXT")
    private String address; // TEXT tương ứng với String nhưng dung lượng lưu trữ lớn hơn

    @Column(length = 20)
    private String phone;

}
