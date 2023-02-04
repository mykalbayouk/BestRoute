export async function getData(startingLocation, endingLocation, carMake, carModel, carYear, numPeople) {
    const response = await fetch('http://localhost:8080/send?' + new URLSearchParams({
        startingLocation: startingLocation,
        endingLocation: endingLocation,
        carMake: carMake,
        carModel: carModel,
        carYear: carYear,
        numPeople: numPeople,
    }), {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
    });
    const data = await response.json();
    return data;
}