import React, { useEffect, useState } from 'react';

import "./Home.css";
import Cards from '../Cards/Cards';
import Pagination from "../Pagination/Pagination"
import Layout from '../layout/Layout';
import call from '../../ApiCall/call';
import { useStateContext } from '../Context/StateContext'
import useFetch from '../../ApiCall/call';
import axios from 'axios';
import { useParams } from 'react-router-dom';
export default function Home() {
  const { data } = useFetch("https://eidos-api.herokuapp.com/api/v1/products/")

  return (
    <>
      <Layout >
        <Cards data={data?.products} />
        <Pagination />
      </Layout>
    </>


  );
}