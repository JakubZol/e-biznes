export const PRODUCT_CATEGORIES = [
    { url: '/balls', productType: 'BALLS', label: 'Piłki'},
    { url: '/shirts', productType: 'SHIRTS', label: 'Koszulki'},
    { url: '/trousers', productType: 'TROUSERS', label: 'Spodnie'},
    { url: '/shoes', productType: 'SHOES', label: 'Buty'},
    { url: '/hats', productType: 'HATS', label: 'Czapki'},
    { url: '/helmets', productType: 'HELMETS', label: 'Kaski'},
    { url: '/sweatbands', productType: 'SWEATBANDS', label: 'Frotki'},
    { url: '/gloves', productType: 'GLOVES', label: 'Rekawice'},
];

export const FETCH_STATUSES = {
    IDLE: 'IDLE',
    SUCCESS: 'SUCCESS',
    FAILURE: 'FAILURE',
};

const LOCAL_API = "http://localhost:9000";

const SERVER_API = "https://ebiznes-backend-scala.azurewebsites.net";

export const API_URL = SERVER_API;
