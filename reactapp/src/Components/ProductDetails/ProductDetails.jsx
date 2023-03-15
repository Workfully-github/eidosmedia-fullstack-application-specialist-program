import React from 'react';

import {Container} from "reactstrap";
import ProductDetail from '../Detail/ProductDetail';
import "./ProductDetails.css";

export default function ProductDetails(props) {
      return (
        <div>
            <Container >
                <section className="section section-a">
                  <div className="container">
                    <ProductDetail />
                  </div>
                </section>
            </Container>
        </div>
    );
  }