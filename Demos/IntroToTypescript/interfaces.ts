/**
 * Interfaces in TS are an abstract type that tells the compiler which property name a given
 *  object can have - aka: a way for us to have precompied JS objects without worrying over implementation
 * 
 */

//declare the interface
interface Person {
    name: string;
    title: string;
    salary: number;
    funFacts: any[];
}


//implement the interface
const user: Person = {
    name: "Tiffany",
    title: "Software Engineer",
    salary: 100_000,
    funFacts:[26, 'love to sing and sleep','needs to shop', false]
}

console.log(user)

const newUser: Person = {
    name: 'Eric',
    title:"Sir Master Commander 2nd",
    salary:500_000_000,
    funFacts:[29,'master commander','rich','doesnt like to dress up',false]
}

console.log(newUser)