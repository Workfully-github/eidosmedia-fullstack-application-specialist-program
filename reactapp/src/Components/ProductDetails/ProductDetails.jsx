import React from 'react';

import {Container} from "reactstrap";
import ProductDetail from '../Detail/ProductDetail';
import Footer from '../Footer/Footer';
import Navbar from '../Navbar/Navbar';
import "./ProductDetails.css";

export default function ProductDetails(props) {
      return (
        <div>
            <Navbar />
            <Container >
                <section className="section section-a">
                  <div className="container">
                    <ProductDetail />
                  </div>
                </section>
            </Container>
            <Footer />
        </div>
    );
  }