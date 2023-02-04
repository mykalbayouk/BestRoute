import React, {useState} from "react";
import { getData } from './connection/sendtobackend'
import './Begin.css'
import './App.css'

//Should have a form with a text input for the starting location and a text input for the destination
//Should be able to prompt the user to get their current location in the browser
function Begin() {
    const [carTime, setCarTime] = useState("");
    const [carCost, setCarCost] = useState("");
    const [flightCost, setFlightCost] = useState("");
    const [flightTime, setFlightTime] = useState("");
    const [fasterText, setFasterText] = useState("");
    const [cheaperText, setCheaperText] = useState("");

    const handleSubmit = (event) => { 
        event.preventDefault();
        getData(event.target.form.start.value, 
                event.target.form.destination.value, 
                event.target.form.carmake.value,
                event.target.form.carmodel.value,
                event.target.form.caryear.value,
                event.target.form.numpeople.value).then((data) => {
            setCarCost(data.driveCost);
            setCarTime(data.driveTime + " hours");
            setFlightCost(data.flightCost);
            setFlightTime(data.flightTime + " hours");
            if (parseFloat(data.driveTime) < parseFloat(data.flightTime)) {
                setFasterText("It is faster to drive and ");
            } else {
                setFasterText("It is faster to fly and ");
            }
            if (parseFloat(data.driveCost) < parseFloat(data.flightCost)) {
                setCheaperText("It is cheaper to drive");
            } else {
                setCheaperText("It is cheaper to fly");
            }
        });
    }


    return (
        <div id = "begin">
            <div id = "formcontainer">
                <p></p>
                <h1 className = "homepageheader">Enter Your Information</h1>
                <form id = "form">
                    <label for = "start" className = "inputLabel">Starting Location</label>
                    <input type = "text" id = "start" name = "start" placeholder = "Enter starting location" className = "inputBox"></input>
                    <label for = "destination" className = "inputLabel">Destination</label>
                    <input type = "text" id = "destination" name = "destination" placeholder = "Enter destination" className = "inputBox"></input>
                    <label for = "carmake" className = "inputLabel">Car Make</label>
                    <input type = "text" id = "carmake" name = "carmake" placeholder = "Enter car make" className = "inputBox"></input>
                    <label for = "carmodel" className = "inputLabel">Car Model</label>
                    <input type = "text" id = "carmodel" name = "carmodel" placeholder = "Enter car model" className = "inputBox"></input>
                    <label for = "caryear" className = "inputLabel">Car Year</label>
                    <input type = "text" id = "caryear" name = "caryear" placeholder = "Enter car year" className = "inputBox"></input>
                    <label for = "numpeople" className = "inputLabel">Number of People</label>
                    <input type = "text" id = "numpeople" name = "numpeople" placeholder = "Enter number of people" className = "inputBox"></input>
                    <input type = "submit" value = "Submit" className = "submitButton" onClick = {handleSubmit}></input>
                </form>
            </div>
            <div id = "resultscontainer">
                <h1 className = "homepageheader">Results</h1>
                <div id = "results">
                    <h3 className = "homepageheader">Cost of Driving:</h3>
                    <p>${parseFloat(carCost).toFixed(1)}</p>
                    <h3 className = "homepageheader">Time of Driving:</h3>
                    <p>{parseFloat(carTime).toFixed(2)}</p>
                    <h3 className = "homepageheader">Cost of Flying:</h3>
                    <p>${parseFloat(flightCost).toFixed(1)}</p>
                    <h3 className = "homepageheader">Time of Flying:</h3>
                    <p>{parseFloat(flightTime).toFixed(2)}</p>
                </div>
                <p className = "resultstexter">{fasterText} {cheaperText}</p>
            </div>
        </div>
    )
}

export default Begin