# Symbol
Symbol is a primitive data type introduced in EcmaScript 2015 (ES6). Every symbol value is menat to be unique, meaning it can serve as an identifier. Several APIs have a symbol that has been defined as a constant to represent a method, such as `Symbol.iterator`, `Symbol.hasInstance`, and `Symbol.toPrimitive`. To obtain a symbol of your own, you call `Symbol()`, which will return a unique symbol.

When we use a symbol as an identifier for a field on an object, we make modifying that field a little more difficult. We can make use of reflection and the `Object.getOwnPropertySymbols()` method to obtain an array of all the symbols in an object so that we may modify a value.

## Example
```JavaScript
let obj = {
    [Symbol()]: 'encapsulated'
}
console.log(obj); // Without a reference to the symbol, I can't modify the string.
let symArray = Object.getOwnPropertySymbols(obj);
console.log(symArray);
obj[symArray[0]] = 'accessed!';
console.log(obj);
```