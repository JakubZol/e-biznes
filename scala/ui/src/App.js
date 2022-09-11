import React from 'react';
import { BrowserRouter as Router } from "react-router-dom";
import NavBar from './components/NavBar';
import Store from './components/Store';
import { UserContextProvider } from "./contexts/UserContext";
import { getCookies } from "./shared/utils";

import './store.scss';

function App() {
    const cookies = getCookies();
    const isAuthenticated = !!cookies.fullName && !!cookies.email;

  return (
    <div className="App store">
      <UserContextProvider>
        <Router>
          <NavBar isAuthenticated={isAuthenticated} />
          <Store isAuthenticated={isAuthenticated} />
        </Router>
      </UserContextProvider>
    </div>
  );
}

export default App;
