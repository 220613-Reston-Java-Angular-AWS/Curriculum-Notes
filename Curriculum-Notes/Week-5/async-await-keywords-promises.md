# async and await keyword

Async and Await are extensions of promises.

**async** -An async function is a function that operates asynchronously via the event loop, returns a Promise object implicitly. `async` ensures that the function returns a `promise`.

**await** - The `await` keyword is only valid inside `async` functions. `await` makes JavaScript wait until that promise settles and returns its result.

*Example:*  Returns a promise object
```javascript
async function asyncFunc() {
  let response = await fetch(protectedUrl);
  let text = await response.text(); // response body consumed
  document.write(text);
}

asyncFunc();
```


# Promises

Promises are used to handle asynchronous operations in JavaScript.

The constructor syntax for a promise object is:
```
let promise = new Promise(function(resolve, reject) {
  // executor (the producing code, "singer")
});
```

The function passed to `new Promise` is called the **executor**. When a `promise` object is created, the executor runs automatically. It contains the code which produces the result. The arguments `resolve` and `reject` are callbacks.

When the executor obtains the result, it should call one of these callbacks:

* `resolve(value)` — if the job finished successfully, with the result `value`.
* `reject(error)` — if an error occurred, the error is the `error` object.


The `Promise.status` property, gives information about the state of the `Promise` object. The promise object can have three states: **pending**, **fulfilled**, and **rejected**.

A Promise object connects the executor and the consuming functions  which will receive the result or error. Consuming functions can be registered using methods `.then`, `.catch` and `.finally`.

**Example:**
```javascript
var promise = new Promise(function(resolve, reject) { 
  const x = 5; 
  const y = 3;
  if(x >= y) { 
    resolve(); 
  } else { 
    reject(); 
  } 
}); 
  
promise. 
    then(function () { 
        console.log('Sucess! x have grater value'); 
    }). 
    catch(function () { 
        console.log('Error'); 
    }); 
```



