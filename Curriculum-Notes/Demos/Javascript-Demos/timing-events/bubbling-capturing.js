/*
Event = something that the browser does or the user does
ex: onclick, onchange, onload, onmouseover etc

-What is event propagation?
    - the order at which events are triggered in the DOM


create event listeners
event listener handles events and can be used to manage the actions
that occur during a given event




Bubbling vs Capturing

- if an element is 'clicked', it will trigger the event
Bubbling:
-if the parent element is clicked , thenonly the parent elemt will be triggered
-if the child element ic clicked, then the child woild be triggered followed by the parent


Capturing:
-If the parent element is clicked then only the parent will be triggered
-if the child is clicked , then parents trigers first, followed by the child

*/


let parent1 = document.getElementById("parent-1");
let parent2 = document.getElementById("parent-2");
let child1 = document.getElementById("child-1");
let child2 = document.getElementById("child-2");



//example 1
//by default , event listeners are set to bubbling
parent1.addEventListener('click', (event) => {


console.log("I am the Parent")

})

child1.addEventListener('click',() => {

    console.log("I am the Child")
})


//example2 
//to turn on capturing we have to set
//the eventistener to capturing = true

parent2.addEventListener('click', () =>{
    console.log("I am the Parent")
},true);

child2.addEventListener('click',() => {

    console.log("I am the Child")


},true);