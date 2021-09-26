import React, {useContext} from "react";
import { Link } from "react-router-dom";
import { PRODUCT_CATEGORIES } from "../consts";
import UserContext from "../contexts/UserContext";


const NavBar = () => {
    const { user } = useContext(UserContext);

    const isAuthenticated = !!user;

    return (
    <nav>
        <ul className="store__navbar">
            {isAuthenticated && PRODUCT_CATEGORIES.map(({ url, label, productType }) => (
                <li className="store__navbar-link" key={`navbar-${productType}`}>
                    <Link to={`/store${url}`}>
                        {label}
                    </Link>
                </li>
            ))}
            {!isAuthenticated && <>
                <li className="store__navbar-link">
                    <Link to="/login">Logowanie</Link>
                </li>
                <li className="store__navbar-link">
                    <Link to="/register">Rejestracja</Link>
                </li>
            </>}
        </ul>
    </nav>
)};


export default NavBar;
