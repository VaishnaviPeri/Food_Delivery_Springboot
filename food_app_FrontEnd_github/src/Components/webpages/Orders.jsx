import React, { useState, useEffect } from "react";
import axios from "axios";
import Usernav from "../navFooter/UserNav";

const Orders = () => {
  const [cartItems, setCartItems] = useState([]);
  const [orderPlaced, setOrderPlaced] = useState(false);
  const [cartId, setCartId] = useState(null); // Store cart_id obtained from the backend

  useEffect(() => {
    // Fetch cart items and cart_id from the backend
    axios
      .get(`http://localhost:8080/cart/view/${cart_id}`)
      .then((response) => {
        setCartItems(response.data.cartItems);
        setCartId(response.data.cartId); // Set cart_id obtained from the response
      })
      .catch((error) => {
        console.error("Error fetching cart items: ", error);
      });
  }, []);

  const placeOrder = () => {
    if (!cartId) {
      console.error("Cart ID is missing.");
      return;
    }

    // Send a POST request to generate the bill with cart_id in the request body
    axios
      .post("http://localhost:8080/bill/generate", { cartId: cartId })
      .then((response) => {
        // Handle the response as needed, e.g., show the bill details
        console.log("Bill generated:", response.data);
        setOrderPlaced(true);
      })
      .catch((error) => {
        console.error("Error generating the bill: ", error);
      });
  };

  return (
    <div>
      <Usernav />
      <h2>Order Summary</h2>
      {cartItems.length === 0 ? (
        <p>Your cart is empty.</p>
      ) : (
        <ul>
          {cartItems.map((item) => (
            <li key={item.menu_id}>
              {item.dish_name} - {item.price}
            </li>
          ))}
        </ul>
      )}
      {cartItems.length > 0 && !orderPlaced && (
        <button onClick={placeOrder}>Generate Bill</button>
      )}
      {orderPlaced && <p>Order placed successfully!</p>}
    </div>
  );
};

export default Orders;
