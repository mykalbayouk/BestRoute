import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link}
    from 'react-router-dom';
import Homepage from './Homepage';
import Begin from './Begin';
import './App.css';

function App() {
  let routes = (
    <Router>
    <Navbar />
    <Routes>
        <Route exact path='/' element={<Homepage />} />
        <Route path='/begin' element={<Begin />} />
    </Routes>
    <Footer />
    </Router>
  );
  return routes;
}

const Navbar = () => {
  return (
  <div id = "navbar">
    <h1 id = "navbarheader">
      <Link to = "/">Best Route</Link>
    </h1>
    <div id = "navelements">
      <li className = "navelement">
        <Link to="/">Home</Link>
      </li>
      <li className = "navelement">
        <Link to="/begin">Start Here</Link>
      </li>
    </div>
  </div>
  );
}

const Footer = () => {
  return (
    <div id = "footer">
      <p>&copy; George V. Herrmann, Michael Bayouk, Jackson Greer</p>
    </div>
  );
}

export default App;