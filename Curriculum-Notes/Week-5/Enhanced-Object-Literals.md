# Enhanced Object Literals
ES6 added a few features to the object literal syntax to make building an obect in JS even easier. An object literal takes the form of a JSON string without quotes, like so:
```JavaScript
let person = {
    name: 'Tim',
    age: 57,
    speak: function(){console.log('Hello')}
}
```
This object literal instantiates an object that has two fields, `name` and `age`, as well as a method named `speak()`.

## Initializing Fields From Variables
Prior to ES6, we could utilize variables in our object literals, so if we had a variable `name` that held the name of our person, we could set that value like so:
```JavaScript
let name = 'Tim';
let person = {
    name: name,
    age: 57,
    speak: function(){console.log('Hello')}
}
```
The only issue is that this might get confusing. Why do we have to write the word `name` twice? In ES6, we can just specify the variable and it will create a key of the same name, like so:
```JavaScript
let name = 'Tim';
let person = {
    name,
    age: 57,
    speak: function(){console.log('Hello')}
}
```
## Setting Keys From Expressions
However, if you've ever run into a situation where you wish to dynamically set the name of an object's key dynamically, you'll know that this is somewhat difficult. In the following example, we have variable `examName` that has a value that we want to set as a key in our object with the value `100`. This is possible after instantiation by utilizing array notation to set the value of the key:
```JavaScript
let examName = 'Geography';
let exams = {
    math: 80
}
exams[examName] = 95;
```
In ES6, we can perform this during instantiation by creating an expression using `[]`:
```JavaScript
let examName = 'Geography';
let exams = {
    [examName]: 95,
    math: 80
}
```

Note that we can perform calculations inside this expression, like so:
```JavaScript
let number = 0;
let obj = {
    ['key'+(number++)]: 'one',
    ['key'+(number++)]: 'two',
    ['key'+(number++)]: 'three'
}
```
The above code instantiates an object with the following keys:
```{key0: "one", key1: "two", key2: "three"}```

## Method Definition Shorthand

The last thing we're going to be looking at is a shorthand notation for declaring an object method. Prior to ES6, you had to declare you were instantiating a function, like so:
```JavaScript
let obj = {
    add: function(num1, num2){ return num1+num2 }
}
```
Now, however, you just declare the method name with it's parameters and implementation:
```JavaScript
let obj = {
    add(num1, num2){ return num1+num2 }
}
```