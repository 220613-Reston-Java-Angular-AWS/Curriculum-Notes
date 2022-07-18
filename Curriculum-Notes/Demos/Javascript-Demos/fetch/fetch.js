
// here we get out button
let button = document.getElementById("button")

//add event listener to the button 
button.addEventListener('click', async() => {

//get the value that we receive from the user in the input field
var inputValue = document.getElementById("field").value;

// do the http request and send it to the server
// we have to wrap this call in a try catch

try {

    const raw_response = await fetch(`https://pokeapi.co/api/v2/pokemon/${inputValue}`); //implicitly returns a promise

    //check to see if the repsonse is successful
    if(!raw_response.ok){
        throw new Error(raw_response.status) 
    }

    const json_data = await raw_response.json();

    console.log(json_data);

    // this is our DOM Manipulation

    var input = document.getElementById("input");
    var name = document.createElement('h2');

    name.innerHTML = `Name: ${json_data.name}`;
    input.append(name);

    var b = document.createElement('br');
    input.append(b);

    var id = document.createElement('h3');
    id.innerHTML = `ID: ${json_data.id}`;
    input.append(id);
    input.append(b);

    var image = document.createElement('img');
    image.setAttribute("src", json_data.sprites.front_default);
    image.setAttribute("height", "300");
    image.setAttribute("width", "300");

    input.append(image);
    input.append(b);

    var line = document.createElement('hr');
    input.append(line);




}catch(error){
console.log(error);
}




});