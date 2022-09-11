import React, { useContext } from 'react';
import UserContext from "../contexts/UserContext";


const WelcomePanel = () => {
    const { currentUser } = useContext(UserContext);

    return (
        <div className="store__welcome">
            <h1>Witaj {currentUser && `${currentUser.fullName} ${(currentUser.email)}`}!</h1>
            Zapraszamy do naszego sklepu.
        </div>
    );
};


export default WelcomePanel;
