import React from 'react';

const UserPanel = ({ user }) => {

    return (
        <div className="store__user-panel">
            {user.login}
        </div>
    )
};

export default UserPanel;
