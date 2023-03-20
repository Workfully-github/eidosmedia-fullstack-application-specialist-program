import React, { useState } from 'react'
import { Link } from 'react-router-dom';
import { Box, Drawer, IconButton, MenuItem } from '@mui/material';
import MenuIcon from '@mui/icons-material/Menu';
import useFetch from '../../ApiCall/call';


const SideBar = () => {

    const { data } = useFetch("https://eidos-api.herokuapp.com/api/v1/categories")
    var [isDrawerOpen, setIsDrawerOpen] = useState(false);
    
    return (

        <>
            <IconButton size="large" edge="start" color="inherit" aria-label='logo' onClick={() => setIsDrawerOpen(true)}>
                <MenuIcon />
            </IconButton>
            <Drawer anchor='left' open={isDrawerOpen} onClose={() => setIsDrawerOpen(false)}>
                <Box p={2} width="250px" textAlign='center' role='presentation' >
                    <h3>Select a category</h3>
                    <br />
                    {/* <FormControl fullWidth>
                        <InputLabel id="menu">Categories</InputLabel>
                        <Select labelId="menu" id="menu-list" label="categories">
                            {!isLoading && categoriesList?.map(cat =>
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
                    </FormControl> */}
                    {data?.map(cat=>(
                        <Link to={`/category/${cat}`} >

                        <MenuItem value={cat} onClick={() => {
                            // Navigate('/category/' + cat);
                            setIsDrawerOpen(!isDrawerOpen)
                        }}>
                            {cat}
                        </MenuItem>
                            </Link>
                    ))}

                </Box>
            </Drawer></>
    )
}

export default SideBar