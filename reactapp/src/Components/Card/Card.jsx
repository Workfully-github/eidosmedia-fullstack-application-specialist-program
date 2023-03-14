import React from 'react'
import styles from './Card.module.css'
const Card = () => {
  return (
    <a href='https://google.com'  >
      <div className={styles.cardContainer}>
        <div className={styles.thumbnailContainer}>
          <img src="https://i.dummyjson.com/data/products/1/thumbnail.jpg" alt="#" className={styles.thumbnail} />
        </div>
        <div className={styles.cardFooter}>
          <h3 className={styles.productTitle}>Iphone for now</h3>
          <span className={styles.price}>$800</span>
        </div>
      </div>
    </a>
  )
}

export default Card