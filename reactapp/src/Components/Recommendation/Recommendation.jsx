import { useState, useEffect } from "react";
import styles from "../Recommendation/Recommendation.module.css";
import { ProductCall } from "../../ApiCall/ProductCall";
import { Card } from "reactstrap";

function Recommendation({categoryProduct}) {

    const category  = categoryProduct;

    const BASE_URL = "https://eidos-api.herokuapp.com/api/v1/products/category/";

    const [products, setProducts] = useState([]);

    const getProducts = async () => {
        const response = await ProductCall.get(BASE_URL + `${category}`);
        console.log(response)
        return response.products;
    }

    useEffect(() => {
        getProducts().then((res) => {
            setProducts(res);
            console.log(res)
        });
    }, []);


  return (
    <div>
        <h2>People also viewed:</h2>
        <div>
            {products && products.map((product) => (
                <Card key={product.id} props={product} />
            ))}
        </div>
    </div>
  );    
}

export default Recommendation;
