import { useEffect, useState } from 'react';
import { FETCH_STATUSES } from "../consts";
import axios from 'axios';


const useFetch = (url, dependencies = []) => {
    const [status, setStatus] = useState(FETCH_STATUSES.IDLE);
    const [responseData, setResponseData] = useState([]);

    useEffect(() => {
        axios({
            method: 'get',
            url,
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
            }
        }).then(({ data }) => {
            setResponseData(data);
            setStatus(FETCH_STATUSES.SUCCESS);
        }).catch(() => {
            setStatus(FETCH_STATUSES.FAILURE);
        });
    }, dependencies);

    return { status, data: responseData };
};

export default useFetch;
