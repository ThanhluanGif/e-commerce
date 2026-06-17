package com.ecommerce.ecommerceapi.entity;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRole, String> {
    @Override
    public String convertToDatabaseColumn(UserRole attribute) {
        if (attribute == null) return null;
        // Khi lưu xuống DB: Nếu trong Java là ADMIN -> Biến thành "Admin", CUSTOMER -> "Customer"
        return attribute == UserRole.ADMIN ? "Admin" : "Customer";
    }

    @Override
    public UserRole convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        // Khi đọc từ DB lên Java: Nếu dưới DB là "Admin" -> Trả về ADMIN, "Customer" -> Trả về CUSTOMER
        if (dbData.equalsIgnoreCase("Admin")) return UserRole.ADMIN;
        if (dbData.equalsIgnoreCase("Customer")) return UserRole.CUSTOMER;
        throw new IllegalArgumentException("Quyền " + dbData + " không hợp lệ!");
    }
}
