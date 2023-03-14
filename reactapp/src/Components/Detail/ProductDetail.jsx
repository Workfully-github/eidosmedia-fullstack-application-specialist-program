import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { ProductCall } from "../../ApiCall/ProductCall";
import "../Detail/ProductDetail.css";

function ProductDetail() {
  const BASE_URL = "https://dummyjson.com/products/";

  const [product, setProduct] = useState(null);

  const { id } = useParams();

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

  return (
    <div>
      <section className="header-section">
        <div className="product-info">
        {product && (<img src={product.thumbnail} alt="cover pic" className="profile-image" />)}
          {product && <h3><b>{product.title}</b></h3>}
          <div>
           {/*  {product && <h4><b>About this product:</b></h4>} */}
            {product && <p id="description-letter">{product.description}</p>}
        </div>
          <div className="display-id-brand">
            {product && <h4>ID: {product.id}</h4>}
            {product && <h4>Brand: {product.brand}</h4>}
          </div>
          <div className="display-price-rating">
            {product && <h3>{product.price}$</h3>}
            {product && <h4>{product.discountPercentage}%</h4>}
            {product && <h4>Rating: {product.rating}</h4>}
          </div>
          <div className="display-discount-products">
            {product && <h4>{product.stock} products left</h4>}
            {product && <h5>Category: {product.category}</h5>}
          </div>
        </div>
      </section>
      <section className="description-section">
        <div>
            {product && <h4><b>About this product:</b></h4>}
            {product && <h4>{product.description}</h4>}
        </div>
      </section>
    </div>
  );
}

export default ProductDetail;
