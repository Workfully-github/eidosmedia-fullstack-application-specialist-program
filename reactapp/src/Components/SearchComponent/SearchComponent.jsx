import React, { useState } from 'react';
import styles from "./SearchComponent.module.css";
import { useNavigate } from 'react-router-dom';


export default function SearchComponent(props) {
  const navigate = useNavigate();
  const { val } = props
  const [search, setSearch] = useState(val ? val : "");

  const searchProduct = (e) => {
    e.preventDefault();
    navigate('/search/' + search);
  }
  return (
    <div>
      <form onSubmit={(e) => searchProduct(e)} className={styles.searchForm}>

        <input type="text" className={styles.searchInput} value={search} onChange={(e) => setSearch(e.target.value)} placeholder="Search..." required />
        <button className={styles.searchButton} type='submit'>Search</button>
      </form>
    </div>

  );
}