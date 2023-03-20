import React from 'react'
import { useParams } from 'react-router-dom'
import Cards from '../Cards/Cards'
import Layout from '../layout/Layout'
import useFetch from '../../ApiCall/call'

const Search = () => {
    const { searchQuery } = useParams("");
    const { data } = useFetch("https://eidos-api.herokuapp.com/api/v1/products/search?q=" + searchQuery)
    return (
        <>
            <Layout >

                {data?.products.length !== 0
                    ?
                    <>
                        <div className='container' style={{ fontSize: "20px" }} >Search results for: <b>{searchQuery}</b></div>
                        <Cards data={data?.products} />
                    </>
                    : <EmptySearchResultPage searchTerm={searchQuery} />
                }
            </Layout>
        </>
    )
}

const EmptySearchResultPage = ({ searchTerm }) => {
    return (
        <>
            <div className="container"  >

                <div style={{ fontSize: "20px" }} >Unfortunately, we don't have what you are looking for: <b>{searchTerm}</b></div>
                <div style={{ margin: "0px auto", width: "fit-content" }} >

                    <img src="/noresult.webp" alt="No search results where found" />
                </div>
            </div>
        </>
    )
}

export default Search