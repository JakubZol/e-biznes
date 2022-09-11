import React from 'react';
import { Switch, Route, Redirect } from 'react-router-dom';
import ProtectedRoute from './ProtectedRoute';
import Home from "../components/Home";
import WelcomePanel from "../components/WelcomePanel";


const Main = () => {
    const cookies = document.cookie.split("; ").reduce((currentCookies, cookieString) => {
        const cookieEntry = cookieString.split("=");

        return {
            ...currentCookies,
            [cookieEntry[0]]: cookieEntry[1]?.replace("+", " "),
        };
    }, {});

    const isAuthenticated = !!cookies.fullName && !!cookies.email;

    return (
        <Switch>
            <ProtectedRoute path="/login" component={Home} isAuthenticated={isAuthenticated} />
            <ProtectedRoute exact path="/" component={WelcomePanel} authenticationRequired isAuthenticated={isAuthenticated} componentProps={{ currentUser: { email: cookies.email, fullName: cookies.fullName } }}/>
        </Switch>
    );
};


export default Main;
