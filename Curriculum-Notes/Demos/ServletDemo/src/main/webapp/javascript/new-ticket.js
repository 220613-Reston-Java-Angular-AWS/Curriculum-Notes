




// async function asyncFunc() {
//     let response = await fetch(githubUrl);
  
//     // get one header
//     alert(response.headers.get('Content-Type')); // application/json; charset=utf-8
  
//     // iterate over all headers
//     for (let [key, value] of response.headers) {
//       alert(`${key} = ${value}`);
//     }
//   }

let user = localStorage.getItem('currentUser');
//here is my current user 



let myUser = JSON.parse(user);
console.log(myUser);


async function makeNewTicket(event){
    event.preventDefault();

    let ticketForm = document.getElementById("description");

    console.log(ticketForm);

    console.log(ticketForm.value);


      //the url for our backend
    try {
        const raw_response = await fetch(`http://localhost:8080/ServletDemo/tickets`,
       
          {
            method: "POST", //the http verb
            headers: { //headers
              "Content-Type": "application/json",
              "Access-Control-Allow-Origin": "*",
              "User-Id": myUser.user_Id
            },
             body: JSON.stringify(ticketForm.value)
           
        //here would be the body if it was a post request
          });
    
        //check for a successful response
        if (!raw_response.ok) {
          throw new Error(raw_response.status); //this is a js error class that we are throwing
        }
        console.log("Request complete")
    
         const json_data = await raw_response.json();
    
         console.log(json_data);
    
        //save token into a sessionStorage variable
        // localStorage.setItem("tickets", JSON.stringify(json_data));
    
        // console.log(localStorage.getItem("tickets"))

        alert(`Ticket #: ${json_data} has been added`)
    
        setTimeout( () => {

        window.location.replace("tickets.html")

        },1000)
      } catch (error) {
        //this catch block is for network errors
        console.log(error);
    
    
    }
    



}
