import React from 'react'
import { Redirect, Route } from 'react-router-dom';

const ProtectedRoute = ({ exact, path, isAuthenticated = false, authenticationRequired = false, component: Component, componentProps }) => {

    const routeRender = props => (
        authenticationRequired === isAuthenticated ? (
            <Component {...{...props, ...componentProps}} />
        ) : (
            <Redirect to={{
                pathname: authenticationRequired ? '/login' : '/',
                state: props.location,
            }}/>
        )
    );

    return <Route exact={exact} path={path} component={routeRender} />
};

export default ProtectedRoute;
