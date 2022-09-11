import React, {useContext} from "react";
import { Link } from "react-router-dom";
import { LOGOUT_ENDPOINT_PROD, PRODUCT_CATEGORIES } from "../shared/consts";
import UserContext from "../contexts/UserContext";
import { deleteCookie } from "../shared/utils";


const NavBar = ({ isAuthenticated }) => {
    const logOut = () => {
        deleteCookie("email");
        deleteCookie("fullName");

        window.location.replace(LOGOUT_ENDPOINT_PROD)
    };

    const { currentUser } = useContext(UserContext);

    return (
        <nav>
            <div className="store__navbar">
                {isAuthenticated && <>
                    <ul>
                        {PRODUCT_CATEGORIES.map(({ url, label, productType }) => (
                            <li key={`navbar-link-${productType}`} className="store__navbar-link" >
                                <Link to={url}>
                                    {label}
                                </Link>
                            </li>
                        ))}
                    </ul>
                    <div className="store__navbar-user-section">
                        <div>{currentUser.fullName} | {currentUser.email}</div>
                        <button className="store__logout-button" onClick={logOut}>Wyloguj się</button>
                    </div>
                </>}
            </div>
        </nav>
    );
};


export default NavBar;
