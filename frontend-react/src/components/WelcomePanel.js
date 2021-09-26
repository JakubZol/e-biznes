import React from 'react';


const WelcomePanel = ({ user }) => (
    <div className="store__welcome">
        <h1>Witaj {user && `${user.firstname} ${user.lastname}`}!</h1>
        Zapraszamy do naszego sklepu.
    </div>
);

export default WelcomePanel;
