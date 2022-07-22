## JavaScript Study Guide

You should be able to explain and apply the following concepts:

### Basics
- Benefits, features, and drawbacks of JavaScript
  - Loosely typed
  - High-level
  - Scripting language
  - Multi-paradigm (functional, object-oriented, procedural)
  - DOM manipulation
  - Single-threaded, asynchronous
  - Server-side code with Node.js
- Data types
  - number
  - boolean
  - string
  - undefined
  - null
  - object
- Variable scopes
  - block
  - function / lexical
  - global
- Control flow
  - for-of
  - for-in
  - for
  - while
  - do-while
  - switch
- Type coercion
- `==` vs `===`
- Functions
  - Callback functions
  - Self-invoking (IIFE)
  - Closures
  - Arrow functions
- Hoisting of functions and variables
- "strict" mode
- `this` keyword
- Objects as key-value pairs
  - Object literal syntax
  - Constructor functions
  - Bracket vs dot syntax (obj.name vs obj[name])
- OOP concepts in JavaScript
  - Achieving abstraction
  - Support for polymorphism
  - Prototypical inheritance
  - Encapsulation with closures
- Arrays
  - Dynamic addition of elements
  - Array methods 
    - push
    - pop
    - filter
    - map
    - shift
    - sort
    - splice
    - forEach
- Async functions
  - setTimeout
  - setInterval

### DOM and Events
- DOM hierarchy
  - Tree data structure
- `window` object
- `document` object
  - Querying and retrieving elements from the DOM
  - Modifying CSS styling
  - Inserting DOM elements
- Events & Listeners
  - Setting event listeners
  - Bubbling / capturing
  - Event object & methods
- Submitting a form using JavaScript

### ES6+
- ES6
  - `let` and `const` keywords
  - Arrow functions (`=>`)
  - Template literals
  - Default parameters
  - Spread / rest operator
  - Destructuring assignment
  - Promises
ES7
  - `async`/`await` keywords
  - generator functions and `yield` keyword

### AJAX
- Benefits, features, drawbacks of AJAX
  - Asynchronous, non-blocking
- AJAX workflow 
  - Create XmlHttpRequest (xhr) object
  - Calling xhr.open() method with HTTP method and URL
  - Setting xhr.onreadystatechange callback function
    - Checking for ready state of 4 and status code in 200-299 range
  - Sending the xhr with xhr.send()
- fetch API
  - handling returned data
  - handling errors thrown
- JSON
  - `JSON.parse()` and `JSON.stringify()`
  - Difference between JSON and JS object