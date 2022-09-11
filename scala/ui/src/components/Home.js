import React from 'react';
import { LOGIN_ENDPOINT_PROD } from "../shared/consts";

const Home = () => {

    const logIn = () => window.location.replace(LOGIN_ENDPOINT_PROD);

    return (
        <div className="store__login-page">
            <button className="store__login-button" onClick={logIn}>Zaloguj się przez facebooka</button>
        </div>
    )
};

export default Home;
