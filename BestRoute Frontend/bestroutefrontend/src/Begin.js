import React from 'react'


//Should have a form with a text input for the starting location and a text input for the destination
//Should be able to prompt the user to get their current location in the browser
function Begin() {
    return (
        <div id = "formcontainer">
            <form id = "form">
                <label for = "start">Starting Location</label>
                <input type = "text" id = "start" name = "start" placeholder = "Enter starting location"></input>
                <label for = "destination">Destination</label>
                <input type = "text" id = "destination" name = "destination" placeholder = "Enter destination"></input>
                <input type = "submit" value = "Submit"></input>
            </form>
        </div>
    )
}

export default Begin