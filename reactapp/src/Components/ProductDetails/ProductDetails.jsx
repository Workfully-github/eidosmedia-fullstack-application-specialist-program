import React from 'react';

import {Container} from "reactstrap";
import "./ProductDetails.css";

export default function ProductDetails(props) {
      return (
        <div>
            <Container >
                <section className="section section-a">
                  <div className="container">
                    <h1>Congrats, it's working</h1> 
                    <h2>Here we are in the product details page</h2>
                  </div>
                </section>
            </Container>
        </div>
    );
  }