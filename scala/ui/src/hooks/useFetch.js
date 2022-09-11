import { useEffect, useState } from 'react';
import { FETCH_STATUSES } from "../shared/consts";
import axios from 'axios';


const useFetch = (url, dependencies = [], headers = {}) => {
    const [status, setStatus] = useState(FETCH_STATUSES.IDLE);
    const [responseData, setResponseData] = useState(undefined);

    useEffect(() => {
        axios({
            method: 'get',
            url,
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
                ...headers
            }
        }).then(({ data }) => {
            setResponseData(data);
            setStatus(FETCH_STATUSES.SUCCESS);
        }).catch(() => {
            setResponseData(undefined);
            setStatus(FETCH_STATUSES.FAILURE);
        });
    }, dependencies);

    return { status, data: responseData };
};

export default useFetch;
