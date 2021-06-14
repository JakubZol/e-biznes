import {PRODUCT_CATEGORIES} from "../consts";
import React, {useContext, useState} from "react";
import { Switch, Route } from 'react-router-dom';
import ProductsPanel from "./ProductsPanel";
import UserPanel from "./UserPanel";
import Cart from "./Cart";
import useCart from "../hooks/useCart";
import UserContext from "../contexts/UserContext";
import WelcomePanel from "./WelcomePanel";

const Store = () => {
    const { items, removeItem, addItem } = useCart();
    const [currentUser, setCurrentUser] = useState(undefined);
    const { users } = useContext(UserContext);

    return (
    <div className="store__content">
    <Switch>
        <Route exact path="/">
            <WelcomePanel currentUser={currentUser}/>
        </Route>
        {PRODUCT_CATEGORIES.map(productCategory => (
            <Route exact path={productCategory.url}>
                <ProductsPanel product={productCategory} addItem={addItem}/>
            </Route>
        ))}
    </Switch>
    <div className="store__side-panel">
        <UserPanel users={users} currentUser={currentUser} setCurrentUser={setCurrentUser}/>
        <Cart items={items} removeItem={removeItem} />
    </div>
    </div>
)};

export default Store;
