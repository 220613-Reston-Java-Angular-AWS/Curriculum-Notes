Difficulty,Question,Answer
,What methods are available in the Object class?,"`.clone`, `.hashcode`, `.equals`, `.toString`"
,How would you clone an object?,"First, tag the class with the `Cloneable` marker interface. Next, invoke `clone()`. The clone method is declared in `java.lang.Object` and does a shallow copy."
,What is an enhanced for loop and what is a `forEach` loop?,Enhanced for loop allows easier traversal of Collections (actually any arrays or `Iterable`s) - syntax: `for (Object o : collection) {...}`
,What is try-with-resources? What interface must the resource implement to use this feature?,Try-with-resources allows for automatically closing resources in a try/catch block using `try(resource) {...}` syntax. Must implement the `AutoCloseable` interface
,How to make numbers in your code more readable?,Use the `_` for numeric literals - must be placed between numbers
,What are covariant return types?,"A method is allowed to return objects that are child classes of the return type. Also, when overriding a method, the return type of the new method can be a child class of the original return type"
,What are 3 usages of `super` keyword?,"1. to refer to immediate parent class instance variable.
2. `super()` is used to invoke immediate parent class constructor (also can pass params)
3. to invoke immediate parent class method."
,Can you overload / override a main method? static method? a private method? a default method? a protected method?,"Main method - overload, cannot override b/c is static method.
Static method - overload, cannot override b/c belongs to class (not inherited).
Private method - overload, cannot override b/c doesn't get inherited.
Default method - both.
Protected method - both (override if inherited). "
,Difference between FileReader and BufferedReader?,"`FileReader` is just a `Reader` which reads a file, so it reads characters and uses the platform-default encoding.
`BufferedReader` reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines (e.g. can read one line at a time).
So you can wrap a `BufferedReader` around a `FileReader`"
,How to pass multiple values with a single parameter into a method?,Use varargs
,What is static block?,Used for static initialization. Executed only once - upon creation of first object of class or access to static method of class
,What is static imports?,Importing a static method or variable from a class - syntax: import static
,How would you clone an object?,use the `.clone()` method inherited from Object class
,What makes a class immutable?,"1. Declare the class as `final` so it can't be extended.
2. Make all fields private so that direct access is not allowed.
3. Don't provide setter methods for variables.
4. Make all mutable fields final so that it's value can be assigned only once.
5. Initialize all the fields via a constructor performing deep copy.
6. Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference."
,"If two objects are equal, do they have the same hashcode? If not equal?","If two objects have the same hashcode then they are NOT necessarily equal. But if objects are equal, then they MUST have same hashcode."
,What data types are supported in switch statements?,"`String`, `int`, `char`, `short`, `byte`, `enums`"
,List all non-access modifiers?,"`static`, `final`, `abstract`, `default`, `synchronized`, `transient`, `volatile`, `native`, `strictfp`"
,Which collections cannot hold null values?,"`HashTable`, `TreeSet`, `ArrayDeque`, `PriorityQueue`"
,"If 2 interfaces have default methods and you implement both, what happens?","The code will NOT compile unless you override the method. However, the code WILL compile if one interface is implemented further up in the class hierarchy than the other - in this case, the closest method implementation in the hierarchy will be called"
,"If 2 interfaces have same variable names and you implement both, what happens?",The code will compile unless you make a reference to the variable (this is an ambiguous reference). You must explicitly define the variable by using the interface name: `int a = INTERFACENAME.a;`
,Why does `HashTable` not take `null` key?,"The hash table hashes the keys given as input, and the `null` value cannot be hashed"
,What new syntax for creating variables was introduced with Java 10?,The `var` keyword was introduced - with type inference
,Is there an interactive REPL tool for Java like there is for languages like Python?,"Yes, the `jshell` tool introduced in Java 9"
,What are collection factory methods?,"They allow you to directly populate collections, e.g. `Set.of(1,2,3)`"
,Multi-catch block - can you catch more than one exception in a single catch block?,"Yes, use the `|` operator"