import React from 'react'
import { useParams } from 'react-router-dom'
import useFetch from '../../ApiCall/call'
import Cards from '../Cards/Cards'
import Layout from '../layout/Layout'
import Pagination from '../Pagination/Pagination'

const Page = () => {
    const {page} = useParams()
    const translatePageToUrl = (page) => {
        return `https://eidos-api.herokuapp.com/api/v1/products?skip=${(page - 1) * 30}&limit=30`
      }
  const { data } = useFetch(translatePageToUrl(page))

  return (
    <Layout>
        <Cards data={data?.products} />
        <Pagination />
    </Layout>
  )
}

export default Page