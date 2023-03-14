import React from 'react';

import { Container } from "reactstrap";
import "./Home.css";
import Navbar from "../Navbar/Navbar";
import Cards from '../Cards/Cards';



export default function Home(props) {

  return (
    <>
      <Navbar />
      <Container >

      <Cards />

      </Container>
    </>


  );
}