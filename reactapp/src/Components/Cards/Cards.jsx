import React, { useEffect, useState } from 'react'
import axios from 'axios'
import Card from '../Card/Card'
import styles from './Cards.module.css'
import SkeletonCard from '../Card/SkeletonCard'
import { useParams } from 'react-router-dom'
import { useStateContext } from "../Context/StateContext"

const Cards = (props) => {
  const {url, setUrl} = useStateContext();
  const params = useParams()

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
          {!isLoading ?
            productList?.map((product) => (
              <Card key={product.id} cardDetail={product} />
            )) :
            skeletonArr.map((skeleton) => (
              <SkeletonCard />

            ))
          }
        </div>
      </div>
    </>
  )
}

export default Cards