package com.ecommerce.ecommerceapi.entity;

import  lombok.*;
import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String name;
    @Column(columnDefinition = "TEXT" )
    private String description;

    @Column(nullable = false,precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false,name = "stock_quantity")
    private Integer stockQuantity;

    @Column(name = "image_url", length = 500) // Khớp với VARCHAR(50...) trong sơ đồ của bạn
    private String imageUrl;

    // --- CẤU HÌNH MỐI QUAN HỆ KHÓA NGOẠI ---
    // Nhiều sản phẩm thuộc về một danh mục (Category)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false) // Tự động ánh xạ cột category_id dưới database
    private Category category;
}
