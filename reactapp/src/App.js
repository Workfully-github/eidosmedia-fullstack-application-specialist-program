
import React, { Component } from 'react';
import { Route, Routes } from 'react-router-dom';
import './App.css';  
import Category from './Components/Category/Category';
import { StateContext } from './Components/Context/StateContext';
import Home from './Components/Home/Home';
import Page from './Components/Page/Page';
import ProductDetail from './Components/Detail/ProductDetail';
import Search from './Components/Search/Search';
class App extends Component {         
  render() {         
    return (     
      <StateContext>

    
        <div className="App">     
          <div className="App-content">              
            <Routes>                       
              <Route  path="/" element={<Home />}/>                     
              <Route  path="/home" element={<Home />}/>                     
              <Route  path="/search/:searchQuery" element={<Search />}/>                  
              <Route  path="/category/:category" element={<Category />}/>                  
              <Route  path="/page/:page" element={<Page />}/>                  
              <Route  path ="/details/:id" element={<ProductDetail />}/>                    
            </Routes>
          </div>         
        </div>         
      </StateContext>
      );     
    } } 
    
    export default App;