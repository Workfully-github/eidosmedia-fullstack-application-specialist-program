import React from 'react'
import { useParams } from 'react-router-dom'
import useFetch from '../../ApiCall/call'
import Cards from '../Cards/Cards'
import Layout from '../layout/Layout'
import Pagination from '../Pagination/Pagination'

const Category = () => {
    const { category } = useParams("");

  const {data} = useFetch("https://eidos-api.herokuapp.com/api/v1/products/category/" + category)
console.log(data)
  return (
    <Layout >
        <div className='container' style={{ fontSize: "20px" }} ><b>{category}</b></div>
        <Cards data={data?.products} />
        {data?.products.length > 30 && <Pagination />}
      </Layout>
  )
}

export default Category