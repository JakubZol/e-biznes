import { useEffect, useState } from 'react';
import { FETCH_STATUSES } from "../consts";
import axios from 'axios';


const useFetch = (url, dependencies = []) => {
    const [status, setStatus] = useState(FETCH_STATUSES.IDLE);
    const [data, setData] = useState([]);

    useEffect(() => {
        axios({
            method: 'get',
            url,
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
            }
        }).then(({ data }) => {
            setData(data);
            setStatus(FETCH_STATUSES.SUCCESS);
        }).catch(() => {
            setStatus(FETCH_STATUSES.FAILURE);
        });
    }, dependencies);

    return { status, data };
};

export default useFetch;
