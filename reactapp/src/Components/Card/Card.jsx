import React from 'react'
import Rating from '../Rating/Rating';
import styles from './Card.module.css'
const Card = ({cardDetail}) => {
  const {id, title, price, category, thumbnail} = cardDetail;
  return (
    <a href={`/details/${id}`}  >
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
    </a>
  )
}

export default Card