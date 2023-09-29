import React, { useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom"; // Import useParams
import Usernav from "../navFooter/UserNav";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import axios from "axios";

export default function Addmenu() {
  const navigate = useNavigate();
  const { restaurant_id } = useParams(); // Get restaurant_id from URL parameters
  const [formData, setFormData] = useState({
    dish_name: "",
    category: "",
    quantity: 0,
    dish_price: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post(`http://localhost:8080/menu/add/${restaurant_id}`, formData);
      if (response.status === 201) {
        alert("Menu Added Successfully");
        navigate(`/restaurant-dashboard/${restaurant_id}`); // Corrected interpolation
      } else {
        console.error("Failed to add data");
      }
    } catch (error) {
      console.error("Error:", error);
    }
  };

  return (
    <>
      <Usernav />
      <div className="container">
        <Form onSubmit={handleSubmit}>
          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Dish Name</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter Dish Name"
              name="dish_name"
              value={formData.dish_name}
              onChange={handleChange}
            />
          </Form.Group>
          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Category</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter Dish Category"
              name="category"
              value={formData.category}
              onChange={handleChange}
            />
          </Form.Group>
          {/* <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Quantity</Form.Label>
            <Form.Control
              type="number"
              placeholder="Enter Quantity"
              name="quantity"
              value={formData.quantity}
              onChange={handleChange}
            />
          </Form.Group> */}
          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Price</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter Price"
              name="dish_price"
              value={formData.dish_price}
              onChange={handleChange}
            />
          </Form.Group>
          <Button
            variant="primary"
            style={{ background: "crimson" }}
            type="submit"
          >
            Submit
          </Button>
        </Form>
      </div>
    </>
  );
}
