import React, { useEffect, useRef, useState } from "react";
import { Link } from "react-router-dom";
import { useStateContext } from "../Context/StateContext";
const CartSlide = () => {
  const {
    toggleCart,
    cartItems,
    totalPrice,
    updateCartItemQty,
    handleCartItemRemove,
  } = useStateContext();
  const cartOpacBg = useRef();
  const cartItemQnt = useRef();

  const reRenderCartItemsQnt = (index, qtyFactor, cartItem) => {
    updateCartItemQty(index, qtyFactor, cartItem);
    cartItemQnt.innerHTML = cartItem[index]?.quantity;
  };

  // useEffect(() => {
  //   document.addEventListener("click", (e) => {
  //     if (e.path[0] === cartOpacBg.current) {
  //       toggleCart();
  //     }
  //   });
  // }, []);

  const handleCheckout = async () => {

    const response = await fetch("/api/stripe", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(cartItems),
    });

    if (response.statusCode === 500) return;

    const data = await response.json();

    
    // stripe.redirectToCheckout({ sessionId: await data.id });
  };

  return (
    <>
      <div
        className="opac-bg"
        ref={cartOpacBg}
       
      >
        <div className="slide-cart-container">
          {cartItems.length > 0 ? (
            <>
              <div className="cart-header">
                <div className="slide-cart-title">
                  <h3>
                    Your Shopping Cart (
                    {cartItems.length === 1
                      ? `one item`
                      : `${cartItems.length} items`}
                    )
                  </h3>
                </div>
                <div
                  className="cart-close"
                  onClick={() => {
                    toggleCart();
                  }}
                >
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 24 24"
                    width="24"
                    height="24"
                  >
                    <path fill="none" d="M0 0h24v24H0z" />
                    <path
                      d="M12 10.586l4.95-4.95 1.414 1.414-4.95 4.95 4.95 4.95-1.414 1.414-4.95-4.95-4.95 4.95-1.414-1.414 4.95-4.95-4.95-4.95L7.05 5.636z"
                      fill="rgba(0,0,0,1)"
                    />
                  </svg>
                </div>
              </div>
              <div className="cart-body">
                {cartItems.map((cartItem, i) => (
                  <div key={i} className="cart-item">
                    <div className="cart-item-left">
                      <img
                        src={cartItem.thumbnail}
                        alt="product img"
                        className="cart-item-img"
                        layout="fill"
                      />
                    </div>
                    <div className="cart-item-mid">
                      <h4 className="cart-item-title">{cartItem?.title}</h4>
                      <span className="cart-item-code">{cartItem?.category}</span>
                      <div className="gnt-changer-container">
                        <div
                          className="cart-qnt-changer qnt-minus"
                          onClick={() => {
                            reRenderCartItemsQnt(i, "dec", cartItem);
                          }}
                        >
                          <span>&#8722;</span>
                        </div>
                        <div className="cart-qnt" ref={cartItemQnt}>
                          {cartItem.quantity}
                        </div>
                        <div
                          className="cart-qnt-changer qnt-plus"
                          onClick={() => {
                            reRenderCartItemsQnt(i, "inc", cartItem);
                          }}
                        >
                          <span>&#43;</span>
                        </div>
                      </div>
                    </div>
                    <div className="cart-item-right">
                      <div className="cart-item-price">
                        {Number(cartItem.price * cartItem.quantity).toFixed(2)}$
                      </div>
                      <div
                        className="cart-item-remove"
                        onClick={() => {
                          handleCartItemRemove(i, cartItem);
                        }}
                      >
                        <span>&#10006;</span>
                      </div>
                    </div>
                  </div>
                ))}
              </div>
              <div className="cart-footer">
                <div className="cart-footer-title">Subtotal</div>
                <div className="subtotal-container">
                  <span className="subtotal">{totalPrice}$</span>
                  <Link href="#navbar">
                    <button
                      className="add-to-cart-btn"
                      onClick={handleCheckout}
                    >
                      Go to Checkout
                    </button>
                  </Link>
                </div>
              </div>
            </>
          ) : (
            <>
              <div className="cart-header">
                <div className="slide-cart-title">
                  <h2>
                    Your Shopping Cart (
                    {cartItems.length === 1
                      ? `one item`
                      : `${cartItems.length} items`}
                    )
                  </h2>
                </div>
                <div
                  className="cart-close"
                  onClick={() => {
                    toggleCart();
                  }}
                >
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 24 24"
                    width="24"
                    height="24"
                  >
                    <path fill="none" d="M0 0h24v24H0z" />
                    <path
                      d="M12 10.586l4.95-4.95 1.414 1.414-4.95 4.95 4.95 4.95-1.414 1.414-4.95-4.95-4.95 4.95-1.414-1.414 4.95-4.95-4.95-4.95L7.05 5.636z"
                      fill="rgba(0,0,0,1)"
                    />
                  </svg>
                </div>
              </div>
              <div className="cart-empty">
                {/* <Image
                  src="#"
                  alt="Empty Cart"
                  width="150px"
                  height="150px"
                /> */}
                <div>Your cart is empty</div>
                <br />
                <button className="checkout" onClick={() => toggleCart()}>
                  Keep Browsing
                </button>
              </div>
            </>
          )}
        </div>
      </div>
    </>
  );
};

export default CartSlide;