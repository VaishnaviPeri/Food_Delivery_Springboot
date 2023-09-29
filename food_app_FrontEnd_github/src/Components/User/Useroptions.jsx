import React, { useState, useEffect } from "react";
import { Link, useParams } from "react-router-dom";
import Swal from "sweetalert2";
import axios from "axios";
import "./Useroptions.css";

export default function Useroptions() {
  const { customer_id } = useParams(); // Access customer_id from URL parameters

  const [customer, setCustomer] = useState(null);

  // Fetch user data when the component mounts or customer_id changes
  useEffect(() => {
    const fetchCustomerData = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/customer/view/${customer_id}`);

        // Extract user details from the response
        const {
          customer_emailId,
          customer_phone_no,
          customer_name,
          address,
          city,
          zipcode,
        } = response.data;

        // Set the customer object with user details
        setCustomer({
          customer_emailId,
          customer_phone_no,
          customer_name,
          address,
          city,
          zipcode,
        });
      } catch (error) {
        console.error("Error fetching user data:", error);
      }
    };

    if (customer_id) {
      fetchCustomerData();
    }
  }, [customer_id]);

  const handleProfileClick = () => {
    if (customer) {
      // Display user details in Swal dialog
      Swal.fire({
        title: `User Profile`,
        html: `
          <p><strong>User ID:</strong> ${customer_id}</p>
          <p><strong>User Email:</strong> ${customer.customer_emailId}</p>
          <p><strong>User Mobile Number:</strong> ${customer.customer_phone_no}</p>
          <p><strong>User Name:</strong> ${customer.customer_name}</p>
          <p><strong>User Address:</strong> ${customer.address}</p>
          <p><strong>City:</strong> ${customer.city}</p>
          <p><strong>Zipcode:</strong> ${customer.zipcode}</p>
        `,
        customClass: {
          confirmButton: "ok-button",
        },
      });
    }
  };

  return (
    <nav className="user-options">
      <ul>
        <li>
          <Link to="#" onClick={handleProfileClick}>
            Profile
          </Link>
        </li>
        <li>
          <Link to={`/orders/${customer_id}`}>Orders</Link>
        </li>
        {customer_id && (
          <li>
            <Link to={`/update/${customer_id}`}>Update Details</Link>
          </li>
        )}
      </ul>
    </nav>
  );
}
