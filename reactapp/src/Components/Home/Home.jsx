import React from 'react';

import { Container } from "reactstrap";
import "./Home.css";
import Navbar from "../Navbar/Navbar";
import SearchComponent from '../SearchComponent/SearchComponent';
import ProductList from '../ProductList/ProductList';
//import { useParams } from 'react-router-dom';
import Cards from '../Cards/Cards';



export default function Home(props) {

  const search = "labtops"; //the idea will be to get the search by the url
  return (
    <>
      <Navbar />
      <SearchComponent val={search} />
      <ProductList search={search}/>
      <Container >

      <Cards />

      </Container>
    </>


  );
}