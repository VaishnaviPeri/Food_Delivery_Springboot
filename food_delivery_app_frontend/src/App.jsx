import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from './Components/navFooter/Navbar'
import Footer from './Components/navFooter/Footer'
import { BrowserRouter as Router } from 'react-router-dom'
import { Routes,Route} from 'react-router-dom'
import HomePage from './Components/webpages/Homepage'
import Login from './Components/loginSignup/Login'
import Signup from './Components/loginSignup/Signup'
import About from './Components/webpages/About';
import Userdashboard from './Components/dashboards/Userdashboard';
import Hoteldashboard from './Components/dashboards/Hoteldashboard';
import Contact from './Components/webpages/Contact';

function App() {

  return (
    <>

      <div className="container">
      <Router>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path = "/login" element = {<Login />} />
        <Route path = "/register" element = {<Signup />} />
        <Route path = "/about" element = {<About />}/>
        <Route path = "/contact" element = {<Contact />}/>
        <Route path = "/user-dashboard" element = {<Userdashboard />}/>
        <Route path = "/restaurant-dashboard" element = {<Hoteldashboard />}/>
      </Routes>
      </Router>
      </div>
      <Footer/>
    </>
  )
}

export default App
