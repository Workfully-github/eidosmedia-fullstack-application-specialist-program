import React, { Suspense, useEffect, useState, lazy } from 'react'
import axios from 'axios'
import styles from './Cards.module.css'
import SkeletonCard from '../Card/SkeletonCard'
import { useStateContext } from "../Context/StateContext"
import { useParams } from 'react-router-dom'
const Card = lazy(() => import('../Card/Card'));

const Cards = (props) => {
  const {url, setUrl} = useStateContext();

  const [productList, setProductList] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const {searchQuery} = useParams();
  const params = useParams("");

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
    Object.keys(params).length !== 0  ? setUrl("https://eidos-api.herokuapp.com/api/v1/products/search?q=" + searchQuery) : setUrl("https://eidos-api.herokuapp.com/api/v1/products")
    getProductList(url);
  }, [url, params, searchQuery, setUrl])

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