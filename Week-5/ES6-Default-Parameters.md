## ES6 Default Parameters

In JavaScript, default function parameters allow us to initialize named parameters with default values if no values or undefined passed to the function.

**Syntax:**
```
function fn(param1=defaultValue1,param2=defaultValue2,..) {
}
```

*  If there is no value for the default parameter in a function call, then the function takes the default value. 


**Example:**
```javascript
function multiply(a, b = 4) {
  return a * b;
}

console.log(multiply(3, 5)); //output: 15

console.log(multiply(5));    // output: 20
```


*  If we pass an `undefined` for the default parameter in a function call, then the function takes the default value.

**Example:**
```javascript
function getInfo (name, year = 2018, color = 'blue') {
  console.log(name);
  console.log(year);  
  console.log(color);
}

getInfo("katy", undefined, undefined);     // outputs: "katy 2018 blue"
getInfo( undefined, 1995, 'red');    // outputs: "undefined 2018 blue" 
getInfo("Jerry" , 2020)            // outputs: "Jerry 2020 blue"
```


*  We can use other parameters as default values in the function.

**Example:**
```javascript
function add(x = 1, y = x, z = x + y) {
    return x + y + z;
}
//Here x=1, y=1, z=2
console.log(add());     //returns '4' 

//Here x=2, y=3, z=5
console.log(add(2,3));  //returns '10'

//Here x=3, y=3, z=5
console.log(add(3,undefined,5)); //returns '11'    
```