import { useState, useEffect } from 'react'
import axios from 'axios';
import { useParams } from "react-router-dom";

function ProductDetail() {

    const [product, setProduct] = useState(null);

    const { id } = useParams();

    const getProduct = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/dummy-api/products/${1}`);
            
            setProduct(response.data);
            console.log(response.data);
        } catch (error) {
            console.log(error);
        }
    }

    useEffect(() => {
        getProduct();
    }, [])
    

  return (
    <div>
        <h2>info on product</h2>
    </div>
  )
}

export default ProductDetail