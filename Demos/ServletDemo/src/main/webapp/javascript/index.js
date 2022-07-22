/*
  AJAX stands for Asynchronous JavaScript And XML
  It allows for performing javascript actions asynchronously.
  Generally used in conjunction with http requests, as we can wait
  for the response in the background while still doing other things.
  One of the biggest advantages of JS is the responsiveness it provides
  to our webpages. We can easily respond to events on our frontend and manipulate
  the DOM using basic JS functions.
  But the magic JS does not end there. We can use JS to make asynchronous
  requests to servers. We do this with AJAX.
  We want our application to continue to be responsive, while waiting
  for the server to respond. By sending the request and receiving the
  response asynchronously, we accomplish this.
  Note that AJAX has XML in it's name, but that primarily has its origin in
  and older era, where XML was used far more frequently as a data interchange
  format. Nowadays, we primarily use JSON. There are still some places that
  use XML, but JSON is a bit more popular.
*/

//target our submit button that will trigger the event

 let submitButton = document.getElementById("login");



submitButton.addEventListener("click", (event) => {
event.preventDefault();
    
    //do AJAX
    //1. Create the XMLHttpRequest obj

    let xhttp = new XMLHttpRequest();

    // //next were going to get the values from the form

    let email = document.getElementById("email-sign-in").value;
    let password = document.getElementById("password-sign-in").value;

    let loginInfo = {
        email: email,
        last_name: password
    }

    console.log(loginInfo);

    //STEP 2: Define the behaviors of our responses as they come back from the server
    /*
        A readyState is a property which signifies that state that the request is currently in.
        There are several states:
        0: UNSENT - opening of the request has yet to be called
        1: OPENED - open() has been called
        2: HEADERS_RECEIVED: send() has been called[aka the request has been sent], and the headers of the response as well as the status are now available.
        3: LOADING: downloading the response. Therefore, the responseText (which is a xhr property) is holding partial data.
        4: DONE: the entire operation is now complete
        Why need readyStates?
        Ofter you can implement other transitions or animations to your webpages by triggering them at given readyStates.
        ex. loading screens
    */

        xhttp.onreadystatechange = function(){
        
            //200 status code is a OK response
       //which means that everything was processed correctly
       if(this.readyState == 4 && xhttp.status == 200){

        console.log(xhttp.responseText);
        let data = JSON.parse(xhttp.responseText);
         console.log(data);

         //global caching funciton

         localStorage.setItem('currentUser', JSON.stringify(data));

        window.location.replace("welcome.html")
        } else if(this.readyState == 4 && xhttp.status ===204) {
            console.log(xhttp.responseText)
            console.log()
                alert("Failed. Status Code: " + xhttp.status)
              
        }

    };

    //STEP 3: OPEN THE REQUEST
    xhttp.open("POST",`http://localhost:8080/ServletDemo/user`)

    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    
     console.log(xhttp);
    //STEP 4- send the request
    xhttp.send(JSON.stringify(loginInfo));

});

// function renderHTML(data){
//     // let resp = document.getElementById("input");

//     // //append all response data to my webpage
//     // resp.append("Name: " + data.name);
//     // resp.append(document.createElement('br'));

//     // resp.append("ID: " + data.id);
//     // resp.append(document.createElement('br'));
//     console.log(data.email);
//     console.log(data.last_name);
    
//     // window.location.replace("tickets.html")

//     }
