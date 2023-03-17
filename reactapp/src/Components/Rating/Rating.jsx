import React, { useEffect, useState } from 'react'
import styles from './Rating.module.css'
const Rating = ({ rating }) => {
    const ratingArr = []
    const [ratArr, setRatArr] = useState([])
    const setRatingArr = (rating) => {
        let ratingInt = parseInt(rating.toString().split(".")[0]);
        let ratingDec = parseInt(rating.toString().split(".")[1]);

        for (let i = 0; i < ratingInt; i++) {
            ratingArr.push(1)
            // console.log(ratingArr)
        }

        ratingArr.push(ratingDec / 100)
        // console.log(ratingArr)

    }

    useEffect(() => {
        setRatingArr(rating)
        setRatArr(ratingArr)
    }, [])
    return (
        <>
            <div className={styles.ratingContainer}>
                {ratArr.map((rat) => (<Star fill={rat} />))}
            </div>
        </>
    )
}

const Star = ({ fill }) => {
    return (
        <>
            <div className={styles.starContainer} style={{ background: `linear-gradient(90deg, #fbaf33 ${fill * 100}%, #00ffff00 50%)` }}>
                <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path fillRule="evenodd" clip-rule="evenodd" d="M18 0H0V18H18V0ZM11.5661 6.0625L9 1L6.43388 6.0625L1 6.72949L5 10.5625L4.05573 16L9 13.375L13.9443 16L12.9238 11.125L17 6.72949L11.5661 6.0625Z" fill="white" />
                    <path d="M9 1L11.5661 6.0625L17 6.72949L12.9238 11.125L13.9443 16L9 13.375L4.05573 16L5 10.5625L1 6.72949L6.43388 6.0625L9 1Z" fill="black" fill-opacity="0.16" />
                </svg>



            </div>
        </>
    )
}

export default Rating