import { useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";
import { ProductCall } from "../../ApiCall/ProductCall";
import "../Detail/ProductDetail.css";

function ProductDetail() {
  const BASE_URL = "https://eidos-api.herokuapp.com/api/products/";

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
      console.log(res);
      setProduct(res);
    });
  }, []);

  const addToCart = async (productId) => {
    const data = await ProductCall.addCart(BASE_URL + `${id}`);
    return data 
  };

  return (
    <div>
      <section className="header-section">
        <section className="image-section">

          <div className="small-images-div">
            {product && (product.images.map((image) => (
              <img src={image} className="smaller-images" />)))}
          </div>

          {product && (<img src={product.thumbnail} alt="cover pic" className="profile-image" />)}
        </section>
        <div className="product-info">
          {product && <h2 className="product-title" ><b>{product.title}</b></h2>}

          <div>
            {product && <p id="description-letter">{product.description}</p>}
          </div>

          <div className="display-price">
            {product && <h3 id="price-header">{product.price}$</h3>}
          </div>

          <div className="display-id-brand">
            {product && <p className="brand-styles">Brand: {product.brand}</p>}
            {product && <p>In stock: {product.stock}</p>}
            {product && <p>Rating: {product.rating}</p>}
          </div>

          <div className="quantity-div">
            <form className="quantity-form" onSubmit="">
              <label htmlFor="quantity">Quantity: </label>
              <input className="quantity-input" type="number" name="quantity" value={quantity} onChange={handleQuantity} />
            </form>
          </div>

          <div className="buttons-div">
            <Link className="buy-now" to="/cart">Buy now</Link>
            <button className="add-cart-button" onClick={addToCart}>Add to Cart</button>
          </div>
        </div>
      </section>
    </div>
  );
}

export default ProductDetail;
