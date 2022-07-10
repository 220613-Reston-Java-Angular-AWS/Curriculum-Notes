## JavaScript this keyword

The `this` keyword is a reference variable that refers to the current object.


* **`this` alone**: refers to a global Object.

Example:
```javascript
var x = this;
``` 

* **`this` in function**: refers to the Global object [object Window].

Example:
```javascript
function myFunction() {
  return this;
}
```

* **`this` in `strict` mode**:  

Example:
```javascript
"use strict";
var x = this; //Here, this refers to the Global object [object Window]

"use strict";
function myFunction() {
  return this; //Here,  this is undefined.
}
```

* **`this` in Event Handlers**: refers to the HTML element that received the event

Example:
```html
<button onclick="this.style.backgroundColor= 'green'">
    Click Me!
</button>
```

* **`this` in Object Method Binding**: refers to the object. In the below example, `this` refers to people object.

Example:
```javascript
let people = function(name, age) { 
         this.name = name; 
         this.age = age; 
  
    this.displayInfo = function() { 
       document.write(this.name + " is " + this.age + " years old"); 
      } 
    } 
```

* **The call() and apply() method**: allows us to write a method that can be used on different objects. Here, person1 object writes its fullName function on person2 object using call() method

Example:
```javascript
var person1 = {
  fullName: function() {
    return this.firstName + " " + this.lastName;
  }
}
var person2 = {
  firstName:"John",
  lastName: "Wilson",
}
document.write("Hello, "+ person1.fullName.call(person2));
```