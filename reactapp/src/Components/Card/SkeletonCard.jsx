import React from 'react'
import styles from './Card.module.css'

function SkeletonCard() {
  return (
      <div className={styles.skeletonCardContainer}>
        <div className={styles.skeletonThumbnailContainer}>
        </div>
        <div className={styles.skeletonCardFooter}>
          <div className={styles.skeletonProductTitle}></div>
          <div className={styles.skeletonPrice}></div>
        </div>
      </div>
  )
}

export default SkeletonCard