import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import validation from "../../Components/loginSignup/Validation";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Navbar from "../navFooter/Navbar";

export default function Login() {
  const navigate = useNavigate();
  const [values, setValues] = useState({
    username: "",
    password: "",
  });

  const [errors, setErrors] = useState({});
  const [loginError, setLoginError] = useState("");

  function handleChange(e) {
    setValues({ ...values, [e.target.name]: e.target.value });
  }

  async function handleSubmit(e) {
    e.preventDefault();
    setErrors(validation(values));

    if (Object.keys(errors).length === 0 && values.username !== "" && values.password !== "") {
      try {
        // Make a GET request to check if the provided username and password match
        const response = await axios.get("http://localhost:8080/user/get/details", {
          auth: {
            username: values.username,
            password: values.password,
          },
        });

        if (response.status === 200) {
          // Successful login, determine the user's role and redirect accordingly
          const user = response.data;
          if (user.role === "CUSTOMER") {
            // Redirect to the customer dashboard
            navigate(`/customer-dashboard/${user.customer_id}`);
          } else if (user.role === "RESTAURANTS") {
            // Redirect to the restaurant dashboard
            navigate(`/restaurant-dashboard/${user.restaurant_id}`);
          } else if (user.role === "DELIVERYPARTNER") {
            // Redirect to the delivery partner dashboard
            navigate(`/delivery-partner-dashboard/${user.id}`);
          }
        } else {
          setLoginError("Invalid username or password");
        }
      } catch (error) {
        console.error("Error logging in: ", error);
        setLoginError("An error occurred while logging in.");
      }
    }
  }

  return (
    <>
      <Navbar />
      <div className="container mt-5">
        <section className="d-flex justify-content-between">
          <div className="forms mt-3" style={{ width: "60%", paddingTop: "50px" }}>
            <h3>User Login</h3>
            <Form onSubmit={handleSubmit}>
              <Form.Group className="mb-3 col-lg-8" controlId="formBasicEmail">
                <Form.Label>Username:</Form.Label>
                <Form.Control type="text" name="username" value={values.username} onChange={handleChange} placeholder="Enter your Username" />
                <Form.Text className="text-muted">
                  {errors.username && <small style={{ color: "red" }}>{errors.username}</small>}
                </Form.Text>
              </Form.Group>
              <Form.Group className="mb-3 col-lg-8" controlId="password">
                <Form.Label>Password:</Form.Label>
                <Form.Control
                  type="password"
                  placeholder="Enter Your Password"
                  name="password"
                  value={values.password}
                  onChange={handleChange}
                />
                {errors.password && <small style={{ color: "red" }}>{errors.password}</small>}
                {loginError && <small style={{ color: "red" }}>{loginError}</small>}
              </Form.Group>
              <p>Not already a User? <a href="/register" style={{textDecoration:"none",color:"crimson"}}>Click Here!</a></p>
              <Button
                className="button col-lg-8"
                style={{ backgroundColor: "crimson" }}
                type="submit"
              >
                Login
              </Button> <br /> <br />
              <Button className="button btn-secondary col-lg-8" type="reset">
                Reset
              </Button>
            </Form>
          </div>
          <div className="image" style={{ width: "40%", textAlign: "right" }}>
            <div className="login-image">
              {/* Include your login image here */}
            </div>
          </div>
        </section>
      </div>
    </>
  );
}
