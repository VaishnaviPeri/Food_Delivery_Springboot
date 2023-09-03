import React from "react"
import Food from "../../assets/foodapp1.png"
import Navbar from '../navFooter/Navbar'

const HomePage = () => {
  return (
    <div>
      <div>
      <Navbar/>
        <div className="image">
        <img src= {Food} alt="Food Photo" />
        </div>
        <h1>Tomato : A Food Delivery platform</h1>
        <p>"Delight in Every Bite: Bringing Your Favorites to Your Doorstep"</p>
      </div>
    </div>
  );
};

export default HomePage;
