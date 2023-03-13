import React from 'react';

import {Container} from "reactstrap";
import "./Home.css";
import Navbar from "../Navbar/Navbar";



export default function Home(props) {

      return (
        <div>
            <Navbar />
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