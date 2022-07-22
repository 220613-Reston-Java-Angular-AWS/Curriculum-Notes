//In 2017, ES8 was released and with it came the async and await keywords
//We use the async keyword to define functions that handle asynchronous operations

//make an async function, we would use the following syntax:
async function sayHi(){
    return 'Hi'; //NOTE: implicitly, async functions return a Promise
}


//how to invoke a async function
sayHi().then(console.log);


//Naturally, async functions execute asynchronously the event loop that is occuring in the JS Engine.
//more async fun
async function sayHi2(){
    //explicitly state that I am returning a Promise
    return Promise.resolve('Hi too');
}

//anonymous async function
let sayHi3 = async function(){
    return 'Hello';
};

//arrow notation async function
let sayHi4 = async() => {
    return 'Hiya'
};

async function display(){
    try {
        //we can execute another async function using the 'await' keyword
        //the await keyword can ONLY be used within an async function
        let result1 = await sayHi2();
        console.log(result1);
         let result2 = await sayHi3();
        console.log(result2);
          let result3 = await sayHi4();
        console.log(result3);
    } catch (error) {
        //this block of code will execute if the promise state was rejected
        console.log(error);
    }
}
display();

//Overall, async/await gives us more control over our code execution