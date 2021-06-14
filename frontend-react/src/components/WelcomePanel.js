import React from 'react';


const WelcomePanel = ({ currentUser }) => (
    <div className="store__welcome">
        <h1>Witaj {currentUser && `${currentUser.firstname} ${currentUser.lastname}`}!</h1>
        Zapraszamy do naszego sklepu.
    </div>
);

export default WelcomePanel;
