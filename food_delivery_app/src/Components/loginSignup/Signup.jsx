import "../../Components/loginSignup/Signup.css";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import React, { useEffect, useState } from "react";
import Signupvalidation from "./Signupvalidation";
import { useNavigate } from "react-router-dom";

export default function Signup() {
  
  const navigate = useNavigate();
  const [values, setValues] = useState({
    name:"",
    email: "",
    number:"",
    address:"",
    city:"",
    state:"",
    zipcode:"",
    password:"",
    cpassword:""

  })

  
  const [errors, setErrors] = useState({});

  function handleChange(e) {
    setValues({ ...values, [e.target.name]: e.target.value });
  }

  function handleSubmit(e) {
    e.preventDefault();
    setErrors(Signupvalidation(values)); 
  }

  useEffect(() => {
    const areAllFieldsFilled = (
        values.email !== '' &&
        values.password !== '' &&
        values.name !== '' &&
        values.number !== '' &&
        values.address !== '' &&
        values.city !== '' &&
        values.state !== '' &&
        values.zipcode !== '' &&
        values.cpassword !== ''
    );

    if (Object.keys(errors).length === 0 && areAllFieldsFilled) {
        alert("Signing up!");
        console.log("working");
        navigate("/login");
    }
}, [errors]);

  const [selectedGender, setSelectedGender] = useState("");
  const [selectedRole, setSelectedRole] = useState("");

  const handleGenderChange = (e) => {
    setSelectedGender(e.target.value);
  };
  const handleRoleChange = (e) => {
    setSelectedRole(e.target.value);
  };

  return (
    <>
      <div className="container">
        <section>
          <div className="forms">
            <h3>Sign Up</h3>
            <Form onSubmit={handleSubmit}>
              <Form.Group className="mb-3 col-lg-6" controlId="formBasicName">
                <Form.Label>Name:</Form.Label>
                <Form.Control type="text" placeholder="Enter your Name" name = "name" value={values.name} onChange={handleChange}/>
                {errors.name && <small style={{ color: "red" }}>{errors.name}</small>}
              </Form.Group>
              <Form.Group className="mb-3 col-lg-6" controlId="formBasicEmail">
                <Form.Label>Email:</Form.Label>
                <Form.Control type="email" placeholder="Enter your email" name = "email" value={values.email} onChange={handleChange}/>
                {errors.email && <small style={{ color: "red" }}>{errors.email}</small>}
                {/* <Form.Text className="text-muted">
                  We'll never share your email with anyone else.
                </Form.Text> */}
              </Form.Group>
              <Form.Group className="mb-3 col-lg-6" controlId="formBasicMobile">
                <Form.Label>Mobile Number:</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Enter your Mobile number"
                  name = "number" 
                  value={values.number}
                  onChange={handleChange}
                />
                {errors.number && <small style={{ color: "red" }}>{errors.number}</small>}
              </Form.Group>
              <Form.Group className="mb-3 col-lg-6" controlId="formBasicGender">
                <Form.Label>Gender:</Form.Label> &nbsp;
                {["Male", "Female", "Other"].map((gender) => (
                  <Form.Check
                    key={gender}
                    type="radio"
                    label={gender}
                    name="gender"
                    value={gender}
                    checked={selectedGender === gender}
                    onChange={handleGenderChange}
                    inline
                  />
                ))}
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
              <Form.Group className="mb-3 col-lg-6" controlId="address">
                <Form.Label>Address:</Form.Label>
                <Form.Control type="text" placeholder="Enter your Address" name = "address" value={values.address} onChange={handleChange}/>
                {errors.address && <small style={{ color: "red" }}>{errors.address}</small>}
              </Form.Group>
              <Form.Group className="mb-3 col-lg-6" controlId="city">
                <Form.Label>City:</Form.Label>
                <Form.Control type="text" placeholder="Enter your City" name = "city" value={values.city} onChange={handleChange}/>
                {errors.city && <small style={{ color: "red" }}>{errors.city}</small>}
              </Form.Group>
              <Form.Group className="mb-3 col-lg-6" controlId="state">
                <Form.Label>State:</Form.Label>
                <Form.Control type="text" placeholder="Enter your State" name = "state" value={values.state} onChange={handleChange}/>
                {errors.state && <small style={{ color: "red" }}>{errors.state}</small>}
              </Form.Group>
              <Form.Group className="mb-3 col-lg-6" controlId="zipcode">
                <Form.Label>Zipcode:</Form.Label>
                <Form.Control type="text" placeholder="Enter your Zipcode" name = "zipcode" value={values.zipcode} onChange={handleChange}/>
                {errors.zipcode && <small style={{ color: "red" }}>{errors.zipcode}</small>}
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
              <Form.Group className="mb-3 col-lg-6" controlId="confirmPassword">
                <Form.Label>Confirm Password:</Form.Label>
                <Form.Control
                  type="password"
                  placeholder="Confirm Your Password"
                  name = "cpassword" 
                  value={values.cpassword}
                  onChange={handleChange}
                />
                {errors.cpassword && <small style={{ color: "red" }}>{errors.cpassword}</small>}
              </Form.Group>
              <Button
                className="button"
                style={{ backgroundColor: "crimson"}}
                type="submit"
              >
                Sign Up
              </Button> &nbsp;
              <Button className="button  btn-secondary" type="reset">
                Reset
              </Button>
            </Form>
          </div>
          {/* <div className="image"></div> */}
        </section>
      </div>
    </>
  );
}
