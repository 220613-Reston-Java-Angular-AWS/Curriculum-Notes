/*Life before JS Classes
- What is a prototype in JS?
    - Every object in JS has a built-in property, which is called its prototype
    - The prototype is itself an object, so the prototype will have its own prototype that can be later 
    associated in a thing known as a prototype chain.
    - The chain ends when we reach a prototype that has null for its own prototype.
- Why use prototypes?
    - Before ES6, prototypes were commonly used to make object constructors
*/

function Person(name,hobby){
    this.name = name;
    this.hobby = hobby;
}

var person = new Person("John Doe","fishing")
console.log(person)

//if we wanted to receive the name on this person specifically
Person.prototype.getName = function(){
    return this.name
}

console.log(person.getName());

//to add a new functionality to all of my existing Person objects
Person.prototype.age = 25;

console.log(person.age);

//Note: You can only modify prototypes that you create
//you cannot modify the prototypes of standard JS objects
Object.prototype.age = 26;
console.log(Object.prototype.age) // apparently this wil infact print however we cannot see the 
//native code of Object becuase it is a standard js object

console.log(Person)
console.log(Object)