import { useState, useEffect, useRef } from "react";
import { useParams, Link } from "react-router-dom";
//import { ProductCall } from "../../ApiCall/ProductCall";
import styles from "./ProductDetail.module.css";
import Recommendation from "../Recommendation/Recommendation";
import { useStateContext } from "../Context/StateContext";
import SkeletonCard from "../Card/SkeletonCard";

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
  const [imageSrc, setImageSrc] = useState("");

  /* const { id } = useParams(); */

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
      if (coverImage === null) {setCoverImage(res.thumbnail)};
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
              {product &&
                product.images.map((image) => (
                  <div className={styles.smallImageContainer}>
                    <img
                      key={product.id}
                      src={image}
                      className={`${styles.smallerImages} ${styles.imageAnimation}`}
                      onClick={handleImageChange}
                    />
                  </div>
                ))}
            </div>

            {product && (
              <img
                src={coverImage}
                alt="cover pic"
                className={`${styles.profileImage}`}
              />
            )}
          </section>
        ) : (
          skeletonArr.map((skeleton) => <SkeletonCard />)
        )}

        <div className={styles.productInfo}>
          {product && (
            <h1 className={styles.productTitle}>
              <b>{product.title}</b>
            </h1>
          )}

          <div>
            {product && (
              <p id={styles.descriptionLetter}>{product.description}</p>
            )}
          </div>

          <div className={styles.displayPrice}>
            {product && <h3 id={styles.priceHeader}>{product.price}$</h3>}
          </div>

          <div className={styles.displayIdBrand}>
            {product && (
              <p className={styles.brandStyles}>Brand: {product.brand}</p>
            )}
            {product && <p>Stock: {product.stock}</p>}
            {product && <p>Rating: {product.rating}</p>}
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
            <Link className={styles.buyNow} to="/cart">
              Buy now
            </Link>
            <button className={styles.addCartButton}  onClick={() => onAdd(product, qty)}>
              Add to Cart
            </button>
          </div>
        </div>
      </section>

      <section>
        {/* <Recommendation categoryProduct={product?.category} productId={product?.id}/> */}
        <Recommendation
          category={product?.category}
          productId={product?.id}
        />
      </section>
    </div>
  );
}

export default ProductDetail;
