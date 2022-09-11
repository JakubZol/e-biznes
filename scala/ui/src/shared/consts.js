export const PRODUCT_CATEGORIES = [
    { url: '/balls', endpoint: '/service/balls', productType: 'BALLS', label: 'Piłki'},
    { url: '/shirts', endpoint: '/service/shirts', productType: 'SHIRTS', label: 'Koszulki'},
    { url: '/trousers', endpoint: '/service/trousers', productType: 'TROUSERS', label: 'Spodnie'},
    { url: '/shoes', endpoint: '/service/shoes', productType: 'SHOES', label: 'Buty'},
    { url: '/hats', endpoint: '/service/hats', productType: 'HATS', label: 'Czapki'},
    { url: '/helmets', endpoint: '/service/helmets', productType: 'HELMETS', label: 'Kaski'},
    { url: '/sweatbands', endpoint: '/service/sweatbands', productType: 'SWEATBANDS', label: 'Frotki'},
    { url: '/gloves', endpoint: '/service/gloves', productType: 'GLOVES', label: 'Rekawice'},
];

export const FETCH_STATUSES = {
    IDLE: 'IDLE',
    SUCCESS: 'SUCCESS',
    FAILURE: 'FAILURE',
};

export const LOGIN_PATH_DEV = 'http://localhost:3000/login';
export const LOGIN_PATH_PROD = "https://ebiznes2022.azurewebsites.net";

export const SERVER_ENDPOINT_DEV = 'http://localhost:9000';
export const LOGIN_ENDPOINT_DEV = `${SERVER_ENDPOINT_DEV}/service/authenticate/facebook`;
export const LOGOUT_ENDPOINT_DEV = `${SERVER_ENDPOINT_DEV}/service/signout`;

export const SERVER_ENDPOINT_PROD = "https://ebiznes2022.azurewebsites.net";
export const LOGIN_ENDPOINT_PROD = `${SERVER_ENDPOINT_PROD}/service/authenticate/facebook`;
export const LOGOUT_ENDPOINT_PROD = `${SERVER_ENDPOINT_PROD}/service/signout`;
