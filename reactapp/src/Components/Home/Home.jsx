import React, { useEffect, useState } from 'react';

import axios from 'axios'
import { Container} from "reactstrap";
import "./Home.css";
import Navbar from "../Navbar/Navbar";
import SearchComponent from '../SearchComponent/SearchComponent';
import { useParams } from 'react-router-dom';
import Cards from '../Cards/Cards';
import Pagination from "../Pagination/Pagination"
import Footer from '../Footer/Footer';

import {Box, Drawer, IconButton, FormControl, Select, MenuItem, FormControlLabel, InputLabel} from '@mui/material';
import MenuIcon from '@mui/icons-material/Menu';


import { useStateContext } from "../Context/StateContext"



export default function Home(props) {
 //the idea will be to get the search by the url
  var {searchQuery} = useParams();
  var [isDrawerOpen, setIsDrawerOpen] = useState(false);
  var [isLoading, setIsLoading] = useState(true);
  var [categoriesList, setCategoriesList] = useState(null);
  var [category, setCategory] = useState(null);
  var [stock, setStock] = useState(null);
  var [selectMessage, setSelectMessage] = useState(false);
  var [searchValue, setSearchValue] = useState(searchQuery);
  const { url,setUrl, filterType, setFilterType } = useStateContext();

  useEffect(()=>{
    getCategoriesList("https://eidos-api.herokuapp.com/api/v1/categories")
    {console.log(searchQuery)}
  }, [])

  const getCategoriesList = async (url) => {
        setIsLoading(true)
        const response = await axios.get(url);
        setCategoriesList(response.data);
        setTimeout(() => {
        setIsLoading(false)
        }, 500)
    }


  return (
    <>
      <Navbar />
      <IconButton size="large" edge="start" color="inherit" aria-label='logo' onClick={()=>setIsDrawerOpen(true)}>
         <MenuIcon/>
      </IconButton>
      <Drawer anchor='left' open={isDrawerOpen} onClose={()=>setIsDrawerOpen(false)}>
        <Box p={2} width="250px" textAlign='center' role='presentation' >
            <h4>Filter:</h4>
            <br/>
            <FormControl fullWidth>
                <InputLabel id="menu">Categories</InputLabel>
                <Select labelId="menu" id="menu-list" label="categories">
                    {!isLoading && categoriesList.map(cat => 
                    <MenuItem value={cat} onClick={()=>{
                        setUrl("https://dummyjson.com/products/category/" + cat)
                        setCategory(cat)
                        // setIsDrawerOpen(false)
                        setSelectMessage(true)
                        setSearchValue("")
                        
                    }}>
                        {cat}
                    </MenuItem>)}
                </Select>
            </FormControl>
        </Box>
      </Drawer>
      <SearchComponent val={searchValue} />
      {selectMessage && <div>filter for Category/stock : {category}</div>}
      <Container >

        <Cards />
        <Pagination />
      </Container>
      <Footer />
    </>


  );
}