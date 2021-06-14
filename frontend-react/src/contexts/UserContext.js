import React from "react";
import useFetch from "../hooks/useFetch";

const defaultValue = {
    users: []
};

export const UserContext = React.createContext(defaultValue);


export const UserContextProvider = ({ children }) => {
    const { data: users } = useFetch(`http://localhost:9000/users`);

    const providerValue = {
        users,
    };

    return (
        <UserContext.Provider value={providerValue}>{children}</UserContext.Provider>
    );
};

export default UserContext;
