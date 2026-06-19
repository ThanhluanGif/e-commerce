import React from 'react';
import { useParams, Link } from 'react-router-dom';

function ProductDetail() {
    const { id } = useParams(); // Lấy ID từ trên thanh URL xuống

    return (
        <div style={{ padding: '20px' }}>
            <Link to="/products" style={{ textDecoration: 'none', color: '#3498db' }}>&larr; Quay lại danh sách</Link>
            <div style={{ display: 'flex', gap: '40px', marginTop: '20px', border: '1px solid #ddd', padding: '25px', borderRadius: '10px' }}>
                <div style={{ width: '300px', height: '300px', background: '#f5f5f5', borderRadius: '8px' }}></div>
                <div>
                    <h2>Sản phẩm có ID: {id}</h2>
                    <p style={{ fontSize: '20px', color: 'red', fontWeight: 'bold', margin: '15px 0' }}>Giá sản phẩm mẫu</p>
                    <p style={{ color: '#666', lineHeight: '1.6' }}>Đây là phần mô tả chi tiết của sản phẩm công nghệ. Sau khi kết nối API từ Spring Boot, các thông tin này sẽ được lấy động hoàn toàn từ Database.</p>
                    <button style={{ background: '#e67e22', color: 'white', border: 'none', padding: '12px 25px', fontSize: '16px', borderRadius: '5px', marginTop: '20px', cursor: 'pointer' }}>
                        Thêm vào giỏ hàng
                    </button>
                </div>
            </div>
        </div>
    );
}
export default ProductDetail;