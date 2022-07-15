# let and const keywords

In ES6, `const` and `let` keywords allow developers to declare variables in the block scope, which means those variables exist only within the corresponding block.

Variables declared with the `let` and `const` keyword can have **Block Scope**.

## `let` Keyword

The variables declared inside a block {} have Block Scope, so it can not be accessed from outside the block.

**Example:**
```javascript
{
  let y = 2;
}
// y can NOT be used here

var x = 10;
// Here x is 10
{
  let x = 2;
  // Here x is 2
}
// Here x is 10

```

## `const` Keyword

`const` is block-scoped, much like variables defined using the `let` keyword. The value of a `const` variable can't be changed through reassignment, and it can't be redeclared.

**Example:** We cannot change the primitive value of constant variable.
```javascript
const a = 12;
a = a+11; //error
a="hello"; //error
```

**Example:** We can change the properties of a constant object but we can't reassign the constant object.
```javascript
//const object
const person = { name: "Johnson" , age: "23", gender: "male"};

// change a property
person.age = "21";

console.log(person); // prints " {name: "Johnson", age: "21", gender: "male"} " in the console.

//reassigning const object
person = { name: "Mercy" , age: "23", gender: "female"}; //error
```