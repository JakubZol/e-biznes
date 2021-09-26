import React from 'react'
import { Redirect, Route } from 'react-router-dom';

const ProtectedRoute = ({ isAuthenticated, path, authenticationRequired, componentProps, component: Component, exact = true }) => {

    const routeRender = props => (
        authenticationRequired === isAuthenticated ? (
            <Component {...{...props, ...componentProps}} />
        ) : (
            <Redirect to={{
                pathname: authenticationRequired ? '/login' : '/store',
                state: props.location,
            }}/>
        )
    );

    return <Route exact={exact} path={path} component={routeRender} />
};

export default ProtectedRoute;
