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
  const [searchQuery, setSearchQuery] = useState(null);
  const [isLoading, setIsLoading] = useState(true);


  const getProductList = async (url) => {
    setIsLoading(true)
    const response = await axios.get(url);
    if(props.filterType==="stock") {
      //filter the list of products before set the state here
      var products = response.data.products.filter(p => {return p.stock==props.stockQuery})
      setProductList(products);
    }
    else{
      setProductList(response.data.products);
    }
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
    if(props.filterType==="stock"){
      //the filter will be done in the getProductsList()
      setUrl("https://eidos-api.herokuapp.com/api/v1/products")
    }
    else if(props.filterType==="category"){
      console.log("we can be here")
      setUrl("https://dummyjson.com/products/category/" + props.categoryQuery)

    }
    else {
      console.log("never be can be here")
      setUrl(props.searchValue ? "https://dummyjson.com/products/search?q=" + props.searchValue : "https://eidos-api.herokuapp.com/api/v1/products")
    }
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