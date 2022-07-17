/*
    - Starting from Zero: The Life before Promises
    In the past when we wanted to deal with asynchronous operations, you had to use callback functions.
    When you nest multiple callback functions, the code becomes very difficult to maintain. This issue is known as "callback hell".
    Suppose you want to perform 3 async ops in your JS code:
    1. Select a user from a database
    2. Get services of the user (i.e. we are checking what internet services the user has used)
    3. Calculate the service cost based on the services that the user has used
*/


//get the user

function getUser(userId,callback){

    console.log("get user from the db")

    setTimeout( () => {

        callback({
            userId:userId,
            username:"John"
        })
    
    },1000); //first in line for this queue is this callback

}

//get the services 

function getServices(user, callback){
console.log(`Get services of ${user.username} from the API `);

setTimeout(()=>{

    callback(['Email','VPN','AWS'])

},2 * 1000);
}


function getServicesCost(services, callback){
    console.log(`Calculate service costs for these services: ${services}`)

    setTimeout(()=>{
        callback(services.length * 100);
    },3 * 1000)
}



//nested services to get the final cost of what the user owes

getUser(777, (user) =>
{
    getServices(user, (services) => {
        getServicesCost(services, (cost) => {
            console.log(`The final cost is ${cost}`)
        })
    })
})