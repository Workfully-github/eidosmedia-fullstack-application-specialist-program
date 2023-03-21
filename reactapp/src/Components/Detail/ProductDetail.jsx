import { useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";
//import { ProductCall } from "../../ApiCall/ProductCall";
import styles from "./ProductDetail.module.css";
import Recommendation from "../Recommendation/Recommendation";
import { useStateContext } from "../Context/StateContext";
import SkeletonCard from "../Card/SkeletonCard";
import useFetch from "../../ApiCall/call";
import Layout from "../layout/Layout";

function ProductDetail() {
  const { decQty, incQty, qty, setQty, onAdd, isLoading } = useStateContext();
  const BASE_URL = "https://eidos-api.herokuapp.com/api/v1/products/";
  const { id } = useParams();
  const { data } = useFetch(BASE_URL + id)
  const [coverImage, setCoverImage] = useState(null);

  useEffect(()=>{
    setCoverImage(data?.thumbnail)
    setQty(1);
  }, [data, setQty])

  const skeletonArr = [
    "I am",
    "gonna",
    "impliment",
    "this",
   
  ];

  

 

  return (
    <Layout>
      <div className="container">

        <div>
          <div className={styles.backButtonDiv}>
            <Link className={styles.gobackButton} to="/">
              ◀  Go back
            </Link>
          </div>

          <section className={styles.headerSection}>
            {!isLoading ? (
              <section className={styles.imageSection}>
                <div className={styles.smallImagesDiv}>
                  {data &&
                    data.images.map((image) => (
                      <div className={styles.smallImageContainer}>
                        <img
                        alt="product view"
                          key={data.id}
                          src={image}
                          className={`${styles.smallerImages} ${styles.imageAnimation}`}
                          onClick={()=>setCoverImage(image)}
                          loading="lazy"
                        />
                      </div>
                    ))}
                </div>

                <div className={styles.profileImageContainer}>
                {
                    data && (
                    <img
                      src={coverImage && coverImage}
                      alt="cover pic"
                      className={`${styles.profileImage}`}
                      loading="lazy"

                    />
                )}
                  </div>
              </section>
            ) : (
              skeletonArr.map((skeleton) => <SkeletonCard />)
            )}

            <div className={styles.productInfo}>
              {data && (
                <h1 className={styles.productTitle}>
                  <b>{data.title}</b>
                </h1>
              )}

              <div>
                {data && (
                  <p id={styles.descriptionLetter}>{data.description}</p>
                )}
              </div>

              <div className={styles.displayPrice}>
                {data && <h3 id={styles.priceHeader}>{data.price}$</h3>}
              </div>

              <div className={styles.displayIdBrand}>
                {data && (
                  <p className={styles.brandStyles}>Brand: {data.brand}</p>
                )}
                {data && <p>Stock: {data.stock}</p>}
                {data && <p>Rating: {data.rating}</p>}
              </div>

              <div className={styles.quantityDiv}>
                {/* <form className={styles.quantityForm} onSubmit="">
                  <label htmlFor="quantity">Quantity: </label>
                  <input
                    className={styles.quantityInput}
                    type="number"
                    name="quantity"
                    min="0"
                    max="50"
                    value={qty}
                    onChange={handleQuantity}

                  />
                </form> */}
                <div className="quantity">
                    <button onClick={decQty} className="minus qnt-changer">
                      <span>&#8722;</span>
                    </button>
                    <div className="item-qty">{qty}</div>
                    <button onClick={incQty} className="plus qnt-changer">
                      <span>&#43;</span>
                    </button>
                  </div>
              </div>

              <div className={styles.buttonsDiv}>
                <Link to="/cart">
                  <button className={styles.buyNow} >

                    Buy now
                  </button>
                </Link>
                <button className={styles.addCartButton} onClick={() => onAdd(data, qty)}>
                  Add to Cart
                </button>
              </div>
            </div>
          </section>

          <section>
            {/* <Recommendation categoryProduct={product?.category} productId={product?.id}/> */}
            <Recommendation
              category={data?.category}
              productId={data?.id}
            />
          </section>
        </div>
      </div>

    </Layout>
  );
}

export default ProductDetail;
