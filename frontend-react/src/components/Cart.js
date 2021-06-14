import React from 'react';
import Button from './Button';

const Cart = ({ items, removeItem }) => {
    const fullPrice = items.reduce((currentPrice, { price, amount }) => currentPrice + amount * price, 0);

    return (
        <div>
            {items.length > 0 ?
                <ul className="store__cart">
                    <h4>Zawartość koszyka:</h4>
                    {items.map(item => (
                        <li>
                            {item.name} ({item.amount})
                            <Button onClick={() => removeItem(item.id)} label="Usuń" />
                        </li>
                    ))}
                    <div className="store__final-price">Łączna Cena: {fullPrice} PLN</div>
                </ul> :
                <h4>Koszyk jest pusty.</h4>
            }
        </div>
    );
};

export default Cart;
