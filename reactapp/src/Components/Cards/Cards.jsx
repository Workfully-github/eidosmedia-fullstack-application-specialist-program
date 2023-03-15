import React, { useEffect, useState } from 'react'
import axios from 'axios'
import Card from '../Card/Card'
import styles from './Cards.module.css'
import SkeletonCard from '../Card/SkeletonCard'
import { useParams } from 'react-router-dom'
const Cards = (props) => {
  const params = useParams()

  const [productList, setProductList] = useState(null);
  const [searchQuery, setSearchQuery] = useState(null);
  const [isLoading, setIsLoading] = useState(true);

  const [url, setUrl] = useState("https://eidos-api.herokuapp.com/products");

  const getProductList = async (url) => {
    setIsLoading(true)
    const response = await axios.get(url);
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
    setUrl(params ? "https://dummyjson.com/products/search?q=" + params.searchQuery : "https://eidos-api.herokuapp.com/products")
    getProductList(url);
  }, [url, params])

  return (
    <>
      <div className="container">
        <button onClick={() => { setUrl("https://dummyjson.com/products/search?q=laptop") }}>click me</button>
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