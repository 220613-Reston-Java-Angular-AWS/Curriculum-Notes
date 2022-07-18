let user = localStorage.getItem('currentUser');
//here is my current user 


let myUser = JSON.parse(user);
console.log(user);

console.log(myUser.email);

let greeting = document.getElementById("greeting")


greeting.innerHTML = `Welcome, ${myUser.first_name}`;


function logout(){
    
    
    localStorage.removeItem('currentUser')

    window.location.replace("index.html");
    //clear wold work here too because theres one thing in there
}