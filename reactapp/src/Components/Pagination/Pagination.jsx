import React, { useState } from 'react'
import styles from './Pagination.module.css'
import { useNavigate } from 'react-router-dom';
import { useStateContext } from "../Context/StateContext"

const Pagination = () => {
    const { url, setUrl, page, setPage } = useStateContext();
    const navigate = useNavigate();


    const translatePageToUrl = (page) => {
        return `https://eidos-api.herokuapp.com/api/v1/products?skip=${(page - 1) * 30}&limit=30`
    }

    const goToPage = (page) => {
        navigate(`/page/${page}`);
        setPage(page)
        setUrl(translatePageToUrl(page))
    }
    return (
        <div className={styles.paginationContainer}>
            <div onClick={window.scroll({ top: 0, behavior: 'smooth'})}>
                <button className={styles.back} onClick={() => { goToPage(page > 1 ? page - 1 : 1) }} disabled={page != 1 ? false : true}>
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24"><path fill="none" d="M0 0h24v24H0z" /><path d="M7.828 11H20v2H7.828l5.364 5.364-1.414 1.414L4 12l7.778-7.778 1.414 1.414z" fill="rgba(50,152,219,1)" /></svg>
                </button>
            </div>
            <div onClick={window.scroll({ top: 0, behavior: 'smooth'})}>
                <button className={styles.next} onClick={() => { goToPage(page + 1) }} disabled={page != 4 ? false : true}>
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24"><path fill="none" d="M0 0h24v24H0z" /><path d="M16.172 11l-5.364-5.364 1.414-1.414L20 12l-7.778 7.778-1.414-1.414L16.172 13H4v-2z" fill="rgba(50,152,219,1)" /></svg>
                </button>
            </div>
        </div>
    )
}

export default Pagination