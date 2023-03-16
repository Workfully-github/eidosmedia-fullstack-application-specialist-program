import { useState, useEffect } from "react";
import styles from "../Recommendation/Recommendation.module.css";
import { ProductCall } from "../../ApiCall/ProductCall";
import Card from "../Card/Card";
import SkeletonCard from "../Card/SkeletonCard";

function Recommendation({ categoryProduct, productId }) {
  const category = categoryProduct;
  const id = productId;

  const BASE_URL = "https://eidos-api.herokuapp.com/api/v1/products/category/";

  const [products, setProducts] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  const skeletonArr = [
    "I am",
    "gonna",
    "impliment",
    "this",
    "skeleton",
    "loader",
    "later",
    "in",
    "another",
    "way",
    "trust",
    "me",
  ];

  const getProducts = async () => {
    const response = await ProductCall.get(BASE_URL + `${category}`);
    return response.products;
  };

  useEffect(() => {
    setIsLoading(true);
    getProducts().then((res) => {
      if (res.length > 4) setProducts(res.slice(0, 5));
      else setProducts(res);
      setIsLoading(false);
    });
  }, [products]);

  return (
    <div className={styles.recommendationSection}>
      <h2>People also viewed:</h2>
      <div className={styles.recommendationCards}>
        {!isLoading
          ? products?.map(
              (product) =>
                id !== product.id && (
                  <Card key={product.id} cardDetail={product} />
                )
            )
          : skeletonArr.map((skeleton) => <SkeletonCard />)}
      </div>
    </div>
  );
}

export default Recommendation;
