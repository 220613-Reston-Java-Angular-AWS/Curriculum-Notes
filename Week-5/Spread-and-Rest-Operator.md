# Spread and Rest Operator
The spread operator and the rest parameter was introduced in ES6. Both the spread operator and the rest parameter uses three consecutive dots (…).

## Spread Operator 

The spread operator provides the ability to expand iterable objects into multiple elements. 

*  The spread operator expands the contents of the array into individual elements. 

**Example:**
```javascript

// spread operator for copying  
let arr = ['a','b','c']; 
let arr2 = [...arr]; 
console.log(arr); // [ 'a', 'b', 'c' ] 

const arr =[1,2,3,4,5,6];
console.log(...arr);    //output: 1 2 3 4 5 6

const days = ["mon", "tue", "wed", "thurs", "fri", "sat", "sun"];
const.log(...days);    //output: mon tue wed thurs fri sat sun
```

*  The spread operator used for combining arrays.

**Example:**
```javascript
const arr1 = [2, 4, 6, 8, 10];
const arr2 = [3, 6, 9, 12, 15];

//combining arr1 and arr2 using spread operator
const arr = [...arr1, ...arr2];
console.log(arr);       // output: [2, 4, 6, 8, 10, 3, 6, 9, 12, 15]

//without spread operator
const array = [arr1, arr2];
console.log(array);     //output: [Array(5), Array(5)]

let merged = [0, ...arr1, 0, ...arr2];
console.log(merged);    //output: [0, 2, 4, 6, 8, 10, 0, 3, 6, 9, 12, 15]
```
## Rest Parameter

The rest parameter used to represent an indefinite number of arguments as an array.
 
**Syntax:** The rest parameter (...) should be at the end of the function parameter. If the rest parameter(...) is at the beginning or in the middle of the function parameter list, it will result in an error.
```
function functionname[...parameters]//... is the rest parameter
{
statement;
}
```

**Example:**
```javascript
//using spread operator
function addition(...input){ 
    let sum = 0; 
    for(let i of input){ 
        sum+=i; 
    } 
    return sum; 
} 
console.log(addition(5,6));             //output: 11
console.log(addition(4,6,3));           //output: 13
console.log(addition(2,5,8,3,4,1));     //output: 23
```
In the below example, we are passing the rest parameter as the third parameter which can store n number of function parameter.

**Example:**
```javascript
function myFun(a, b, ...manyMoreArgs) {
  console.log("a - ", a)
  console.log("b - ", b)
  console.log("manyMoreArgs - ", manyMoreArgs)
}

myFun("one", "two", "three", "four", "five", "six"); 
```
Output on the console:
```
a -  one
b -  two
manyMoreArgs -  (4) ["three", "four", "five", "six"]
```