import React from "react";
import { Link } from "react-router-dom";
import { PRODUCT_CATEGORIES } from "../consts";


const NavBar = () => (
    <nav>
        <ul className="store__navbar">
            {PRODUCT_CATEGORIES.map(({ url, label, productType }) => (
                <li className="store__navbar-link" key={`navbar-${productType}`}>
                    <Link to={url}>
                        {label}
                    </Link>
                </li>
            ))}
        </ul>
    </nav>
);


export default NavBar;
