// http://localhost:8080/ServletDemo/tickets

let user = localStorage.getItem('currentUser');
//here is my current user 



let myUser = JSON.parse(user);
console.log(myUser);

console.log(myUser.email);

//here we are going to communicae with our back end using fetch
 getTickets();



async function getTickets(){ 

    try {
        // here we will need to add the await keyword in order for us to be able to get the response back

        const raw_response = await fetch(`http://localhost:8080/ServletDemo/tickets`, //the url for our backend
          {
            method: "GET", //the http verb
            headers: { //headers
              "Content-Type": "application/json",
              "Access-Control-Allow-Origin": "*",
              "User-Id": myUser.user_Id
            }
        //here would be the body if it was a post request
          }
        );

        // console.log("jus checking to see in this prints")
    
        //check for a successful response
        if (!raw_response.ok) {
          throw new Error(raw_response.status); //this is a js error class that we are throwing
        }
    // since its an asynchronous function it will complete without getting the response back unless we tell it to wait
        const json_data = await raw_response.json();
        console.log(json_data)
    
        console.log("this is supposed to be jason data");
    
        //save token into a sessionStorage variable
        localStorage.setItem("tickets", JSON.stringify(json_data));
    
        console.log(localStorage.getItem("tickets"))

        renderTickets(json_data);
    
        
      } catch (error) {
        //this catch block is for network errors
        console.log(error);
      }; 
}


function renderTickets(ticketList){

    // make a ref to the elements on out html page
  
    let orderedList = document.getElementById("ticketlist");


    ticketList.forEach(element => {
        let item = document.createElement("li");
         item.innerText = `${element.requestID} - ${element.description} - ${element.userID}`

         orderedList.append(item);
    });








}



