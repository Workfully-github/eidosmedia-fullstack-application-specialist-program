import React, { useEffect, useState } from 'react'
import axios from 'axios'
import Card from '../Card/Card'
import styles from './Cards.module.css'
import SkeletonCard from '../Card/SkeletonCard'
import { useParams } from 'react-router-dom'
const Cards = (props) => {
  const params = useParams()

  const [productList, setProductList] = useState(null);
<<<<<<< Updated upstream
  const [searchQuery, setSearchQuery] = useState(params.searchQuery);
  const [url, setUrl] = useState("https://eidos-api.herokuapp.com/products");
=======
  //const [searchQuery, setSearchQuery] = useState(null);
  const [isLoading, setIsLoading] = useState(true);

  const [url, setUrl] = useState("https://eidos-api.herokuapp.com/api/v1/products");

>>>>>>> Stashed changes
  const getProductList = async (url) => {
    // const url = params.searchQuery ? "https://dummyjson.com/products/search?q=" + searchQuery : "https://eidos-api.herokuapp.com/products"
    const response = await axios.get(url);
<<<<<<< Updated upstream
    setProductList(response.data.products);
=======
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
>>>>>>> Stashed changes
  }

  const skeletonArr = ["I am", "gonna", "impliment", "this", "skeleton", "loader", "later", "in", "another", "way", "trust", "me"];

  useEffect(() => {
<<<<<<< Updated upstream
=======
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
>>>>>>> Stashed changes
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