import React from 'react'
import styles from './Card.module.css'
const Card = ({cardDetail}) => {
  const {id, title, price, thumbnail} = cardDetail;
  return (
    <a href={`/details/${id}`}  >
      <div className={styles.cardContainer}>
        <div className={styles.thumbnailContainer}>
          <img src={thumbnail} alt="#" className={styles.thumbnail} />
        </div>
        <div className={styles.cardFooter}>
          <h3 className={styles.productTitle}>{title}</h3>
          <span className={styles.price}>€{price}</span>
        </div>
      </div>
    </a>
  )
}

export default Card