//1. Declare some variables of each type

var num = 7;
var str = "7 is my favorite number";
var bool = false;
var nullData = null;
var undefinedData = '';

//symbols allow us to create "hidden" properties of n object
// that no other part of code can accidentlly access or overwrite

var id = Symbol("id");

var Person = {
    firstName: "Tiffany",
    lastName : "Obi",
    toDos: ['eat',"sleep",'code'],
    sayHi: (fname) => {
        // this is an examle if string interpolation
        //in order for us to string interpolate the param "fName"
        // we have to use the  ` `
        return `Hello ${fname}!`
    },
    [id]:123456
};

//2. Display each defined datatype from above
//within their labeled spans
let numEx = document.getElementById("num-ex");
let strEx = document.getElementById("str-ex");
let boolEx = document.getElementById("bool-ex");

//target the inner html and change what it says
//aka set it with the variables we creates above
numEx.innerHTML = num;
strEx.innerHTML = str;
// boolEx.innerHTML = bool;

// with any conditional statement, variables can be either truthy (a valid value associated with it)
// or it can be falsy (ex: false, 0, -0, "", null, undefined, NaN -not a number)
//truthy values(true, "hi", " ", 19, anything that has a value)

console.log(bool);

if(bool){
boolEx.innerHTML = "I have a true value"
} else {
    boolEx.innerHTML = "I have a false value"
};

// here we are looking at our null and undefinied datatypes
let nullEx = document.getElementById("null-ex")
if(nullData){
    //nullData is technically falsy because the value 'null' is falsy
    //meaning !nulldata is like saying 'not(notTrue)' - this would be true
    // which is why we can execute the logic in this if statement

    nullEx.innerHTML = "no value is home for this variable"

} else {
    nullEx.innerHTML = " this is printing because the nullData var is falsy"
};

let undEx = document.getElementById("und-ex")

if(!undefinedData){
undEx.innerHTML = "Sorry, I was declared but not defined"
}


let objEx = document.getElementById("obj-ex")
//show the object as a string

objEx.innerHTML = Person;

//to show objects in JS, we must convert them to JSON strings
//you can access the keys within your JS Object through the use of (.) 'dot notation'
objEx.innerHTML = `${JSON.stringify(Person)}, this is the return from the function sayHi(): "${Person.sayHi(Person.firstName)}" id = ${Person[id]} `

// come back to the symbol from our person