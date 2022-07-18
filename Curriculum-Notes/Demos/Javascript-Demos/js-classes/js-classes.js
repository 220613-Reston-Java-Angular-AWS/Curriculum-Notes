class ClassMate{
//JS classes give us the ability to incorporate OOP in JS
//this was introduced in ES6
// Therefor we can make constructors and functions
// that can be sed in other parts of our JS code

constructor(name,age,course){
    this.name = name;
    this.age = age;
    this.course = course;
}

displayInfo(){
    return `${this.name} is ${this.age} years old and is studying ${this.course}`
}


}





//let use our class

let classmate = new ClassMate("Stanley Artis",21,"Economics")

console.log(classmate.displayInfo());



/*
Why use JS classes?
- offer an improved means for creating object templates
- replace the previous means of using constructor functions for object
- makes our code more manageable and reusable in other parts of our JS code
*/


//how can we convert our class data into JSON and back
//JSON object in JS gives us access to 2 methods
//1. JSON.stringify() (will convert any JS objects into JSON strings)
//2. JSON.parse() ( will turn any JSON string into a JS object)


//show me the object
console.log(classmate)

//turn this js object into JSON
console.log(JSON.stringify(classmate))


//we are going to convert the JSON bakc to a js object
var json = JSON.stringify(classmate)
console.log(JSON.parse(json));
