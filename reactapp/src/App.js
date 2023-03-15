import React, { Component } from 'react';
import { Route, Routes, Switch } from 'react-router-dom';
import './App.css';  
import Home from './Components/Home/Home';
import ProductDetails from './Components/ProductDetails/ProductDetails';

class App extends Component {         
  render() {         
    return (         
        <div className="App">             
          <div className="App-content">              
            <Routes>                       
              <Route  path="/" element={<Home />}/>                     
              <Route  path="/home" element={<Home />}/>                     
              <Route  path="/search/:searchQuery" element={<Home />}/>                     
              <Route  path ="/details/:id" element={<ProductDetails />}/>                    
            </Routes>
          </div>         
        </div>         
      );     
    } } 
    
    export default App;