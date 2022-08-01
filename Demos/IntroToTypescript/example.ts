// TypeScript is a Superset of Javascript
//This means that all javascript is valid Typescript

//We use Typescript to develop our front end code however 
//Web browers cannot (convert / read / understand) typescript
// so it must be transpiled to Javascript first

/**
 * TS is an OOP language - it allows for OOP features such as interfaces, classes generics etc
 * TS is strongly typed
 * When we install TS we get a TS compiler (tsc)
 */

function sayHi(message: string){
    return `Hi, this is your message: ${message}`
}

console.log(sayHi("This is Angular Week!"))

//Node is an open source - cross- platform, Javascript runtime environment
//Node can be run on the V8 engine and execute JS code outside of the web browser
//NPM - node package manager ; it comes with Node by default

/**
 * Steps we will folow to run our Typescript code
 * 1. Call the typescript compiler to transpile our TS into JS
 * tsc (typescript compiler) nameOfFile.ts 
 * When we do this and run that command we will get a .js file create with the same name
 * 2. Run the .js file in order to execute the code
 *To run the .js file we have to use this command:  node nameOfFile.js 
 */