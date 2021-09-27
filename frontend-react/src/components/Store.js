import { PRODUCT_CATEGORIES } from "../consts";
import React, { useContext } from "react";
import { Route } from 'react-router-dom';
import ProductsPanel from "./ProductsPanel";
import UserPanel from "./UserPanel";
import Cart from "./Cart";
import useCart from "../hooks/useCart";
import UserContext from "../contexts/UserContext";
import WelcomePanel from "./WelcomePanel";
import Button from "./Button";

import '../store.scss';

const Store = () => {
    const { items, removeItem, addItem } = useCart();
    const { user, setUserToken } = useContext(UserContext);

    const logout = () => {
        localStorage.removeItem('authToken');
        setUserToken(undefined);
    };

    return (
    <div className="store__content">
        <div>
            <Route exact path="/store">
                <WelcomePanel user={user}/>
            </Route>
            <Route path={`/store/:category`} render={props =>
                <ProductsPanel {...props} addItem={addItem}/>
            }/>
        </div>
        <div className="store__side-panel">
            <UserPanel user={user}/>
            <Cart items={items} removeItem={removeItem} />
            <Button onClick={logout} label="Wyloguj się" />
        </div>
    </div>
)};

export default Store;
