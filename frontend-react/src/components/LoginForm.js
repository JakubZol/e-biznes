import React, { useState, useContext } from 'react';
import { Form, Button } from "react-bootstrap";
import UserContext from "../contexts/UserContext";
import axios from 'axios';

const LoginForm = () => {
    const [login, setLogin] = useState();
    const [password, setPassword] = useState();

    const { setUserToken } = useContext(UserContext);

    return (
        <Form onSubmit={(event => {
            event.preventDefault()
        })} id="loginForm">
            <Form.Group className="mb-3" controlId="formBasicLogin">
                <Form.Label>Login: </Form.Label>
                <Form.Control type="text" placeholder="Enter login"
                              onChange={(event) => {
                                  setLogin(event.target.value)
                              }}/>
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Hasło: </Form.Label>
                <Form.Control type="password" placeholder="Password"
                              onChange={(event) => {
                                  setPassword(event.target.value)
                              }}/>
            </Form.Group>
            <Button variant="primary" type="submit" onClick={async () => {
                await axios({
                    method: 'post',
                    url: 'http://localhost:9000/login',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/json',
                    },
                    data: {
                        login,
                        password,
                    }
                }).then((response) => {
                    if (response.status === 200) {
                        setUserToken(response.headers['x-auth']);
                        localStorage.setItem("authToken", response.headers['x-auth']);
                    }
                }).catch((error) => {
                    console.log(error)
                });
            }}>
                Zaloguj
            </Button>
        </Form>
    )
};

export default LoginForm;
