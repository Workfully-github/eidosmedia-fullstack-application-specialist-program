import styles from "../Recommendation/Recommendation.module.css";
import Card from "../Card/Card";
import SkeletonCard from "../Card/SkeletonCard";
import useFetch from "../../ApiCall/call";
import { useStateContext } from '../Context/StateContext'
import Cards from "../Cards/Cards";
import { useEffect, useState } from "react";
function Recommendation(props) {
  const { isLoading } = useStateContext();
  const id = props.productId;
  const BASE_URL = "https://eidos-api.herokuapp.com/api/v1/products/category/";
  const url = BASE_URL + props.category
  const { data } = useFetch(url)
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



  return (
    <div className={styles.recommendationSection}>
      <h2>People also viewed:</h2>
      <div className={styles.recommendationCards}>
        <Cards notThisOne={id} data ={ data?.products} />
        {/* {!isLoading
          ? data?.products?.map(
            (product) =>
              id !== product.id && (
                <Card key={product.id} cardDetail={product} />
              )
          )
          : skeletonArr.map((skeleton) => <SkeletonCard />)} */}
      </div>
    </div>
  );
}

export default Recommendation;
