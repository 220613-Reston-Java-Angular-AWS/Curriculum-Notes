# Variable Scope:


The Variable scope defines the lifetime and visibility of a variable. Each variable associated with a scope. The variable can be accessed only within its scope.

## Global Scope

Variables defined outside any function, block, or module have global scope. The global scope variables are accessed everywhere in the application.

Example:
```javascript
var a = 'Hello World!'; // This is a global variable
function greeting() {
    console.log(a);
}
greeting(); // Outputs 'Hello World!'
```

The global variable's lifetime is throughout the application.

Example:
```javascript
var app = {}; // A global object
app.foo = 'Homer';
app.bar = 'Marge';
function func() {
    console.log(app.foo);
}
func(); // Outputs 'Marge'
```

We can declare the global variables in a browser using the global `window` object.

Example:
```javascript
window.app= { value: 1 };
window.b = "Hello!!!"
```
### Local Scope
Local Scope used to refer to Function-local scope, but following the introduction of block scope, this term is considered ambiguous and should not be used. The local scope has divided into the function scope, the block scope and the lexical scope. The block scope concept is introduced in ECMA Script 6 (ES6) together with the new ways to declare variables - `const` and `let`.

## Function Scope

The variable declared in a function is only visible inside that function. `var` is the keyword to define variable for a function-scope accessibility. These variables cannot be accessed or modified.

```javascript
//global scope
function func1(){
    //functoin scope 1
    function func2(){
        //function scope 2
    }
}

//global scope
function func3(){
    //function scope 3
}

//global scope
```

Example:
```javascript
function func(){
    var animal ='Lion'; //exist in function scope
    console.log('inside function: ',animal);
}

func();                    //Output: "inside function: Lion"
console.log(animal);       //error: animal is not defined
```

##  Block Scope

Block scope is the scope of the variables declared inside the {} (curly brackets). In ES6, `const` and `let` keywords allow developers to declare variables in the block scope, which means those variables exist only within the corresponding block.

Example:
```javascript
function func(){
    if(true){
        var fruit1 = 'apple';        //exist in function scope
        const fruit2 = 'banana';     //exist in block scope
        let fruit3 = 'strawberry';   //exist in block scope

    }
    console.log(fruit1);
    console.log(fruit2);    // results error - due to it exist in block scope
    console.log(fruit3);    // results error - due to it exist in block scope
}

foo();
```
The result will be:
```
apple
error: fruit2 is not defined
error: fruit3 is not defined
```

## Lexical Scope

Lexical scope is that a variable defined outside a function can access the inside another function defined after the variable declaration. The inner functions are lexically bound to the execution context of their outer functions.

Example:
```javascript
function func1(){
    var animal1 = "Lion";   //exist in Lexical scope

    function func2(){    //Inner Function

        var animal2 = "Tiger"; //exist in function scope
        console.log(animal1);
        console.log(animal2);

    }
    func2();
    console.log(animal2); // results error - due to it exist in function scope
}

foo1();
```
The result will be:
```
Lion
Tiger
error: animal2 is not defined
```

### Hoisting

In JavaScript, variable declarations made with `var` and function declarations made with the `function` keyword are **hoisted** - or moved - to the top of the scope in which they are declared when the JavaScript interpreter parses the code. This means that variables and functions can be used **before they are even declared** as shown below.

```javascript
function example() {
  // var a declaration hoisted here
  a = 4;
  var a;
  a++;
  console.log(a); // prints 5
}
// anotherExample declaration hoisted to here
anotherExample(); // no error thrown!

function anotherExample() {
  console.log('it works!');
}

```