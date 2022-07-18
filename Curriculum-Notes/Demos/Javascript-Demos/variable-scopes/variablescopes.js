/*
Scopes in JS
 - what is a scope?
        -Scope determines the accessiblity / visiblity of a variable in our code

- In JS, there are 3 scopes

    1. Global Scope
        -this variable is visibale EVERYWHERE 


    2.Function Scope
        - this variable is accessible within the function

    
    3. Block Scope
        - this variable is accessible within a condition statement
            -Block scope also has a spcial subscope known as 'lexical scope'
                -'lexical scope' was introduced in ES6 
                -In this scope, a variable is defined outside of a function
                and can be available for use inside of another funciton even tho it was
                declared before the function created

  With 2 & 3 -  they are collectively know as local scope
               
*/


//glocal scope variable
//use the var keyword

var name1 = "Bob";
console.log(name1 + " is seen everywhere")


//lexical scope example
//use the let keyword

// let name2 = "John";

sayHi();

function sayHi(){

     /*
     Hoisting is when the variable/funciton is being used before its even declared
     The JS interpreter will hoist - or move- to the top of the scope in
      the which the varaible is declared
     */

      //where we declared name3 => the interpreter moved/hoisted to
      // this point in our code
       name3 = "Sammie"; // hoisiting will occur here

      //without the 'name3' being above, it would only exist in the if block

      if(name3 === "Samuel"){

        var name3 = "Samuel";
        console.log("Hi " + name3)

      } else {
        console.log(`Hello, ${name3}`)
      }


}

//lexcial vs function scope

function eatBreakfast(){
   var name2 = "Joe";
  console.log(`${name2} is eating breakfast`)
}

console.log(`${name2}`)
eatBreakfast();

//take aways - 
//lexical scope has the flexibility to go in and out of function scope
//while function scope is restricted to remain within scope that it is declare