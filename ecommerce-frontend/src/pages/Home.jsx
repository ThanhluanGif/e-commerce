import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
    return (
        <div style={{ padding: '20px', textAlign: 'center' }}>
            <div style={{ background: '#3498db', color: 'white', padding: '40px', borderRadius: '10px', marginBottom: '30px' }}>
                <h1>Chào mừng đến với TechStore 2026</h1>
                <p>Trải nghiệm không gian mua sắm thiết bị công nghệ đỉnh cao.</p>
                <Link to="/products">
                    <button style={{ padding: '10px 20px', background: '#fff', color: '#3498db', border: 'none', borderRadius: '5px', fontWeight: 'bold', cursor: 'pointer' }}>
                        Mua sắm ngay
                    </button>
                </Link>
            </div>
        </div>
    );
}
export default Home;