import React  from 'react'
import CartSlide from '../Cart/CartSlide'
import styles from './Navbar.module.css'
import { useStateContext } from "../Context/StateContext";
import SearchComponent from '../SearchComponent/SearchComponent';
import { Link, useParams } from 'react-router-dom';

import SideBar from '../SideBar/SideBar';
const Navbar = () => {
  const { totalQuantities, showCart, toggleCart } = useStateContext();
  var { searchQuery } = useParams();
 console.log(totalQuantities)
  return (
    
    <>
      <nav className={styles.navbar}>
        <div className="container">
          <div className={styles.navbarContainer}>
          <div style={{display: "flex", alignItems: "center"}}>
            <SideBar />
            <Link to="/">

            <span onClick={window.scroll({top: 0})} className={styles.logo}>EIDOSTORE</span>
            <span onClick={window.scroll({top: 0})} className={styles.resLogo}>ES</span>
            </Link>
          </div>
            <SearchComponent val={searchQuery ? searchQuery : ""} />
            <div className={styles.navRight}>


            <span
              onClick={() => {
                toggleCart();
              }}
              className="cart-container"
            >

              <span className="cart">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 24 24"
                  width="24"
                  height="24"
                >
                  <path fill="none" d="M0 0h24v24H0z" />
                  <path d="M4 16V4H2V2h3a1 1 0 0 1 1 1v12h12.438l2-8H8V5h13.72a1 1 0 0 1 .97 1.243l-2.5 10a1 1 0 0 1-.97.757H5a1 1 0 0 1-1-1zm2 7a2 2 0 1 1 0-4 2 2 0 0 1 0 4zm12 0a2 2 0 1 1 0-4 2 2 0 0 1 0 4z" />
                </svg>
              </span>
              {totalQuantities > 0 && (
                <span className="cart-products">{totalQuantities}</span>
              )}
            </span>
            </div>
          </div>
        </div>
      </nav>
      {showCart && <CartSlide />}
    </>
  )
}

export default Navbar