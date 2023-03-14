import React from 'react';

import {Container} from "reactstrap";
import "./Home.css";
import Navbar from "../Navbar/Navbar";
import SearchComponent from '../SearchComponent/SearchComponent';
import ProductList from '../ProductList/ProductList';
//import { useParams } from 'react-router-dom';



export default function Home(props) {

        //const { id } = useParams();

        const search = "labtops";
      return (
        <div>
            <Navbar logo="/eidos.jpg"/>
            <SearchComponent val={search} />
            <ProductList search={search}/>
            <Container >
                <section className="section section-a">
                  <div className="container">
                    <h1>Congrats, it's working</h1>   
                    <h2>Here we are in the home page</h2>
                    <p>you can add whatever you want...........</p>
                  </div>
                </section>

              </Container>
             
        </div>
        
    );
  }