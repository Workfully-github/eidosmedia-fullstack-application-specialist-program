import React, { useEffect, useState } from 'react'
import axios from 'axios'
import Card from '../Card/Card'
import styles from './Cards.module.css'
import SkeletonCard from '../Card/SkeletonCard'
import { useParams } from 'react-router-dom'
const Cards = (props) => {
  const params = useParams()

  const [productList, setProductList] = useState(null);
  const [searchQuery, setSearchQuery] = useState(params.searchQuery);
  const [url, setUrl] = useState("https://eidos-api.herokuapp.com/products");
  const getProductList = async (url) => {
    // const url = params.searchQuery ? "https://dummyjson.com/products/search?q=" + searchQuery : "https://eidos-api.herokuapp.com/products"
    const response = await axios.get(url);
    setProductList(response.data.products);
  }

  const skeletonArr = ["I am", "gonna", "impliment", "this", "skeleton", "loader", "later", "in", "another", "way", "trust", "me"];

  useEffect(() => {
    getProductList(url);
  }, [url])

  return (
    <>
      <div className="container">
        <button onClick={()=>{setUrl("https://dummyjson.com/products/search?q=laptop")}}>click me</button>
        <div className={styles.cardsContainer}>
          {productList ?
          productList?.map((product, index) => (
            <Card key={product.id} cardDetail={product} />
          )) :
          skeletonArr.map((skeleton)=>(
            <SkeletonCard />

          ))
        }
        </div>
      </div>
    </>
  )
}

export default Cards