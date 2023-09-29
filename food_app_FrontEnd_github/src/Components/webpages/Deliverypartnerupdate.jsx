import React from "react";
import Usernav from "../navFooter/UserNav";
import { useNavigate,useParams } from "react-router-dom";
import { useState } from "react";
import { useEffect } from "react";
import axios from "axios";

export default function Deliverypartnerupdate() {

    const navigate = useNavigate();
    const { id } = useParams(); // Retrieve the delivery partner ID from the URL

    // Define state for form data
    const [formData, setFormData] = useState({
        deliveryPartnerName: '',
        username: '',
        deliveryPartnerContact: '',
        deliveryPartnerEmail: '',

    });

    // Define a function to handle form input changes
    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    // Fetch existing customer data and populate the form
    useEffect(() => {
        // Check if  deliverypartner id is valid before making the API request
        if (!id || isNaN(parseInt(id))) {
            console.error('Invalid customer_id:', id);
            // You can show an error message to the user or redirect them to an error page
            return;
        }

        // Fetch existing partner data from the server using the partner id from URL
        axios
            .get(`http://localhost:8080/deliverypartner/view/${id}`)
            .then((response) => {
                // Populate formData with existing data
                setFormData({
                    deliveryPartnerName: response.data.deliveryPartnerName,
                    username: response.data.username,
                    deliveryPartnerContact: response.data.deliveryPartnerContact,
                    deliveryPartnerEmail: response.data.deliveryPartnerEmail,

                });
            })

            .catch((error) => {
                if (error.response) {
                    console.error('Error fetching delivery partner data:', error.response.status, error.response.data);
                } else if (error.request) {
                    console.error('Error making the request:', error.request);
                } else {
                    console.error('General error:', error.message);
                }
            });
    }, [id]);

    // Define a function to handle form submission
    const handleSubmit = (e) => {
        e.preventDefault();

        // Make an API request to update the customer with formData
        axios
            .put(`http://localhost:8080/deliverypartner/update/${id}`, formData)
            .then(() => {
                // Handle the successful update (e.g., show a success message)
                alert('Updated Successfully');
                navigate(`/deliverypartnerdashboard/${id}`); // Redirect to the user dashboard with the customer_id
            })

            .catch((error) => {
                if (error.response) {
                    console.error('Error updating delivery partner:', error.response.status, error.response.data);
                    // Handle error and provide user feedback
                } else if (error.request) {
                    console.error('Error making the request:', error.request);
                } else {
                    console.error('General error:', error.message);
                }
            });
    };



    return (
        <>
            <Usernav />
            <div className="container">
                <form onSubmit={handleSubmit}>
                    {/* Render form fields */}
                    <div className="mb-3">
                        <label htmlFor="deliveryPartnerName" className="form-label">
                            Name
                        </label>
                        <input
                            type="text"
                            className="form-control"
                            id="deliveryPartnerName"
                            name="deliveryPartnerName"
                            value={formData.deliveryPartnerName}
                            onChange={handleChange}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="deliveryPartnerContact" className="form-label">
                            Contact Number
                        </label>
                        <input
                            type="text"
                            className="form-control"
                            id="deliveryPartnerContact"
                            name="deliveryPartnerContact"
                            value={formData.deliveryPartnerContact}
                            onChange={handleChange}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="deliveryPartnerEmail" className="form-label">
                            Email Id
                        </label>
                        <input
                            type="email"
                            className="form-control"
                            id="deliveryPartnerEmail"
                            name="deliveryPartnerEmail"
                            value={formData.deliveryPartnerEmail}
                            onChange={handleChange}
                        />
                    </div>

                    <button  type="submit" className="btn btn-primary" style={{ background: 'crimson' }}>
                        Update
                    </button>
                </form>
            </div>

        </>
    )

}