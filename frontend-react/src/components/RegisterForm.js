import React, { useState } from 'react';
import { Form, Button } from "react-bootstrap";
import axios from 'axios';

const RegisterForm = () => {
    const [login, setLogin] = useState();
    const [firstname, setFirstName] = useState();
    const [lastname, setLastName] = useState();
    const [age, setAge] = useState();
    const [password, setPassword] = useState();
    const [registerMessage, setRegisterMessage] = useState();

    return (
        <div>
            <h2>{registerMessage}</h2>
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
                <Form.Group className="mb-3" controlId="formBasicFirstName">
                    <Form.Label>Imię: </Form.Label>
                    <Form.Control type="text" placeholder="Enter first name"
                                  onChange={(event) => {
                                      setFirstName(event.target.value)
                                  }}/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicLastName">
                    <Form.Label>Nazwisko: </Form.Label>
                    <Form.Control type="text" placeholder="Enter last name"
                                  onChange={(event) => {
                                      setLastName(event.target.value)
                                  }}/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicAge">
                    <Form.Label>Wiek: </Form.Label>
                    <Form.Control type="number" placeholder="Enter age"
                                  onChange={(event) => {
                                      setAge(event.target.value)
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
                        url: 'http://localhost:9000/register',
                        headers: {
                            'Content-Type': 'application/json',
                            'Accept': 'application/json',
                        },
                        data: {
                            login,
                            password,
                            firstname,
                            lastname,
                            age: Number(age),
                        }
                    }).then((response) => {
                        if (response.status === 200) {
                            setRegisterMessage("Udana rejestracja. Teraz możesz się zalogować")
                        }
                    }).catch(() => {
                        setRegisterMessage("Nieudana rejestracja.")
                    });
                }}>
                    Zarejestruj się
                </Button>
            </Form>
        </div>
    )
};

export default RegisterForm;
