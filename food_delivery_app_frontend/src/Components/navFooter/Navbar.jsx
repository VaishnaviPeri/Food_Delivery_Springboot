import "../../Components/navFooter/Navbar.css";

export default function Navbar() {
  return (
    <>
      <div className="nav">
        <div className="appname">
          <a href="/">Tomato</a>
        </div>
        <div className="options">
          <ul>
            <li><a href="/login">Login</a></li>
            <li><a href="/register">Sign Up</a></li>
          </ul>
        </div>
      </div>
    </>
  );
}
