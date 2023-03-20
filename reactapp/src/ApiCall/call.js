import axios from "axios";
import { useEffect, useState } from "react";
import { useStateContext } from '../Components/Context/StateContext'

const useFetch = (url) => {
    const { setIsLoading } = useStateContext();
    const [data, setData] = useState(null);
    
    useEffect(() => {
        const callApi = async (url) => {
            try {
                setIsLoading(true)
                const res = await axios.get(url)
                setData(res.data)
                setIsLoading(false)
            } catch (error) {
                console.error(error);
            }
        }
        callApi(url)
    }, [url, setIsLoading])
    return { data }
}

export default useFetch