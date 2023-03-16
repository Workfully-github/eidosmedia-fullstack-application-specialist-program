import { useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";
import { ProductCall } from "../../ApiCall/ProductCall";
import styles from './ProductDetail.module.css'
import Recommendation from "../Recommendation/Recommendation";

function ProductDetail() {
  const BASE_URL = "https://eidos-api.herokuapp.com/api/v1/products/";

  const [product, setProduct] = useState(null);
  const [quantity, setQuantity] = useState(0);

  const { id } = useParams();

  const handleQuantity = (e) => setQuantity(e.target.value);

  const getProductDetail = async (id) => {
    const data = await ProductCall.get(BASE_URL + `${id}`);
    return data;
  };

  useEffect(() => {
    getProductDetail(id).then((res) => {
      setProduct(res);
    });
  }, []);

  const addToCart = async (productId) => {
    const data = await ProductCall.addCart(BASE_URL + `${id}`);
    return data;
  };

  return (
    <div>
      <section className={styles.headerSection}>
        <section className={styles.imageSection}>
          <div className={styles.smallImagesDiv}>
            {product &&
              product.images.map((image) => (
                <div className={styles.smallImageContainer}>
                  <img key={product.id} src={image} className={`${styles.smallerImages} ${styles.imageAnimation}`} />
                </div>
              ))}
          </div>

          {product && (
            <img
              src={product.thumbnail}
              alt="cover pic"
              className={`${styles.profileImage}`}
            />
          )}
        </section>
        <div className={styles.productInfo}>
          {product && (
            <h2 className={styles.productTitle}>
              <b>{product.title}</b>
            </h2>
          )}

          <div>
            {product && <p id={styles.descriptionLetter}>{product.description}</p>}
          </div>

          <div className={styles.displayPrice}>
            {product && <h3 id={styles.priceHeader}>{product.price}$</h3>}
          </div>

          <div className={styles.displayIdBrand}>
            {product && <p className={styles.brandStyles}>Brand: {product.brand}</p>}
            {product && <p>In stock: {product.stock}</p>}
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
                value={quantity}
                onChange={handleQuantity}
              />
            </form>
          </div>

          <div className={styles.buttonsDiv}>
            <Link className={styles.buyNow} to="/cart">
              Buy now
            </Link>
            <button className={styles.addCartButton} onClick={addToCart}>
              Add to Cart
            </button>
          </div>
        </div>
      </section>

      <section>
        <Recommendation categoryProduct={product?.category} productId={product?.id}/>
      </section>
    </div>
  );
}

export default ProductDetail;
