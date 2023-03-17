import React, { useEffect, useState } from 'react';

import axios from 'axios'
import { Container } from "reactstrap";
import "./Home.css";
import Navbar from "../Navbar/Navbar";
import SearchComponent from '../SearchComponent/SearchComponent';
import { useParams } from 'react-router-dom';
import Cards from '../Cards/Cards';
import Pagination from "../Pagination/Pagination"
import Footer from '../Footer/Footer';

import { Box, Drawer, IconButton, FormControl, Select, MenuItem, InputLabel } from '@mui/material';
import MenuIcon from '@mui/icons-material/Menu';

import { useStateContext } from "../Context/StateContext"

export default function Home(props) {
  //the idea will be to get the search by the url
  var { searchQuery } = useParams();
  var [isDrawerOpen, setIsDrawerOpen] = useState(false);
  var [isLoading, setIsLoading] = useState(true);
  var [categoriesList, setCategoriesList] = useState(null);
  var [category, setCategory] = useState(null);
  var [selectMessage, setSelectMessage] = useState(false);
  var [searchValue, setSearchValue] = useState(searchQuery);
  const { url, setUrl,
     stock, setStock, 
     isStock, setIsStock, 
     categorySelected, setCategorySelected,
      searchSelected, setSearchSelected } = useStateContext();

  useEffect(() => {
    getCategoriesList("https://eidos-api.herokuapp.com/api/v1/categories")
    { console.log(searchQuery) }
  }, [])

  const getCategoriesList = async (url) => {
    setIsLoading(true)
    const response = await axios.get(url);
    setCategoriesList(response.data);
    setTimeout(() => {
      setIsLoading(false)
    }, 500)
  }
  const handleSubmit = (e) => {
    e.preventDefault();
    setUrl("https://eidos-api.herokuapp.com/api/v1/products")
    setIsStock(true)
    setCategorySelected(false)
    setSearchSelected(false)
    console.log("Submitted value: ", stock);
    // perform any necessary actions with the submitted value here
  };


  return (
    <>
      <Navbar />
      <IconButton size="large" edge="start" color="inherit" aria-label='logo' onClick={() => setIsDrawerOpen(true)}>
        <MenuIcon />
      </IconButton>
      <Drawer anchor='left' open={isDrawerOpen} onClose={() => setIsDrawerOpen(false)}>
        <Box p={2} width="250px" textAlign='center' role='presentation' >
          <h4>Filter:</h4>
          <br />
          <FormControl fullWidth>
            <InputLabel id="menu">Categories</InputLabel>
            <Select labelId="menu" id="menu-list" label="categories">
              {!isLoading && categoriesList.map(cat =>
                <MenuItem value={cat} onClick={() => {
                  setUrl("https://dummyjson.com/products/category/" + cat)
                  setCategory(cat)
                  setSearchValue("")
                  setCategorySelected(true)
                  setSearchSelected(false)
                  setIsStock(false)

                }}>
                  {cat}
                </MenuItem>)}
            </Select>
          </FormControl>
          <form onSubmit={handleSubmit} className="form">
            <label>
              Stock:
              <input
                type="number"
                value={stock}
                onChange={(e) => setStock(e.target.value)}
                className="input"
              />
            </label>
            <button type="submit">Submit</button>
          </form>
        </Box>
      </Drawer>
      <SearchComponent val={searchValue} />

      {categorySelected && <div>filter for Category : <b >{category}</b></div>}
      {isStock && <div>filter for stock : <b >{stock}</b></div>}
      {searchSelected && <div>filter for search : <b >{searchQuery}</b></div>}
      
      <Container >

        <Cards />
        <Pagination />
      </Container>
      <Footer />
    </>


  );
}