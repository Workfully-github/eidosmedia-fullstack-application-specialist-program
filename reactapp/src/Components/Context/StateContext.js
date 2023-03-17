import React, { createContext, useContext, useEffect, useState } from "react";

const Context = createContext();

export const StateContext = ({children}) =>{
    const [url, setUrl] = useState("https://eidos-api.herokuapp.com/api/v1/products")
    const [page, setPage] = useState(1)
    const [stock, setStock] = useState("")
    const [isStock, setIsStock] = useState(false)
    const [stockSelected, setStockSelected] = useState(false)
    const [categorySelected, setCategorySelected] = useState(false)
    const [searchSelected, setSearchSelected] = useState(true)
    return (
        <Context.Provider
          value={{
            url,
            setUrl,
            page,
            setPage,
            stock,
            setStock,
            isStock,
            setIsStock,
            categorySelected,
            setCategorySelected,
            searchSelected, 
            setSearchSelected,
            stockSelected, 
            setStockSelected
          }}
        >
          {children}
        </Context.Provider>
      );
}

export const useStateContext = () => useContext(Context);