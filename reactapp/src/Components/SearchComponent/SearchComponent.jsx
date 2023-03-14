import React, { useState } from 'react';

import styles from "./SearchComponent.module.css";

export default function SearchComponent(props) {
    const {val} = props
    const [search, setSearch] = useState(val);

    const searchProduct = (e) => {
            // we will call a other react path that will open the home page with the search value in the url
            //redirect path to /home/:search
            e.preventDefault();
            window.location.replace('http://localhost:3000/search/' + search)
    }
      return (
        <div>
          <form onSubmit={(e) => searchProduct(e)} className={styles.searchForm}>

            <input type="text" className={styles.searchInput} value={search} onChange={(e) => setSearch(e.target.value)} placeholder="Search..." required/>
            <button className={styles.searchButton} type='submit'>Search</button>
          </form>
        </div>

    );
  }