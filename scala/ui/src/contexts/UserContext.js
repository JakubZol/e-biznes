import React from "react";
import { getCookies } from "../shared/utils";

const defaultValue = {
    currentUser: undefined,
};

export const UserContext = React.createContext(defaultValue);


export const UserContextProvider = ({ children }) => {

    const cookies = getCookies();

    const providerValue = {
        currentUser: { email: cookies.email, fullName: cookies.fullName },
    };

    return (
        <UserContext.Provider value={providerValue}>{children}</UserContext.Provider>
    );
};

export default UserContext;
