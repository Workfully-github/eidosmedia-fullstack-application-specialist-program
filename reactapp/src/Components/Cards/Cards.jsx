import React, { Suspense, useEffect, useState } from 'react'
import axios from 'axios'
import styles from './Cards.module.css'
import SkeletonCard from '../Card/SkeletonCard'
import { useStateContext } from "../Context/StateContext"
import { lazy } from 'react';
const Card = lazy(() => import('../Card/Card'));

const Cards = (props) => {
  const {url} = useStateContext();

  const [productList, setProductList] = useState(null);
  const [isLoading, setIsLoading] = useState(true);


  const getProductList = async (url) => {
    setIsLoading(true)
    const response = await axios.get(url);
    //if(props.filterType==="stock") {
      //filter the list of products before set the state here
      // var products = response.data.products.filter(p => {return p.stock==props.stockQuery})
      // setProductList(products);
    //}
    
    setProductList(response.data.products);
    setTimeout(() => {

      setIsLoading(false)
    }, 500)
  }

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
    "me"
  ];

  useEffect(() => {

    getProductList(url);
  }, [url])

  return (
    <>
      <div className="container">
        <div className={styles.cardsContainer}>
        <Suspense fallback={<SkeletonCard />}>
            {!isLoading ? productList?.map((product) => (
              <Card key={product.id} cardDetail={product} />
            )) :
              skeletonArr.map((skeletonCard) => (
                <SkeletonCard />
              ))
            }
          </Suspense>
        </div>
      </div>
    </>
  )
}

export default Cards