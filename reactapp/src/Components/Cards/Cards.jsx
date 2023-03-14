import React from 'react'
import Card from '../Card/Card'
import styles from './Cards.module.css'
const Cards = () => {
  return (
    <>
      <div className="container">
        <div className={styles.cardsContainer}>
          <Card />
          <Card />
          <Card />
          <Card />
          <Card />
          <Card />
        </div>
      </div>
    </>
  )
}

export default Cards