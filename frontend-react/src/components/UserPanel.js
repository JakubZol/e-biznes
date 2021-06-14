import React from 'react';

const UserPanel = ({ users, setCurrentUser, currentUser }) => {

    const onUserSelect = ({ target }) => {
        setCurrentUser(users.find(({ login }) => login === target.value))
    };

    return (
        <div className="store__user-panel">
            Wybierz użytkownika
            {' '}
            <select onChange={onUserSelect}>
                <option>--</option>
                {users.map(user => <option>{user.login}</option>)}
            </select>
            {currentUser && <div className="store__user-data">
                Zalogowany użytkownik:
                <div><b> {currentUser.login} </b></div>
                <div> {currentUser.firstname} {currentUser.lastname} </div>
                <div> {currentUser.age} lat(a)</div>
            </div>}
        </div>
    )
};

export default UserPanel;
