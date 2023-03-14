import React, { useState } from 'react';

import "./SearchComponent.css";

export default function SearchComponent(props) {
    const {val} = props
    const [search, setSearch] = useState(val);

    const searchProduct = () => {
            // we will call a other react path that will open the home page with the search value in the url
            //redirect path to /home/:search
            window.location.replace('http://localhost:8000/home/:' + search)
    }
      return (
        <div>
            <input type="text" className='search' value={search} onChange={(e) => setSearch(e.target.value)} />
            <button onClick={() => searchProduct()}>Search</button>
        </div>

    );
  }