import React from 'react';
import { Link } from 'react-router-dom';

function Navbar() {
    return (
        <nav style={{ background: '#2c3e50', padding: '15px', color: '#fff', display: 'flex', gap: '20px' }}>
            <Link to="/" style={{ color: '#fff', textDecoration: 'none', fontWeight: 'bold' }}>TechStore</Link>
            <Link to="/" style={{ color: '#fff', textDecoration: 'none' }}>Trang Chủ</Link>
            <Link to="/products" style={{ color: '#fff', textDecoration: 'none' }}>Sản Phẩm</Link>
        </nav>
    );
}
export default Navbar;
