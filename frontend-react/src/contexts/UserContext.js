import React, { useState } from "react";
import useFetch from "../hooks/useFetch";

export const UserContext = React.createContext();


export const UserContextProvider = ({ children }) => {
    const [ userToken, setUserToken ] = useState(localStorage.getItem('authToken'));

    const { data: user } = useFetch(`http://localhost:9000/users`, [userToken], { 'X-Auth': userToken });

    const providerValue = {
        user,
        setUserToken,
    };

    return (
        <UserContext.Provider value={providerValue}>{children}</UserContext.Provider>
    );
};

export default UserContext;
