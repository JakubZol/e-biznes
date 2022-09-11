import React from 'react';
import Product from "./Product";
import useFetch from '../hooks/useFetch';
import { FETCH_STATUSES, SERVER_ENDPOINT_PROD } from "../shared/consts";
import Cart from "./Cart";


const ProductsPanel = ({ product, items, removeItem, addItem }) => {
    const { data: productsList, status } = useFetch(`${SERVER_ENDPOINT_PROD}${product.endpoint}`, [product]);

    return (
        <div className="store__content">
            <div className="store__main">
                <h1>{product.label}</h1>
                {status === FETCH_STATUSES.IDLE && <h3>Pobieranie danych...</h3>}
                {status === FETCH_STATUSES.SUCCESS && productsList.length > 0 &&
                    <ul className="store__items">
                        {productsList.map(productData => (
                            <Product key={`${productData.id}-${productData.name}-${productData.brand}`} product={productData} addItem={addItem}/>
                        ))}
                    </ul>
                }
                {status === FETCH_STATUSES.SUCCESS && productsList.length === 0 &&
                    <div>
                        <h3>Brak produktów w sprzedaży.</h3>
                    </div>
                }
                {status === FETCH_STATUSES.FAILURE && <div>Coś poszło nie tak :(</div>}
            </div>

            <div className="store__side-panel">
                <Cart items={items} removeItem={removeItem} />
            </div>
        </div>
    )
};

export default ProductsPanel;
