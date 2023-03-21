import React from 'react'
import { Link, useNavigate } from 'react-router-dom';
import Rating from '../Rating/Rating';
import styles from './Card.module.css'
const Card = ({cardDetail}) => {
  const {id, title, price, category, thumbnail} = cardDetail;
  const navigate = useNavigate();

  return (
    <Link to={`/details/${id}`} onClick={()=>{window.scroll({
      top: 0, 
      // behavior: 'smooth' 
     })}}>

      <div className={styles.cardContainer}>
        <div className={styles.thumbnailContainer}>
          <img src={thumbnail} alt="#" className={styles.thumbnail}  loading="lazy"/>
        </div>
        <div className={styles.cardFooter}>
          <span className={styles.productTitle}>{title}</span>
          <i className={styles.productCategory}>  {category}</i>
          <Rating rating={4.53} />
          <h3 className={styles.price}>€{price}</h3>
        </div>
      </div>
    </Link>
  )
}

export default Card