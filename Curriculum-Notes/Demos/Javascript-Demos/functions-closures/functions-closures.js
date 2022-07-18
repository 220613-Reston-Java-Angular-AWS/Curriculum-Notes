//Declare some variables
var num1 = 5;
var num2 = "45";


//functions allow us to have reuasble code in JS
//THERE ARE SEVERAL WAYS TO MAKE A FUNCTION


//1. using the 'function' keyword

function add(n1,n2){

    var sum;

    //check the datatypes of the varaibles
    // console.log("Num 1 is a number " + Number.isInteger(n1));
    // console.log("Num 2 is a number " + Number.isInteger(n2));



    //type coercion = the process of automatic/implicit conversion of values from one dataType
    //to another 
    // == vs ====
    //== equality operater -> can be used to compare values regardless of their dataTypes
    //=== will check to see if the value and datatype is the same

    //REMEMBER: == does not type check but, === does type check

    if(Number.isInteger(n1) === Number.isInteger(n2) ){
        sum = n1 + n2
    } else {
     //we will need to parse the non number
     //considered typeCoercion
     sum = parseInt(n1) + parseInt(n2)
}

return sum;
}

var result = add(num1,num2);
document.getElementById('example1').innerHTML = `Regular Function Call: add(5,45) = ${result} `


//2.Anonymous functions
// these methods do not have a method name
//instead they can be invoked by using their assigned variable name

var multiply = function(n1,n2){
    return parseInt(n1) * parseInt(n2)
}

//here we are going to access the div with the id name 'example2'
document.getElementById('example2').innerHTML = `Anonymous Function Call: ${multiply(num1,num2)}`


//3. Here we are using the arrow function
// we dont have to use the funciton keyword or give it a method name

var square = (n) => {
    //here im not going to do 'parseInt' becuse im going to hard code the number
    return n * n
}

document.getElementById('example3').innerHTML = `Arrow Function Call: ${square(10)}`


//4. Call back funcitons
// a callback function is a function passed into another function as an argument
//aka a method call within a method

//a. make our inner function
function alertFunc(n){
    alert(`Your answer is ${n*2}`)
}


//b. here we are going to make our outter function

function callBackFunction(num,callback){

    //c. inside of this outter function, call our inner function (doing the callback)
    callback(num);
    return num;

}

document.getElementById('example4').innerHTML = `Callback Function Call: ${callBackFunction(9,alertFunc)}`


//5.Closures 
//closures give you access to the outter functions scope
//with use of an inner function
function complexCalcFunc(n){

    var secretNumber = n + 6;

    //a. make a closure
    //Note: OOP in JS refers to Encapsulation
    // and encapsulation is achieved in JS wiht closures


    function crazyMath(){
        //Note : 'crazyMath' still remembers the value of secret number
        //even though we are in a different scop level

        console.log("Your secret number is " + secretNumber);
        console.log(`Your secret math solution is: ${ secretNumber*secretNumber - 1 + 14 / 8}`);
    }

return crazyMath;


};



let num3 = 25;
let myComplexResult = complexCalcFunc(num3);
//here we have to call our 'myComplexResult'
myComplexResult();

document.getElementById('example5').innerHTML = `Closure Call using: ${num3}`

