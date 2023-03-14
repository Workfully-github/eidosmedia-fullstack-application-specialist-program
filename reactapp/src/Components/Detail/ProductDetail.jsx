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
      <h2>info on product</h2>
      <section className="header-section">
        <div>
          {product && (<img src={product.thumbnail} alt="cover pic" className="profile-image" />)}
        </div>
        <div>
          {product && <h3>{product.id}</h3>}
          {product && <h3>{product.title}</h3>}
          <div className="display-price-rating">
            {product && <h3>{product.price}$</h3>}
            {product && <h3>rating: {product.rating}</h3>}
          </div>
          <div className="display-discount-products">
            {product && <h3>{product.discountPercentage}%</h3>}
            {product && <h3>{product.stock} products</h3>}
          </div>
        </div>
      </section>
    </div>
  );
}

export default ProductDetail;
