import React, { useState } from 'react';
import styles from "./SearchComponent.module.css";
import { useNavigate } from 'react-router-dom';
import { useStateContext } from "../Context/StateContext"

export default function SearchComponent(props) {
  const { setUrl, setIsStock, setCategorySelected, setSearchSelected } = useStateContext();
  const navigate = useNavigate();
  const { val } = props
  const [search, setSearch] = useState(val ? val : "");

  const searchProduct = (e) => {
    e.preventDefault();
    navigate('/search/' + search);
    setCategorySelected(false)
    setIsStock(false)
    setSearchSelected(true)
    setUrl("https://eidos-api.herokuapp.com/api/v1/products/search?q=" + search)

  }
  return (
    <div>
      <form onSubmit={(e) => searchProduct(e)} className={styles.searchForm}>

        <input type="text" className={styles.searchInput} value={search} onChange={(e) => setSearch(e.target.value)} placeholder="Search..." required />
        <button className={styles.searchButton} type='submit'>
          <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24"><path fill="none" d="M0 0h24v24H0z" /><path d="M18.031 16.617l4.283 4.282-1.415 1.415-4.282-4.283A8.96 8.96 0 0 1 11 20c-4.968 0-9-4.032-9-9s4.032-9 9-9 9 4.032 9 9a8.96 8.96 0 0 1-1.969 5.617zm-2.006-.742A6.977 6.977 0 0 0 18 11c0-3.868-3.133-7-7-7-3.868 0-7 3.132-7 7 0 3.867 3.132 7 7 7a6.977 6.977 0 0 0 4.875-1.975l.15-.15z" fill="rgba(255,255,255,1)" /></svg>
        </button>
      </form>
    </div>

  );
}