import React, { useContext } from 'react';
import UserContext from '../contexts/UserContext'
import LoginForm from './LoginForm';
import RegisterForm from './RegisterForm';
import ProtectedRoute from './ProtectedRoute';
import { Switch, Route, Redirect } from 'react-router-dom';
import Store from "./Store";

const Routing = () => {
    const { user } = useContext(UserContext);

    const isAuthenticated = !!user;

    return (
        <Switch>
            <Redirect exact from="/" to="/login" />
            <ProtectedRoute path="/login" component={LoginForm} isAuthenticated={isAuthenticated} authenticationRequired={false}/>
            <ProtectedRoute path="/register" component={RegisterForm} isAuthenticated={isAuthenticated} authenticationRequired={false}/>
            <ProtectedRoute path="/store" component={Store} isAuthenticated={isAuthenticated} authenticationRequired/>
            <Route component={() => <div>NO CONTENT</div>} />
        </Switch>
    )
};

export default Routing;
