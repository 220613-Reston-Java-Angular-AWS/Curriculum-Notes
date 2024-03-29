## Data types

JavaScript includes the 7 following data types. The primitive data types used in javascript are:
* string
* number
* boolean
* null
* undefined
* object
* Symbol

Symbol is a new data type introduced in ES6 but is not commonly used.

Also, in this section we'll discuss about Arrays and Date specifically, which are both Objects.

**Loosely- Typed JavaScript** - JavaScript is a dynamic or loosely-typed language because a variable can hold the value of any data type at any point in time.

Example:
```javascript
var a = 100;
a = true;
a = null;
a = undefined;
a = "Johnson";

alert(a); // Johnson
```
**NOTE:** The `alert()` method displays an alert box in the current browser window with a specified message and an 'OK' button.

Data types supported by JavaScript are listed below:

### Strings

Strings are text, enclosed within a single(') or double quotes ("). We can have quotes inside the string if they don't match the enclosing quotes.

Example:
```javascript
var name  = "Johnson";
var a ='hello';
var a = "Let's have a cup of coffee."; // single quote inside double quotes
var b = 'He said "Hello" and left.';  // double quotes inside single quotes
var c = 'We\'ll never give up.';     // escaping single quote with backslash
```

### Numbers


Numbers can be positive or negative numbers, with or without decimals and exponential representation of numbers. If a number is enclosed within single or double quotes, then it is considered a string. The Number data type also includes special values such as Infinity, NaN (Not-a-Number value). When we divide a number by 0, it results in infinity. When we do undefined mathematical operations such as taking the square root of -1, multiplying, or dividing with String the result is NaN.
Example:
```javascript
var a = 51;         // integer
var b = 15.5;       // floating-point number
var c = 1.5e-4;    // exponential notation, equivalent to 0.0001.5
var d = 1.5e+4;    // exponential notation, equivalent to 1.5e4 or 15000
var h = -6/0 // results infinity
var j = ("2" / 2); //results NaN
```

### BigInt

In JavaScript, the “number” type cannot represent integer values larger than 253 or less than -253 for negatives. BigInt type used to represent integers of arbitrary length. A BigInt is created by appending n to the end of an integer literal.

Example:
```javascript
 var bigInt = 1234567890123456789012345678901234567890n; //// the "n" at the end refers it's a BigInt
```

### Boolean

In JavaScript, we have two Boolean values: true and false.

Example:
```javascript
var isEmpty = true;
var isGreater = (5>6); //returns false
(5 == 5) //returns true;
```

### The “null” value

A null value refers to nothing and is not equivalent to an empty string ("") or 0.

Example:
```javascript
var a = null;
alert(a); // Output: null
```

### The “undefined” value

The undefined refers to value is not initialized. If a variable declared but not initialized with a value, its value is undefined.

Example:
```javascript
let x;
alert(x); // shows "undefined"

var car = "";    // It is an empty string not undefined.
```
> NOTE: An empty string has legal value and type defined.

### Objects

An object contains a set of key-value pairs.  A key is a name that is of string type. The value can be any data type such as numbers, booleans,  strings, function, arrays, and other objects.

The syntax of a javascript object as follows: `var <object-name> = { key1: value1, key2: value2,... key: valueN};`

Example:
```javascript
var person1 = {
    firstName: "John",
    lastName: "Wilson",
    age: 23,
 };
```

You can access the values of an object's properties using dot notation (.) or bracket ([ ]).

Example:
```javascript
person1.firstName; // returns John
person1.lastName; // returns Wilson
or
person1["firstName"];// returns John
person1["lastName"];// returns Wilson
```

**Object Constructor** - Another way to create an object is with Object Constructor using the `new` keyword.  You can attach properties and methods to the object using dot (`.`) or bracket (`[]`).

Example:
```javascript
var person2 = new Object();
// Attach properties  to person object
person2.firstName = "Ben";
person2["lastName"] = "Tennyson";
person2.age = 18;
```

If we try to access properties or call methods that don't exist, then JavaScript will return `undefined`.  The `hasOwnProperty()` method is used to check whether an object has a particular property or not.

Example:
```javascript
var person3 = new Object();
person3.firstName; // returns undefined
if(person3.hasOwnProperty("firstName")){
           person3.firstName;
    }
```
We can use `for..in` loop to get the list of all properties and methods of an object.

Example:
```javascript
for(var key in person1){
        alert(key);
    };
```

### Arrays

Arrays stores a list of values under a single variable.

The Syntax for Arrays in JavaScript as follows. `var <array-name> = [element0, element1, element2,... elementN];`

Array values are associated with an index starts with 0. The array includes "length" property that returns the number of values stored in it.


Example:
```javascript
var arr = [1,  2.2,  "hello",  false];
alert(arr[0]);  //Outputs 1
alert(arr[1]);  //Outputs 2.2
alert(arr[2]); //Outputs  hello
alert(arr[3]);  //Outputs false
alert(arr.length); //Outputs 4
```
Arrays are also dynamic - we can add elements to grow the array and remove elements to shrink it. Below are some common array methods:
* `.push()`
* `.pop()`
* `.filter()`
* `.map()`
* `.slice()`

**Array Constructor** - We can also initialize an array using a `new` keyword.

Example:
```javascript
var names = new Array();
names[0] = "John";
names[1] = "Ben";
names[2] = "Chris";

var numbers =  new Array (1, 2, "three", 4);
```

### Date

JavaScript provides a Date object to work with date & time. It includes days, months, years, hours, minutes, seconds, and milliseconds in each object.

We can display the current date and time by creating a Date object using Date() or new Date().

Example:
```javascript
Date(); //current date

var currentDate = new Date(); //current date
```

We can create a date object by specifying different parameters in the Date constructor:
```javascript
var dt = new Date();
var dt = new Date(milliseconds);
var dt = new Date('date string');
var dt = new Date(year, month[, date, hour, minute, second, millisecond]);
```
Example for creating Date objects:
```javascript
var date1 = new Date("3 march 2015");
var date2 = new Date("3 February, 2015");
var date3 = new Date("3rd February, 2015"); // invalid date
var date4 = new Date("2015 3 February");
```

### Typeof Operator

The typeof operator returns the data type of its operand.

Syntax: `typeof operand` or `typeof (operand)`

Example:
```javascript
typeof 42; // output: "number"

typeof NaN ; // output: "number"

typeof 'hello'; // output: "string"

typeof true; // output: "boolean"

var a;
typeof a; // output: "undefined"

typeof 42n; // output: "bigint"

function func(){}
typeof func; // output: "function"

// For arrays, date, regular expression,null and objects , typeof operators returns "object"
typeof {a: 1}; // output: "object"

typeof [1, 2, 4]; // output: "object"

typeof new Date(); // output: "object"

typeof null;    // output:  "object"

```