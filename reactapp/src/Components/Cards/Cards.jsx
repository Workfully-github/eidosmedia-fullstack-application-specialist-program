import React, { Suspense, lazy } from 'react'
import styles from './Cards.module.css'
import SkeletonCard from '../Card/SkeletonCard'
import { useStateContext } from "../Context/StateContext"
const Card = lazy(() => import('../Card/Card'));

const Cards = ({ data, notThisOne }) => {
  const { isLoading } = useStateContext();

  const skeletonArr = [
    "I am",
    "gonna",
    "impliment",
    "this",
    "skeleton",
    "loader",
    "later",
    "in",
    "another",
    "way",
    "trust",
    "me"
  ];



  return (
    <>
      <div className="container">
        <div className={styles.cardsContainer}>
          <Suspense fallback={<SkeletonCard />}>
            {!isLoading
              ? data?.map((product) => (
                
                product.id !== notThisOne && <Card key={product.id} cardDetail={product} />

              ))
              : skeletonArr.map(skeletonCard => <SkeletonCard />)
            }
          </Suspense>
        </div>
      </div>
    </>
  )
}

export default Cards