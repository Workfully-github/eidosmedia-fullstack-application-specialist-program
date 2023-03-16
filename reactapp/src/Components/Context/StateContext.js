import React, { createContext, useContext, useEffect, useState } from "react";

const Context = createContext();

export const StateContext = ({children}) =>{
    const [url, setUrl] = useState("https://eidos-api.herokuapp.com/api/v1/products")
    const [page, setPage] = useState(1)
    return (
        <Context.Provider
          value={{
            url,
            setUrl,
            page,
            setPage
          }}
        >
          {children}
        </Context.Provider>
      );
}

export const useStateContext = () => useContext(Context);