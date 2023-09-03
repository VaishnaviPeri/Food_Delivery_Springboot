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

function App() {

  return (
    <>
      <Navbar/>
      <div className="container">
      <Router>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path = "/login" element = {<Login />} />
        <Route path = "/register" element = {<Signup />} />
        <Route path = "/about" element = {<About />}/>
      </Routes>
      </Router>
      </div>
      <Footer/>
    </>
  )
}

export default App
