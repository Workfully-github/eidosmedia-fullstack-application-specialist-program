import React, { useEffect, useState } from 'react'
import axios from 'axios'
import Card from '../Card/Card'
import styles from './Cards.module.css'
import SkeletonCard from '../Card/SkeletonCard'
const Cards = (props) => {

  const [productList, setProductList] = useState(null);
  
  const getProductList = async () => {
    const url = props.searchQuery ? "https://dummyjson.com/products/search?q=" + props.searchQuery : "https://eidos-api.herokuapp.com/products"
    const response = await axios.get(url);
    setProductList(response.data.products);
  }

  const skeletonArr = ["I am", "gonna", "impliment", "this", "skeleton", "loader", "later", "in", "another", "way", "trust", "me"];

  useEffect(() => {
    getProductList();
  }, [])

  return (
    <>
      <div className="container">
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