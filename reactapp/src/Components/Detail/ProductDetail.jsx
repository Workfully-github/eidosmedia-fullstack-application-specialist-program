import { useState, useEffect, useRef } from "react";
import { useParams, Link } from "react-router-dom";
//import { ProductCall } from "../../ApiCall/ProductCall";
import styles from "./ProductDetail.module.css";
import Recommendation from "../Recommendation/Recommendation";
import { useStateContext } from "../Context/StateContext";
import SkeletonCard from "../Card/SkeletonCard";
import useFetch from "../../ApiCall/call";
import Layout from "../layout/Layout";

function ProductDetail() {
  const { decQty, incQty, qty, setQty, onAdd, toggleCart } = useStateContext();
  const BASE_URL = "https://eidos-api.herokuapp.com/api/v1/products/";
  const [product, setProduct] = useState(null);
  const [quantity, setQuantity] = useState(0);
  const { id } = useParams();
  const quan = useRef();
  const handleQuantity = (e) => setQty(e.target.value);
  const [isLoading, setIsLoading] = useState(true);
  const [coverImage, setCoverImage] = useState(null);

  const { data } = useFetch(BASE_URL + id)

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
    "me",
  ];

  //const handleQuantity = (e) => setQuantity(e.target.value);
  const handleImageChange = (e) => {
    setCoverImage(e.target.currentSrc);
  };

  const getProductDetail = async (id) => {
    /* const data = await ProductCall.get(BASE_URL + `${id}`); */
    try {
      const data = await fetch(BASE_URL + `${id}`);
      return await data.json();

    } catch (error) {
      console.log(error);
    }
    //return data;
  };

  useEffect(() => {
    getProductDetail(id).then((res) => {
      setProduct(res);
      if (coverImage === null) { setCoverImage(res.thumbnail) };
      setIsLoading(false);
    });
    // console.log(quan.current)
    // quan.current.addEventListener()
  }, []);

  // const addToCart = async (productId) => {
  //   const data = await ProductCall.addCart(BASE_URL + `${id}`);
  //   return data;
  // };
  /*  const addToCart = async (productId) => {
     const data = await ProductCall.addCart(BASE_URL + `${id}`);
     return data;
   }; */

  return (
    <Layout>
      <div className="container">

        <div>
          <div className={styles.backButtonDiv}>
            <Link className={styles.gobackButton} to="/">
              ⬅ Go back
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
                          key={data.id}
                          src={image}
                          className={`${styles.smallerImages} ${styles.imageAnimation}`}
                          onClick={handleImageChange}
                        />
                      </div>
                    ))}
                </div>

                <div className={styles.profileImageContainer}>
                {
                    data && (
                    <img
                      src={coverImage}
                      alt="cover pic"
                      className={`${styles.profileImage}`}
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
                <form className={styles.quantityForm} onSubmit="">
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
                </form>
              </div>

              <div className={styles.buttonsDiv}>
                <Link to="/cart">
                  <button className={styles.buyNow} >

                    Buy now
                  </button>
                </Link>
                <button className={styles.addCartButton} onClick={() => onAdd(product, qty)}>
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
