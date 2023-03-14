/* import Navbar from "./Components/Navbar/Navbar";

function App() {
  return (
    <>
    <Navbar />
    <h1>Congrats, it's working</h1>
    </>
  );
}

export default App; */
import React, { Component } from 'react';
import { Route, Routes, Switch } from 'react-router-dom';
import ProductDetails from './Components/Detail/ProductDetail';

class App extends Component {         
  render() {         
    return (         
        <div className="App">             
          <div className="App-content">    
            <Routes>                     
              <Route exact path ='/details/:id' element={<ProductDetails />}/>                    
            </Routes>      
          </div>         
        </div>         
      );     
    } } 
    
    export default App;
