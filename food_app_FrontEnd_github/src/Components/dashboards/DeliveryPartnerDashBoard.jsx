import React, { useEffect, useState } from "react";
import axios from "axios";
import Usernav from "../navFooter/UserNav";
import "./Deliverypartnerdashboard.css";
import { Link } from "react-router-dom";
import Swal from "sweetalert2";



export default function DeliveryPartnerDashBoard() {

    const [id, setPartnerId] = useState(null); //initialize deliverypartner id state

    useEffect(() => {
        const fetchPartnerId = async () => {
            try {
                const response = await axios.get("http://localhost:8080/deliverypartner/view/1");
                setPartnerId(response.data.id);
            } catch (error) {
                console.error("Error fetching deliver partner Id: ", error);
            }
        };
        fetchPartnerId()
    }, [])

    const handleProfileClick = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/deliverypartner/view/${id}`);

            // extracting details from the user
            const {
                deliveryPartnerName,
                deliveryPartnerContact,
                deliveryPartnerEmail
            } = response.data;

            //display partner details in swal dialogue

            Swal.fire({
                title: `DeliveryPartner profile`,
                html: `<p><strong>Partner ID :</strong> ${id}</p>
                    <p><strong>Partner Name :</strong> ${deliveryPartnerName}</p>
                    <p><strong>Partner Contact :</strong> ${deliveryPartnerContact}</p>
                    <p><strong>Partner Email :</strong> ${deliveryPartnerEmail}</p> `,

                customClass: {
                    confirmButton: "ok-button",
                },
            });
        } catch (error) {
            console.error("Error fetching Partner Details", error);
        }
    };

    return (
        <>
            <Usernav />
            <nav className="deliverpartner-dasboard">
                <ul>
                    <li>
                        <Link to="#" onClick={handleProfileClick}> My Profile </Link>
                    </li>
                    <li>
                        <Link to="#" > My Delivery </Link>
                    </li>
                    {id && (
                        <li>
                            <Link to={`/delivery-partner-update/${id}`}>Update Details</Link>
                        </li>
                    )}
                </ul>
            </nav>
        </>
    )
}
