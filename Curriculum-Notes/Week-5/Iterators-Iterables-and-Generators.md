# Iterators, Iterables, and Generators

## Iterators
An iterator is an object that allows you to traverse values associated with it in a defined sequence. In JavaScript, iterators are defined as having a `next()` method that returns two values, the `value` or the next value in the sequence, and `done` which is `true` if the sequence is complete. The Array prototype has a method called `@@iterator`, which allows us to retrieve an Iterator based on a given array:

```JavaScript
let a = [1,2,3];
let iter = a[Symbol.iterator]()
console.log(iter.next());
console.log(iter.next());
console.log(iter.next());
console.log(iter.next());
```
Output:
```
Object { value: 1, done: false }
Object { value: 2, done: false }
Object { value: 3, done: false }
Object { value: undefined, done: true }
```
Note that, when the Iterator is finished, all further calls to the `next()` method will return `{ value: undefined, done: true }`. We can create our own iterator by simply defining a sequence and defining the method `next()`:
```JavaScript
let fib = function(num) {
    if(num == 0 || num == 1) {
        return 1;
    }
    return fib(num-1) + fib(num-2);
}
let fibIter = {
    nextIndex: 0,
    next() {
        result = { value: fib(this.nextIndex), done: false }
        this.nextIndex ++;
        return result;
    }
}
```
Now we can iterate over those values by simply calling the `next()` method.
```JavaScript
let result = fibIter.next();
while(result.value < 50) {
    console.log(result.value);
    result = fibIter.next();
}
```
Output:
```
1
1
2
3
5
8
13
21
34
```
## Generators

As we've seen, iterables have to maintain a state in order to work. Our `FibIter` object had to keep track of the `nextIndex` value in order to know which value was next in the sequence, and more complex iterables might need to remember more data points in order to function properly. A Generator is a special kind of iterator, but rather than returning a new value every time you call `next()`, it instead executes until it reaches the `yield` keyword within the Generator function when `next()` is called again, it will resume execution from that line. To obtain a generator, you have to create a Generator Function, utilizing the `function*` syntax:
```JavaScript
let fib = function(num) {
    if(num == 0 || num == 1) {
        return 1;
    }
    return fib(num-1) + fib(num-2);
}
function* makeFibGenerator() {
    for (let i = 0; i < 10; i++) {
        yield fib(i);
    }
    return;
}
let fibIter = makeFibGenerator();
let result = fibIter.next();
while(result.value < 50) {
    console.log(result.value);
    result = fibIter.next();
}
```
Output:
```
1
1
2
3
5
8
13
21
34
```
## Iterable
An object that implements the `@@iterator` method (such as any Array) is considered to be an Iterable object. This means that they define iteration behavior and can be used in constructs such as a `for...of` loop. We make use of the `yield` keyword like we did in our generator functions, but we define `@@iterator`. Reusing our example above:
```JavaScript
let fib = function(num) {
    if(num == 0 || num == 1) {
        return 1;
    }
    return fib(num-1) + fib(num-2);
}
const fibIterable = {
    *[Symbol.iterator]() {
        for (let i = 0; i < 9; i++) {
            yield fib(i);
        }
        return;
    }
}
for (let value of fibIterable) {
    console.log(value);
}
```
Output:
```
1
1
2
3
5
8
13
21
34
```