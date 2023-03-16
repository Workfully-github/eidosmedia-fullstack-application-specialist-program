
import React, { Component } from 'react';
import { Route, Routes, Switch } from 'react-router-dom';
import './App.css';  
import { StateContext } from './Components/Context/StateContext';
import Home from './Components/Home/Home';
import ProductDetails from './Components/ProductDetails/ProductDetails';
// import { StateContext } from "../context/StateContext";
class App extends Component {         
  render() {         
    return (     
      <StateContext>

    
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
      </StateContext>
      );     
    } } 
    
    export default App;