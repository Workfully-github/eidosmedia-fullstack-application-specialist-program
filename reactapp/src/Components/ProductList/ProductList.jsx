import React, { useState, useEffect } from 'react'; 

const ProductList = (props) => {
  const {search} = props;
  const [products, setProducts] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [productsPerPage] = useState(10);
  //get the search value sended by the url here

  useEffect(() => {
    const fetchProducts = async () => {
      const response = await fetch('your-product-url.json'); //call the search api
      const data = await response.json(); 
      setProducts(data);
    };

    fetchProducts();
  }, []);

  const indexOfLastProduct = currentPage * productsPerPage;
  const indexOfFirstProduct = indexOfLastProduct - productsPerPage;
  const currentProducts = products.slice(indexOfFirstProduct, indexOfLastProduct);

  const paginate = (pageNumber) => setCurrentPage(pageNumber);

  return (
    <div>
      <ul>
        {currentProducts.map((product) => (
          <li key={product.id}>
            <h3>{product.title}</h3>
            <p>{product.description}</p>
            <p>Price: ${product.price}</p>
            <p>Discount: {product.discountPercentage}%</p>
            <p>Rating: {product.rating}</p>
            <p>Stock: {product.stock}</p>
            <p>Brand: {product.brand}</p>
            <p>Category: {product.category}</p>
            <img src={product.thumbnail} alt={product.title} />
          </li>
        ))}
      </ul>
      <Pagination
        productsPerPage={productsPerPage}
        totalProducts={products.length}
        paginate={paginate}
      />
    </div>
  );
};

const Pagination = ({ productsPerPage, totalProducts, paginate }) => {
  const pageNumbers = [];

  for (let i = 1; i <= Math.ceil(totalProducts / productsPerPage); i++) {
    pageNumbers.push(i);
  }

  return (
    <nav>
      <ul className='pagination'>
        {pageNumbers.map((pageNumber) => (
          <li key={pageNumber} className='page-item'>
            <a onClick={() => paginate(pageNumber)} href='!#' className='page-link'>
              {pageNumber}
            </a>
          </li>
        ))}
      </ul>
    </nav>
  );
};

export default ProductList;
