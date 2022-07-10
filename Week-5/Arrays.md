## Arrays

An array is a variable that allows the programmer to store more than one value. Arrays in JavaScript are objects and thus consist of key/value pairs and inherit from the Array prototype. Like objects, array values can consist of JavaScript primitives, or other JavaScript objects, including arrays and functions.

### Creating an Array
In JavaScript, arrays can be created using square brackets, using what is known as an array literal. They can also be created using the ```new``` keyword, but it is best practice to use array literals.
```
// array literal
let cheeses = ['bleu', 'cheddar', 'parmesan', 'brie']
// ["bleu", "cheddar", "parmesan", "brie"]
// new keyword
let primes = new Array(2, 3, 5, 7, 11, 13)
// [2, 3, 5, 7, 11, 13]
```

Both methods create an array object based on the Array Prototype.

### Array Structure
All array objects share a common structure. Each array has a `length` field that stores the current length of the array. In addition, the prototype of an array is `[]`, giving each array access to certain functions that we will cover later.

```
let array = [1, 2, 3]
console.log(array.length) // 3
console.log(array.__proto__) // []
```

#### Accessing an Array

Arrays in JavaScript are **zero-indexed**, meaning that the first element in an array is represented by the key `0`. In order to access our array, we can use Array Notation:

```
let cheeses = ['bleu', 'cheddar', 'parmesan', 'brie']
console.log(cheeses[0]) // bleu
```
Here, we gave the zero-index to obtain the first element in the array, which is the string `bleu`. The string `cheddar` would be represented by the key `1`, `parmesan` would be `2`, and `brie` would be `3`. The length of the array is `4`. The last key of an array is normally `array.length - 1`, however, be aware that there might not be data at this location.

```
//access the last element of the array
console.log(cheeses[cheeses.length-1])
```

#### Modifying an Array

You can also assign a different value by using the index and an assignment operator.

```
cheeses[2] = 'american' // changes parmesan to american
```

**Changing the Array Length** - JavaScript is a dynamic language and arrays are no different. the length of an array can be changed in several ways.

**Adding an Item** - To add an item to an array you can specify an index

```
// create an empty array
let arr = []
console.log(arr.length) // 0
// add an element at a specific index
arr[0] = 'duck'
console.log(arr.length) // 1
console.log(arr) // ["duck"]

arr[3] = 'chicken'
console.log(arr.length) // 4
console.log(arr) // [ "duck", <2 empty slots>, "chicken"]
```
In the above example, we first added the string `duck` to an empty array, changing the length of that array from 1 to 0. Note however, that this can be dangerous, as we can specify any index we wish. We then added the string `chicken` at index 3, changing the length of our array to 4, with two empty indexes. One way around this would be to use the `length` field to determine what the next index should be.

```
arr[arr.length] = 'pigeon'
console.log(arr.length) // 5
console.log(arr) // [ "duck", <2 empty slots>, "chicken", "pigeon"]
```

An easier and safer way to add a new element to an array is the `push()` method inherited from the Array Prototype.

```
let students = []
students.push('Timothy')
students.push('Zach')
console.log(students.length) // 2
console.log(students) // ["Timothy", "Zach"]
```

**Removing an Item** - Removing an item from an array in JavaScript can result in unexpected behavior if done incorrectly. When removing a key from an object, you might use the `delete` keyword. When you do this with an array, the length field will not be updated, resulting in an empty slot.

```
let arr = [1, 2, 3]
// [1, 2, 3]
console.log(arr.length) // 3
delete arr[0]
// [<empty slot>, 2, 3]
console.log(arr.length) // 3
```

In order to remove elements we turn to the methods `splice()`, `pop()`, and `shift` from the Array Prototype. The `splice()` method allows us to remove a number of elements at a specific index. It can also allow us to replace those elements with something else.  `splice()` returns an array containing all the values removed from the array.

**NOTE**: In most browers, if you do not specify the number of elements to remove, it will remove all elements starting at the index specified.

```
let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
arr.splice(2, 1) // returns [3]
console.log(arr)
// [1, 2, 4, 5, 6, 7, 8, 9]
arr.splice(4, 3) // returns [6, 7, 8]
console.log(arr)
// [1, 2, 4, 5, 9]
```

The `pop()` method removes and returns the last element in an array and the `shift()` method removes and returns the first element in an array.

```
let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
arr.pop() // returns [9]
console.log(arr)
// [1, 2, 3, 4, 5, 6, 7, 8]
arr.shift() // returns [1]
console.log(arr)
// [2, 3, 4, 5, 6, 7, 8]
```

