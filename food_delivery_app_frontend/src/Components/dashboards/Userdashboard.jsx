import Usernav from "../navFooter/UserNav";
import "../dashboards/Userdashboard.css"
import Swal from 'sweetalert2';


export default function Userdashboard() {

  return (
    <>
      <Usernav />
      <div className="left-side-data">
        <ul>
          <li onClick={()=>{
                Swal.fire({
                  text:'Hello Username!',
                  customClass: {
                    confirmButton: 'ok-button', // Apply custom class to "OK" button
                  },
                });
          }}>Profile</li>
          <li>Your Orders</li>
          <li>Your Order History</li>
        </ul>
      </div>
      <div className="search-bar-container">
        <div className="inputs">
          <input type="text"  
          placeholder="Type to search.."
          /> <button>Search</button>
        </div> 
        <div>
          Search Results
        </div>
      </div>
    </>
  );
}
