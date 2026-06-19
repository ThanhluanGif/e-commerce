import React from 'react';
import { Link } from 'react-router-dom';

// Dữ liệu mẫu (Mock data) phục vụ dựng giao diện trước khi kết nối API từ Spring Boot
const mockProducts = [
    { id: 1, name: "iPhone 15 Pro Max", price: "30.000.000 đ" },
    { id: 2, name: "MacBook Pro M3", price: "45.000.000 đ" },
    { id: 3, name: "Samsung S24 Ultra", price: "27.000.000 đ" }
];

function ProductList() {
    return (
        <div style={{ padding: '20px' }}>
            <h2 style={{ marginBottom: '20px' }}>Danh sách sản phẩm</h2>
            <div style={{ display: 'grid', gridTemplateColumns: 'repeat(3, 1fr)', gap: '20px' }}>
                {mockProducts.map(p => (
                    <div key={p.id} style={{ border: '1px solid #ddd', padding: '15px', borderRadius: '8px', textAlign: 'center' }}>
                        <div style={{ width: '100%', height: '150px', background: '#f5f5f5', marginBottom: '10px', borderRadius: '5px' }}></div>
                        <h3>{p.name}</h3>
                        <p style={{ color: 'red', fontWeight: 'bold' }}>{p.price}</p>
                        <Link to={`/products/${p.id}`}>
                            <button style={{ background: '#2c3e50', color: 'white', border: 'none', padding: '8px 15px', borderRadius: '4px', cursor: 'pointer' }}>
                                Xem chi tiết
                            </button>
                        </Link>
                    </div>
                ))}
            </div>
        </div>
    );
}
export default ProductList;