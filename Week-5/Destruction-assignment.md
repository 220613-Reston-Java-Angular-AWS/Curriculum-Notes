# Destruction assignment

Destructuring is the process of breaking a structure.  In JavaScript, destructuring can be applied to an Object or an Array. Destructuring assignment is a special syntax that allows us to “unpack” arrays or objects into a bunch of variables

## Array destruction


*  In Array destruction, variables declared on the left side, and the array is on the right side. It assigns a value for the variables with the array value on the same index.

**Example:** In the below example, we have an 'name' array with the first name and last name. Destruction assignment is used to split the first name and last name seperately.

```javascript
let name = ["Jacob", "Noah"];
// destructuring assignment sets firstname = arr[0] and lastname = arr[1]
let [firstname, lastname] = name;
console.log(firstname); // output: Jacob
console.log(lastname); //output: Noah
```


*  If the number of variables declared on the left side is more than a number of elements on the right side, then excess items are not assigned. The unwanted elements of the array can be ignored by using an extra comma.

**Example:**
```javascript
let arr = [1,2,3,4,5]
const [var1, var2] = arr;
console.log(`var1: ${var1}, var2: ${var2}`);  //output: var1: 1, var2: 2    

let [firstName, , title] = ["Charles", "Dickens", "David Copperfield", 2002];
console.log( title );     //output: David Copperfield
```

*  Variables with default values are mapped to the values from Array. If no matching index element found in array, default values are initialized.

**Example:**
```
let arr =[1,2]
const [ a = 3, b, c = 5] =arr; 
console.log(`a =  ${a}, b = ${b}, c = ${c} `);    //output: a =  1, b = 2, c = 5 
```


*  Rest operators used to assign to variables for destructing. 

**Example:**
```javascript
var [a, b, ...args] = [1,2,3,4,5];
console.log(`a: ${a}, b: ${b}, args: ${args}`); //output: a: 1, b: 2, args: 3,4,5
```

## Object Destruction


*  The right-hand side of an equal operator is Object and destruct/break it and assigned with variables.

**Example:** The variables declared on the left side should have the same name as an object's key name *like book and author in the below example*.
```javascript
var bookObj = {
  book: "The Three Musketeers",    
  author: "Alexander Dumas"
};

var {book , author} = bookObj; 

console.log(`Book: ${book}, Author: ${author}`);//output: Book: The Three Musketeers, Author: Alexander Dumas
```


*  Variables declared in the left side can be declared with default values.

**Example:** Here newEmployee is empty and local variable newId is created and the default value is 12, if id property not found in the object, the newId value is assigned with a default value. 
```javascript
var newEmployee = {};  
var { id: newId = 12 } = newEmployee;  
console.log(newId);      // Output: 12  
```

### Nested Object destruction 

An object has child object can be destructed. In the below example, city local variable is created and assigned with NewYork, address variable is not created and it just serves as a locators for mapping child elements.

**Example:**
```javascript
var employee = {  
    id: 11,  
    name: "Tom",  
    address: {  
        city: 'NewYork',  
        Country:'USA'  
    }  
};  
var { address: { city} } = employee;  
console.log(city);      // outputs Newyork
```

### Destructuring looping/iteration 

`Object.entries()` method is used to destructuring/break the key and pair values of an object during an iteration of for loop.

**Example:**
```javascript
var student = {  
    id: 10,  
    name: "Alexander",  
};  
for (let [key, value] of Object.entries(student)) {  
  console.log(`${key}:${value}`); // id:10 name:Alexander  
}  
```