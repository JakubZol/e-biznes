import React from 'react';
import { BrowserRouter as Router } from "react-router-dom";
import NavBar from './components/NavBar';
import Routing from './components/Routing';
import { UserContextProvider } from "./contexts/UserContext";

import './forms.scss';

function App() {
  return (
    <div className="App store">
      <UserContextProvider>
        <Router>
          <NavBar />
          <Routing />
        </Router>
      </UserContextProvider>
    </div>
  );
}

export default App;
