import React, { useEffect, useState } from "react";
import "../../Components/loginSignup/Login.css";
import login from "../../assets/logfood.png";
import validation from "../../Components/loginSignup/Validation"
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const navigate = useNavigate();
  const [selectedRole, setSelectedRole] = useState("");
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
    if (selectedRole === "User") {
      navigate("/user-dashboard"); // Replace with the actual user dashboard route
    } else if (selectedRole === "Restaurant") {
      navigate("/restaurant-dashboard"); // Replace with the actual restaurant dashboard route
    } else if(selectedRole === "Driver"){
      navigate("/driver-dashboard");
    }
  }
  useEffect(()=>{
    if(Object.keys(errors).length === 0 && (values.email !== '' && values.password !== ''))
      alert ("Loging in!");
      console.log("working");
  },[errors])

  return (

    <>
      <div className="container mt-5">
        <section className="d-flex justify-content-between">
          <div className="forms mt-3" style={{width:"100%"}}>
            <h3>Login</h3>
            <Form onSubmit={handleSubmit}>
            <Form.Group className="mb-3 col-lg-6" controlId="formBasicEmail">
                <Form.Label>Email:</Form.Label>
                <Form.Control type="text" name = "email" value={values.email} onChange={handleChange} placeholder="Enter your email" />
                <Form.Text className="text-muted">
                {errors.email && <small style={{ color: "red" }}>{errors.email}</small>}
                </Form.Text>
              </Form.Group>
              <Form.Group className="mb-3 col-lg-6" controlId="password">
                <Form.Label>Password:</Form.Label>
                <Form.Control
                  type="password"
                  placeholder="Enter Your Password"
                  name = "password"
                  value={values.password}
                  onChange={handleChange}
                />
                {errors.password && <small style={{ color: "red" }}>{errors.password}</small>}
              </Form.Group>
              <Form.Group className="mb-3 col-lg-6" controlId="formBasicRole">
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
                ))}
              </Form.Group>
              <Button
                className="button col-lg-6"
                style={{ backgroundColor: "crimson"}}
                type="submit"
              >
                Login
              </Button> <br /> <br />
              <Button className="button btn-secondary col-lg-6" type="reset">
                Reset
              </Button>
            </Form>
          </div>
          <div className="image">
              <div className="login-image">
                <img src={login} style={{maxWidth:480}} alt="Login image" />
              </div>
          </div>
        </section>
      </div>
    </>
  );
}
