import React from 'react'

import { Link } from 'react-router-dom'

import './Homepage.css'

function Homepage() {
    return (
        <div id = "homepage">
            <h1 className = "homepageheader">Best Route</h1>
            <div id = "homepagebody">
                <p id = "homepagebodytext">
                    Find the best way to travel from point A to point B.
                </p>
                <p></p>
                <div id = "homepagebuttons">
                    <button className = "homepagebutton"><Link to = "/Begin">Start Here</Link></button>
                </div>
            </div>
        </div>
    )
}

export default Homepage