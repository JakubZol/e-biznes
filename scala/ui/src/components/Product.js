import React from 'react';
import Button from './Button';

const Product = ({ product, addItem }) => {

    const addItemToCart = () => addItem(product);

    return (
        <li className="store__item">
            <div>
                <b>{product.name}</b>
            </div>
            <div>Producent: {product.brand} </div>
            {product.size && <div>Rozmiar: {product.size}</div>}
            <div>Cena: {product.price} PLN</div>
            <Button onClick={addItemToCart} label="Dodaj do koszyka" />
        </li>
    );
};

export default Product;
