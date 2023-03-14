import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom';
import './App.css';  
import Home from './Components/Home/Home';
import ProductDetails from './Components/ProductDetails/ProductDetails';

class App extends Component {         
  render() {         
    return (         
        <div className="App">             
          <div className="App-content">              
            <Switch>                       
              <Route exact path="/" component={Home}/>                     
              <Route exact path="/home" component={Home}/>                     
              <Route exact path="/search/:searchQuery" component={Home}/>                     
              <Route exact path ="/details/:id" component={ProductDetails}/>                    
            </Switch>
          </div>         
        </div>         
      );     
    } } 
    
    export default App;