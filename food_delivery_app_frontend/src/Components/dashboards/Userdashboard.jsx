import Usernav from "../navFooter/UserNav";
import { useState } from "react";
import Offcanvas from "react-bootstrap/Offcanvas";

export default function Userdashboard() {
  // const [show, setShow] = useState(false);

  // const handleClose = () => setShow(false);
  // const handleShow = () => setShow(true);

  return (
    <>
      <Usernav />
      {/* <h3 onClick={handleShow}>
        Your Activity
      </h3> */}
      <div class="row">
        <div class="col-4">
          <div
            id="simple-list-example"
            class="d-flex flex-column gap-2 simple-list-example-scrollspy text-center"
          >
            <a class="p-1 rounded" href="#simple-list-item-1">
              Profile
            </a>
            <a class="p-1 rounded" href="#simple-list-item-2">
              Your Orders
            </a>
            <a class="p-1 rounded" href="#simple-list-item-3">
              Your Order History
            </a>
          </div>
        </div>
        <div class="col-8">
          <div
            data-bs-spy="scroll"
            data-bs-target="#simple-list-example"
            data-bs-offset="0"
            data-bs-smooth-scroll="true"
            class="scrollspy-example"
            tabindex="0"
          >
            <h4 id="simple-list-item-1">Profile</h4>
            <p>...</p>
            <h4 id="simple-list-item-2">Your Orders</h4>
            <p>...</p>
            <h4 id="simple-list-item-3">Your Order History</h4>
            <p>...</p>
          </div>
        </div>
      </div>
    </>
  );
}
