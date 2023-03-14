import { useState, useEffect } from 'react'
import { useParams } from "react-router-dom";
import { ProductCall } from '../../ApiCall/ProductCall';

function ProductDetail() {

    const BASE_URL = 'https://dummyjson.com/products/';

    const [product, setProduct] = useState(null);

    const { id } = useParams();

    const getProductDetail = async (id) => {
        const data = await ProductCall.get(BASE_URL + `${id}`);
        return data;
    }

    useEffect(() => {
        getProductDetail(id).then((res) => {
            console.log(res);
            setProduct(res);
        });
    }, [])
    

  return (
    <div>
        <h2>info on product</h2>
        {product && <h3>{product.id}</h3>}
        {product && <h3>{product.title}</h3>}
    </div>
  )
}

export default ProductDetail