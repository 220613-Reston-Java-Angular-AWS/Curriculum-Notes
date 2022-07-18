## `==` vs `===`

`==` is used for comparison between two variables irrespective of the data type of variable. `===` is used for comparison between two variables but this will check strict type, which means it will check datatype and compare two values.

**Example:**
```javascript
5 == '5' // Returns true
5 === '5' // Returns False
```

`==` is a type converting equality that automatically converts the string ('5') to number (5). It does implicit type conversion of variables.

`===` is strict equality also compares the data type of the variable.  It returns true only if the data type and value of the two variables are the same.


## Type coercion

Type coercion is the process of converting a value from one data type to another data type.

**Explicit type coercion** - We can explicitly convert the datatype of the variable. *For example:* `Number('3')`, `String (123)`, `Boolean(2)` 

**Implicit type coercion** - JavaScript is a loosely-typed language, values can also be converted between different types automatically. It usually happens when you apply operators to values of different types. *For example:* `'3' * '2'`, `2/’5'`, `123 + ''` 

### String conversion
To explicitly convert values to a string apply the `String()` function. Implicit coercion is triggered by the binary `+` operator when any operand is a string.

**Example:**
```javascript
String(123) // explicit
123 + ''    // implicit
```

### Boolean conversion 
To explicitly convert a value to a boolean apply the `Boolean()` function. Implicit conversion happens in logical context, or is triggered by logical operators ( `|| && !`).

**Example:**
```javascript
Boolean(21)          // explicit
if (2) { ... }      // implicit due to logical context
7 || 'hello'        // implicit due to logical operator
```

### Number conversion 
To explicitly convert a value to a boolean apply the `Number()` function. Implicit coercion is triggered by comparison operators (`>, <, <=,>=`), bitwise operators ( `| & ^ ~`), arithmetic operators (`- + * / % `),unary `+` operator and loose equality operator` == `. 

**Example:**
```javascript
Number('123')   // explicit
+'123'          // implicit
123 != '456'    // implicit
```

**toString() method** - used to convert values to String. 

```javascript
(100 + 23).toString() //returns "123"
true.toString()    // returns "true"
```

Javascript automatically calls the variable's toString() function when you try to "output" an object or a variable.

```javascript
obj = {name:"Ben"}  // toString converts to "[object Object]"
arr = [1,2,3,4]     // toString converts to "1,2,3,4"
date = new Date()   // toString converts to "Fri Jul 18 2014 09:08:55 GMT+0200"
```
## Truthy and Fasly in JavaScript

### Falsy value

In JavaScript, any expressions or value that results in boolean `false` value, are considered as Falsy. The falsy values/expressions in javascript are:

1. Obviously boolean `false` is `false`.
2. Any empty string will be evaluated to `false`. 
3. Any `undefined` variable will be equal to `false`.
4. Any `null` variable will be equal to `false`.
5. Any numerical expression with result in `NaN` (not a number) will be equal to `false`.
6. Any numerical expression with result in zero will be equal to `false`.

### Truthy value

In JavaScript, any expressions or value that results in boolean `true` value, are considered as Truthy. Any expression or value other than above listed falsy values – is considered truthy. 

**Example:**
```javascript
'Hello'  // truthy
if(1){}		// truthy 
if(-1){} 	// truthy 
new Boolean(false);     // is truthy values because 'object' is always true
new String('')	 // is truthy values because 'object' is always true
```