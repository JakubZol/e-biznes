import { PRODUCT_CATEGORIES } from "../shared/consts";
import React from "react";
import { Switch, Redirect } from 'react-router-dom';
import ProductsPanel from "./ProductsPanel";
import Home from '../components/Home';
import WelcomePanel from "./WelcomePanel";
import ProtectedRoute from "../routing/ProtectedRoute";
import useCart from "../hooks/useCart";


const Store = ({ isAuthenticated }) => {
    const { items, removeItem, addItem } = useCart();

    return (
        <Switch>
            <ProtectedRoute path="/login" component={Home} isAuthenticated={isAuthenticated} />
            <ProtectedRoute exact path="/" component={WelcomePanel} authenticationRequired isAuthenticated={isAuthenticated} />
            {PRODUCT_CATEGORIES.map(productCategory =>
                <ProtectedRoute key={`product-${productCategory.productType}`} path={productCategory.url} component={ProductsPanel} componentProps={{ product: productCategory, addItem, items, removeItem }} isAuthenticated={isAuthenticated} authenticationRequired />
            )}
            <Redirect from="*" to="/" />
        </Switch>
)};


export default Store;
