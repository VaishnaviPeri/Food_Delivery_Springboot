import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";
import "../webpages/RestaurantMenu.css";

const RestaurantMenu = ({ restaurantId }) => {
  const [menu, setMenu] = useState([]);
  const [cart, setCart] = useState([]);
  const [selectedItem, setSelectedItem] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const navigate = useNavigate();
  const { customer_id } = useParams();

  useEffect(() => {
    axios
      .get(`http://localhost:8080/menu/viewbyrestaurant/${restaurantId}`)
      .then((response) => {
        const fetchedMenu = response.data || [];
        setMenu(fetchedMenu);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching menu: ", error);
        setLoading(false);
        setError("An error occurred while fetching the menu.");
      });
  }, [restaurantId]);

  const addToCart = (itemToAdd) => {
    // Prompt the user for the quantity
    const quantityToAdd = prompt(`Enter the quantity for ${itemToAdd.dish_name}:`, 1);

    if (quantityToAdd !== null) {
      // Convert quantityToAdd to a number and check if it's a valid number
      const quantityValue = Number(quantityToAdd);
      if (!isNaN(quantityValue) && quantityValue > 0) {
        // Create a new cart item object
        const newItem = {
          menu_id: itemToAdd.menu_id,
          dish_name: itemToAdd.dish_name,
          quantity: quantityValue,
          dish_price: itemToAdd.dish_price,
        };

        // Set the selected item and add the new item to the cart
        setSelectedItem(itemToAdd);
        setCart([...cart, newItem]);
      } else {
        alert('Please enter a valid quantity (a positive number).');
      }
    }
  };

  const getTotalPrice = () => {
    return cart.reduce((total, item) => total + item.quantity * item.dish_price, 0);
  };

  const placeOrder = () => {
    if (!selectedItem) {
      console.error("No item selected for order");
      return;
    }

    const totalQuantity = cart.reduce((total, item) => total + item.quantity, 0);

    const orderDetails = {
      customer: {
        customer_id: customer_id,
      },
      item_quantity: totalQuantity,
      menu: {
        menu_id: selectedItem.menu_id,
      },
    };

    axios
      .post(`http://localhost:8080/cart/save`, orderDetails)
      .then((response) => {
        const updatedCartId = response.data.cart_id;
        // Clear the selected item
        navigate(`/orders/${customer_id}`);
      })
      .catch((error) => {
        console.error("Error placing order: ", error);
      });
  };

  return (
    <div>
      <h2>Restaurant Menu</h2>
      {loading ? (
        <p>Loading...</p>
      ) : error ? (
        <p>{error}</p>
      ) : (
        <ul>
          {menu.length > 0 ? (
            menu.map((item) => (
              <li key={item.menu_id}>
                {item.dish_name} - INR.{item.dish_price}{" "}
                <button onClick={() => addToCart(item)}>Add</button>
              </li>
            ))
          ) : (
            <li>No items available in the menu</li>
          )}
        </ul>
      )}
      {cart.length > 0 && (
        <div>
          <h2>Cart</h2>
          <ul>
            {cart.map((item, index) => (
              <li key={index}>
                {item.dish_name} - INR. {item.dish_price} - {item.quantity} nos.
              </li>
            ))}
          </ul>
          <p>Total Price: INR. {getTotalPrice()}</p>
          <button onClick={placeOrder}>Place Order</button>
        </div>
      )}
    </div>
  );
};

export default RestaurantMenu;
