import React, { useEffect } from 'react';

import { Container } from "reactstrap";
import "./Home.css";
import Navbar from "../Navbar/Navbar";
import SearchComponent from '../SearchComponent/SearchComponent';
import { useParams } from 'react-router-dom';
import Cards from '../Cards/Cards';
import Pagination from "../Pagination/Pagination"
import Footer from '../Footer/Footer';



export default function Home(props) {
 //the idea will be to get the search by the url
  const {searchQuery} = useParams();
  useEffect(()=>{
    
    {console.log(searchQuery)}
  }, [])
  return (
    <>
      <Navbar />
      <SearchComponent val={searchQuery} />
      <Container >

        <Cards searchQuery={searchQuery} />
        <Pagination />
      </Container>
      <Footer />
    </>


  );
}