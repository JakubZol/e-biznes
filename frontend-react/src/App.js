import React from 'react';
import { BrowserRouter as Router } from "react-router-dom";
import NavBar from './components/NavBar';
import Store from './components/Store';
import { UserContextProvider } from "./contexts/UserContext";

import './store.scss';

function App() {
  return (
    <div className="App store">
      <UserContextProvider>
        <Router>
          <NavBar />
          <Store />
        </Router>
      </UserContextProvider>
    </div>
  );
}

export default App;