**NOTE:** - The `length` field can be modified directly. This can lead to arrays behaving a little oddly. If you change the `length` field to a value less than the actual length of the array, JavaScript will remove elements from the array in most browsers. If you set the field to a greater value, it will "add" empty fields. The fields that are added only exist in the `toString` method, as no keys are created.

### Iterating Through an Array

You can use a for loop to iterate through an array in JavaScript:
```
let list = [1, 2, 3, 4, 5];

// standard for
for(let i = 0; i < list.length; i++){
    console.log(list[i]);
}
```

Arrays are iterable, and so you can use a `for-in` or `for-of` loop to iterate through an array. `for-in` will iterate through the keys of an array. `for-of` will iterate through the values of the array.
```
// for-in
for(key in list) {
    // an enhanced for-in loop in JS iterates through
    // the keys not the values
    console.log(key);
    console.log(list[key]);
}

// for-of
for(element of list) {
    // if you say of, it will iterate through the values
    console.log(element);
}
```

There is also the `forEach()` method on the Array Prototype. This function is a functional array method that takes in a callback function and runs that function for each element in the array. The `forEach()` method returns undefined.
```
// forEach()
list.forEach(
    function(value, index) {
        console.log(index + ' ' + value);
    }
)
```
### Array Methods
The Array Prototype includes many useful methods. Above, we covered the `splice()`, `shift()`, `push()`, `pop`, and `forEach()`. Here we will talk about a few other useful methods.
#### sort()
The `sort()` method will sort an array "in-place". This means that the array will be modified and the original array will be sorted. The `sort()` method can take in a function that will compare objects and sort them to your preference. If no callback function is provided, each element is converted to a string and sorted in ascending order.

```
let list = ['tiger', 'panda', 'giraffe', 'cat', 'owl', 'bird']
list.sort()
// this will sort alphabetically
console.log(list)
// [ "bird", "cat", "giraffe", "owl", "panda", "tiger" ]

// This will sort by size of the string
list.sort(function(item1, item2) {return item1.length - item2.length})
console.log(list)
// [ "cat", "owl", "bird", "panda", "tiger", "giraffe" ]
```

#### indexOf() & lastIndexOf()
The `indexOf()` method returns the first index at which an element is present. `lastIndexOf()` returns the last index at which an element is present. If the element can't be found in the list, both will return the value `-1`.
```
let list = [1, 1, 2, 3, 3, 5, 6, 1]
list.indexOf(3) // returns 3
list.lastIndexOf(3) // returns 4
list.indexOf(1) // returns 0
list.lastIndexOf(1) // returns 7
list.indexOf('cat') // returns -1
list.lastIndexOf('cat') // returns -1
```
#### find() & findIndex()
The `find()` method returns the first element in an array for which the callback function returns a truthy value. The `findIndex()` method does the same but returns that element's index. For example, if I were to try to find the first string in an array that had a length greater than or equal to 7, I could write a function that tested for that and pass it to the `find()` method:

```
let words = ['the', 'small', 'fox', 'ate', 'a', 'largish', 'breakfast', 'and', 'slept']
words.find(function(word) {return word.length >= 7}) //returns 'largish'
words.findIndex(function(word) {return word.length >= 7}) //returns 5
```

#### filter()
The `filter()` function takes a callback function and creates a new array that is the made up of elements for which the callback function returns a truthy value. This can be useful in situations where you wish to perform an operation on only a subset of elements in an array. The original array is not modified. For example, I may wish to get only even numbers from an array:

```
let list = [4, 67, 34, 55, 79, 12]
let evens = list.filter(function(n) { return n%2 === 0 })
console.log(evens)
// [ 4, 34, 12 ]
```

#### map()
The `map()` function takes a callback function and creates a new array that is the result of calling the function on each element of the array. The original array is not modified. For example, if I were to have an array of numbers and I wished to have an array of the squares of those numbers, I could use the `map()` function to accomplish this:

```
let numbers = [1, 2, 3, 4, 5, 6, 7]
let squares = numbers.map(function(n) {return n*n})
console.log(squares)
// [ 1, 4, 9, 16, 25, 36, 49 ]
```

#### reduce()
The `reduce()` function takes a callback function and returns a single value that is the result of calling the function for each value in the array. For example, if we wished to have the sum of each element in an array, we could do the following:

```
let numbers = [1, 2, 3, 4, 5, 6, 7]
let result = numbers.reduce(function(previousValue, currentValue) {return previousValue + currentValue})
console.log(result) // 28
```