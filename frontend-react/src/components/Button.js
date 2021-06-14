import React from 'react';


const Button = ({ label, onClick }) => (
    <button onClick={onClick} className="store__button">
        {label}
    </button>
);

export default Button;
