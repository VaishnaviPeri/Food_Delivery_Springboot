import React, { useEffect, useState } from "react";
import "../../Components/loginSignup/Login.css";
import login from "../../assets/logfood.png";
import validation from "../../Components/loginSignup/Validation";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { useNavigate } from "react-router-dom";
import Navbar from "../navFooter/Navbar";

export default function Login() {
  const navigate = useNavigate();
  const [selectedRole, setSelectedRole] = useState("");
  const [roleError, setRoleError] = useState("");

  const handleRoleChange = (e) => {
    setSelectedRole(e.target.value);
  };
  const [values, setValues] = useState({
    email: "",
    password: "",
  });

  const [errors, setErrors] = useState({});

  function handleChange(e) {
    setValues({ ...values, [e.target.name]: e.target.value });
  }

  function handleSubmit(e) {
    e.preventDefault();
    setErrors(validation(values));

    if (!selectedRole) {
      setRoleError("Please select a role.");
      return; 
    }
    setRoleError("");
    if (selectedRole === "User") {
      navigate("/user-dashboard");
    } else if (selectedRole === "Restaurant") {
      navigate("/restaurant-dashboard");
    } else if (selectedRole === "Driver") {
      navigate("/driver-dashboard");
    }
  }

  useEffect(() => {
    if (Object.keys(errors).length === 0 && values.email !== "" && values.password !== "") {
      alert("Logging in!");
      console.log("working");
    }
  }, [errors]);

  return (
    <>
      <Navbar />
      <div className="container mt-5">
        <section className="d-flex justify-content-between">
          <div className="forms mt-3" style={{ width: "60%", paddingTop:"50px" }}>
            <h3>Login</h3>
            <Form onSubmit={handleSubmit}>
              <Form.Group className="mb-3 col-lg-8" controlId="formBasicEmail">
                <Form.Label>Email:</Form.Label>
                <Form.Control type="text" name="email" value={values.email} onChange={handleChange} placeholder="Enter your email" />
                <Form.Text className="text-muted">
                  {errors.email && <small style={{ color: "red" }}>{errors.email}</small>}
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
              </Form.Group>
              <Form.Group className="mb-3 col-lg-8" controlId="formBasicRole">
                <Form.Label>Select Role:</Form.Label> &nbsp;
                {["User", "Driver", "Restaurant"].map((role) => (
                  <Form.Check
                    key={role}
                    type="radio"
                    label={role}
                    name="role"
                    value={role}
                    checked={selectedRole === role}
                    onChange={handleRoleChange}
                    inline
                  /> 
                ))} <br />
                {roleError && <small style={{ color: "red" }}>{roleError}</small>}
              </Form.Group>
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
              <img src={login} style={{paddingBottom:"50px", paddingLeft:"50px"}} alt="Login image" />
            </div>
          </div>
        </section>
      </div>
    </>
  );
}
