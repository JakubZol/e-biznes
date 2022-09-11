export const getCookies = () => document.cookie.split("; ").reduce((currentCookies, cookieString) => {
    const cookieEntry = cookieString.split("=");

    return {
        ...currentCookies,
        [cookieEntry[0]]: decodeURI(cookieEntry[1]?.replace("+", " ")),
    };
}, {});

export const deleteCookie = cookieName => {
    document.cookie = `${cookieName}= ; expires = Thu, 01 Jan 1970 00:00:00 GMT`;
};
