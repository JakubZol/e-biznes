import React, { useState } from "react";
import useFetch from "../hooks/useFetch";
import { API_URL } from '../consts';

export const UserContext = React.createContext();


export const UserContextProvider = ({ children }) => {
    const [ userToken, setUserToken ] = useState(localStorage.getItem('authToken'));

    const { data: user } = useFetch(`${API_URL}/users`, [userToken], { 'X-Auth': userToken });

    const providerValue = {
        user,
        setUserToken,
    };

    return (
        <UserContext.Provider value={providerValue}>{children}</UserContext.Provider>
    );
};

export default UserContext;
