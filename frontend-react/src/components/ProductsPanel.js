import React from 'react';
import Product from "./Product";
import useFetch from '../hooks/useFetch';
import {FETCH_STATUSES, PRODUCT_CATEGORIES, API_URL} from "../consts";


const ProductsPanel = ({ match, addItem }) => {
    const product = PRODUCT_CATEGORIES.find(({ productType }) => productType === match.params.category.toUpperCase());

    const { data: productsList, status } = useFetch(`${API_URL}${product?.url}`, [product]);

    return (
        <div className="store__main">
            <h1>{product?.label}</h1>
            {status === FETCH_STATUSES.IDLE && <h3>Pobieranie danych...</h3>}
            {status === FETCH_STATUSES.SUCCESS && productsList.length > 0 &&
                <ul className="store__items">
                    {productsList.map(productData => (
                        <Product product={productData} addItem={addItem}/>
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
    )
};

export default ProductsPanel;
