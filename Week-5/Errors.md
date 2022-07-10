# Errors
Sometimes things go wrong. When things go wrong in JavaScript, the result usually involves the creation of an error object. There are two ways an error object can be created:
1) Runtime error: An error that is created as a result of something wrong with the code, such as a SyntaxError or ReferenceError.
2) User-defined error: An error built as part of your code to represent a problem that can occur.
Errors can have many fields depending on the implementation, however the standard defines an error as having a `name` and `message` field.

## Exception Handling Statements
In order to work with an error, you need to utilize statements that will allow you to handle the error. There are two constructs we need to be aware of.

### try...catch
A `try` block allows you to execute code. If that code would cause an error to occur, code execution would switch to an attached `catch` block so that you can handle the error. The below example has us catch an error where we tried to access a variable that does not exist.

```JavaScript
try {
    let x = y; // y has not been declared
} catch(error) {
    console.log(error.name);
    console.log(error.message);
}
```
Output:
```
ReferenceError
y is not defined
```
### `throw`
If you define your own error, you'll have to throw the error so that it can be handled. A `throw` statement causes the thrown object to be sent to an attached catch block. If there is no catch block, this will cause your code to cease execution entirely.

_Note_: You can throw anything, not just an error. However, when people look at your code and see that you threw the string "hello", they will not have any idea why you did that. Other people will expect you to be throwing errors.

```JavaScript
try {
    throw new Error('Something bad happened!');
} catch(error) {
    console.log(error.name);
    console.log(error.message);
}
```
Output:
```
Error
Something bad happened!
```
## Custom Errors
If you're going to be throwing your own errors, it would be best to make your own error object, so that it has a descriptive name.

### Prototype
```JavaScript
function MyError(message) {
    this.name = 'MyError';
    this.message = message;
}
MyError.prototype = new Error;
try {
    throw new MyError('My message');
} catch(error) {
    console.log(error.name);
    console.log(error.message);
}
```
### Class
```JavaScript
class MyError extends Error {
    constructor(message) {
        super(message);
        this.name = 'MyError';
    }
}
try {
    throw new MyError('My message');
} catch(error) {
    console.log(error.name);
    console.log(error.message);
}
```