/*

What is THIS?
In JS , the 'this' keyword refers to the object that it belongs to
    -By itself, 'this' refers to the global object
    -In a function 'this' still refers to the global object
    -In a method (in JS a method is a function the belongs to an object) 'this'
    refers to the owner object
    -In 'strict-mode' (Strict mode makes bad coding pratices to return error by placing
        you JS code in a more restricted variant of itself)'this' in a funtion would return undefined)

 */

 'use strict'; //this tell the javascript in this fule to "use strict mode"

// console.log(this)

function foo(){
    console.log(this);
}

// foo();

// x = 'hi'; //Note declaring a variable like this is equivalent to declaring it with the 'var' keyword
//when we are not in strict-mode
// console.log(x); // in strict mode logging x in this way will return an error



//Make an Object iteral
//noteeee : an object literal is NOTT JSON
// JSON is similar but not exactly the same in terms of formatting
//this is because in JSON both th keys are values are strings

const person = {
    firstname:'John',
    lastname:'Dowe',
    id: 123,
    fullName: function(){ //this is a mehtod because it is a function inside of an object
        return `${this.firstname} ${this.lastname}`; //remember this in a method refers to the owner object 
    }
};

console.log(person.fullName()); // in strict and non-strict mode this funtion should return 'John Dowe' because
//'this' is refering to that owner object "person"


this.cat = 'Finn'; //here we are adding a property to the global object
//therefore it strict-mode it will not return an error
console.log(this.cat)

