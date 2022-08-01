// count = 6; // here we will get a compile time error because due to 'static typing' this is not accepted in typescript
var count = 6;

var apples: string = "granny has the best apples" // example if full initialzation and 
//declaration of our variables in ts

//var list: string[] = ['sleep','text','eat']
//   list[0] = 9; //this will give an error because type

var list: any[] = ['sleep','text','eat'];
if(list.length<=3){
    list[0]= 99;
}

var newString = list[0];

newString = 'bob';
console.log(newString)
console.log(list)

/**
 * TS (TypeScript) is STATICALLY types! You cannot reassign a varaible of a different declard type once it is given
 */

//apples = 35; Type 'number' is not assignable to type 'string'

//ENUMS - 
//enums allow us to made constants in JS
// they look very weird in JS 

//this is the old way of declaring enums in TS
const ColorRed = 0;
const ColorBlue = 1;
const ColorGreen = 2;

 
//this is the newwer way of declaring enums
enum Colors {'Red','Blue','Green'}

console.log(Colors.Red) // this prints out 0 becuase it is the first element in the enum

/**
 * Enums are useful when we want to set a list/grouping of named contraints in our application
 * //This will make it easier to document  states of events throughout our app runtime
 * ex: In video games, devs would narmally track when the game is IN_PLAY, PAUSED, STARTED, or GAME_OVER etc
 * enums are used in logical statements (if block or switch statements etc)
 */

enum Color {Red = 10, Blue, Green, Purple, Gold, Brown, Black}
console.log(Color.Brown)
