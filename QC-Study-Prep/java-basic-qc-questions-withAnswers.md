# QC Questions that may be asked on Monday 2/21

## Java Basics
* What is Java? / Why Java?
  * A high-level OOP language with rich API libraries, widely used around the world, supported by Oracle. Write once run anywhere (WORA), statically typed, compiled language

* What is JRE / JDK / JVM?
  * JVM - Java virtual machine. Runs compiled Java code
  * JRE - Java runtime environment. Contains the JVM.
  * JDK - Java developer kit. Has a compiler, debugger, etc. Contains JRE and JVM.

* What is an object / class?
  * Class is a blueprint for an object

* What is the root class from which every class extends?
  * The `Object` class

* What are the primitive data types in Java?
  * boolean, byte, short, int, long, float, double, char

* Where are Strings stored?
  * In the String pool in the heap

* Explain stack vs heap?
  * Heap is where objects are stored in memory. Stack is where local variable references are kept - a new stack FRAME is created for each method invocation

* What are annotations?
  * A type of syntactic metadata added to the code, read by the compiler - use `@` syntax

* What is a POJO? What is a bean?
  * POJO - plain old Java object. Any Java object that you create.
  * Bean - a POJO that has private data members, public getters/setters, and overrides `.hashcode()`, `.equals()`, and `.toString()` methods

* How can you force garbage collection in Java?
  * Garbage collection cannot be forced but only requested using `System.gc()`.

* Why are strings immutable in java?
  * Identical String literals are collected in the "String pool" in an effort to conserve memory. Reference variables will then point to the same String object instance. Changing the object's state in the String pool will make changes to all references to that String object. Instead, when a change to a String is made, the JVM makes a new String object, and the reference variable points to the new String in the String pool.

* What is the difference between `String`, `StringBuilder`, and `StringBuffer`?
  * Strings are immutable.  Both `StringBuilder` and `StringBuffer` are mutable.  Furthermore, `StringBuffer` is sychronized while `StringBuilder` is not.

* What are the access modifiers in Java? Explain them.
  * `public`  - can be accessed from any package.
  * `private` - only members of the same class can access.
  * `protected` - can be accessed by classes inside the package and subclasses anywhere.
  * `default` - no access by classes or subclasses outside the package

* What are the non-access modifiers in Java?
  * `static`, `final`, `abstract`, `default`, `synchronized`, `transient`, 
  * obscure keywords: `volatile`, `native`, `strictfp`

* What is the difference between `static` and `final` variables?
  * `static` variables are shared by all the instances of objects and it has only single copy. A `final` variable is a constant and it cannot be changed. However, if the variable holds a reference to an object, the state of the object may still be changed and manipulated.

* What are the default values for all data types in Java?
  * Objects - `null`
  * int, short, byte, long, float, double - 0
  * boolean - `false`
  * char - 'u0000' (null character)

* What is a wrapper class?
  * Wrapper class is a wrapper around a primitive data type. It represents primitive data types in their corresponding class instances e.g. a boolean data type can be represented as a `Boolean` class instance. All of the primitive wrapper classes in Java are immutable i.e. once assigned a value to a wrapper class instance cannot be changed further.

* What is autoboxing?
  * Auto-boxing is the automatic conversion of primitives to their wrapper classes by the compiler. Useful for adding primitives to collections

* Is Java pass-by-value or pass-by-reference?
  * Java is strictly pass by value. Even when object references are passed as arguments, it is the value of the reference that is passed

* What makes a class immutable?
  * Declare the class as `final` so it can't be extended.
  * Make all fields `private` so that direct access is not allowed.
  * Don't provide setter methods for variables.
  * Make all mutable fields final so that it's value can be assigned only once.
  * Initialize all the fields via a constructor performing deep copy.
  * Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.

* If two objects are equal, do they have the same hashcode? If not equal?
  * If two objects have the same hashcode then they are NOT necessarily equal. But if objects are equal, then they MUST have same hashcode.

* What data types are supported in switch statements?
  * `String`, `int`, `char`, `short`, `byte`, `enums`

* List all non-access modifiers?
  * `static`, `final`, `abstract`, `default`, `synchronized`, `transient`, `volatile`, `native`, `strictfp`

* How to pass multiple values with a single parameter into a method?
  * Use varargs
  
*  Can we access static/non-static variables from static/non-static methods (see example)?

<br>

```java
public class A {
  public static int x = 1;
  public int y = 2;

  public static void doStuff() {
    System.out.println(y);
  }

  public void doMoreStuff() {
    System.out.println(x);
  }
}
```
<br>

* What is static block?
  * Used for static initialization. Executed only once - upon creation of first object of class or access to static method of class

* What is static imports?
  * Importing a static method or variable from a class - syntax: `import static`

* What methods are available in the Object class?
  * `.clone`, `.hashcode`, `.equals`, `.toString`

* How would you clone an object?
  * First, tag the class with the `Cloneable` marker interface. Next, invoke `clone()`. The clone method is declared in `java.lang.Object` and does a shallow copy.

* What is the difference between `==` and `.equals()`?
  * `==` -  tests to see if two reference variables refer to the exact same instance of an object.
  * `.equals()` - tests to see if the two objects being compared to each other are equivalent, but they need not be the exact same instance of the same object.

* What is an enhanced for loop and what is a `forEach` loop?
  * Enhanced for loop allows easier traversal of Collections (actually any arrays or `Iterable`s) - syntax: `for (Object o : collection) {...}`

* What are 3 usages of `super` keyword?
  * to refer to immediate parent class instance variable.
  * `super()` is used to invoke immediate parent class constructor (also can pass params)
  * to invoke immediate parent class method.
  
  <br>
  
## OOP
* What are the 4 pillars of OOP / Explain each?
  * **Abstraction** - Hiding implementation details
  * **Polymorphism** - Subclasses of a class can define their own unique behaviors and yet share some of the same functionality of the parent class. An object can also be referenced by its supertype "parent" class, for example `ParentClass obj = new SubClass()`;
  * **Inheritance** - A class that is derived from another class is called a subclass (also a derived class, extended class, or child class). The class from which the subclass is derived is called a superclass (also a base class or a parent class).
  * **Encapsulation** can be described as a protective barrier that prevents the code and data being randomly accessed by other code defined outside the class. Access to the data and code is tightly controlled by an interface.

* Is this allowed? Is this an example of method overloading or overriding?
  * Overriding. This is an example of covariant return types: a method is allowed to return objects that are child classes of the return type. Also, when overriding a method, the return type of the new method can be a child class of the original return type

<br>

```java
public abstract class Super {
  public abstract Collection getCollection();
}

public abstract class Sub extends Super {
  public abstract List getCollection();
}
```

<br>

* What is the difference between an abstract class and an interface?
  * An abstract class can have both concrete and abstract methods whereas an interface must have only abstract methods if any (unless the default keyword is used). Interface methods are implicitly public and abstract, interface variables are implicitly public, static, and final, but these do not apply in abstract classes. Neither can be instantiated

* What are the implicit modifiers for interface variables?
  * `public` `static` `final`

* What is the difference between method overloading and overriding?
  * Method overriding - In a subclass when one declares an identical method from the superclass, this method overrides the one in the superclass.
  * Method overloading - Within the same class when one declares more than method with the same name but different signature (parameters).

* Can you overload / override a main method? static method? a private method? a default method? a protected method?
  * Main method - overload, cannot override b/c is static method.
  * Static method - overload, cannot override b/c belongs to class (not inherited).
  * Private method - overload, cannot override b/c doesn't get inherited.
  * Default method - both.
  * Protected method - both (override if inherited). 

*  Explain the difference

<br>

```java
List<String> mylist = new ArrayList<>();
ArrayList<String> list2 = new ArrayList<>();
```

<br>

* Difference between extends and implements?
  * Extends is for classes, implements is for implementing interfaces

* What are enumerations (enums)?
  * A special Java type that defines a collection of constants

* What are the implicit modifiers for interface variables / methods?
  * methods - public abstract; variables - public static final

* First line of constructor?
  * The compiler will insert `super()` as the first line - it cannot be used anywhere else in constructor except for the first line

* Can you instantiate this class? Why or why not?
```java
public class Hello {

}
```

<br>

## Collections / Generics
* What are collections in Java?
  * A general data structure that contains Objects. Also the name of the API

* What are the interfaces in the Collections API?
  * Iterable, Collection, List, Queue, Set, Map, SortedSet, SortedMap

* What is the difference between a `Set` and a `List`?
  * `Set` does not allow duplicates (its members are unique)

* What is the difference between a `Array` and an `ArrayList`?
  * An array is static and its size cannot be changed, but an ArrayList can grow/shrink

* What is the difference between `ArrayList` and `Vector`?
  * `Vector` is synchronized whereas `ArrayList` is not.

* What is the difference between `TreeSet` and `HashSet`?
  * The two general purpose `Set` implementations are `HashSet` and `TreeSet`. `HashSet` is much faster (constant time versus log time for most operations) but offers no ordering guarantees.

* What is the difference between HashTable and HashMap?
  * `Hashtable` is synchronized whereas `Hashmap` is not.
  * `Hashmap` permits `null` values and the `null` key.

* Are Maps in the Collections API?
  * Yes, but they do not implement `Collection` or `Iterable` interfaces

* What happens here?

<br>

```java
List<String> mylist = new ArrayList<>();
mylist.add("hello");
mylist.add(new Person()); // what happens?
```
<br>

* What are generics? What is the diamond operator (`<>`)?
  * A way of specifying a type within a data structure - they enforce type safety. `<>` operator lets you infer generic types from the LHS of assignment operation

<br>

## Exceptions
* What is the difference between `final`, `.finalize()`, and `finally`?
  * `final`: final keyword can be used for class, method and variables. A final class cannot be subclassed and it prevents other programmers from subclassing a secure class to invoke insecure methods. A final method can't be overridden. A final variable can't change from its initialized value.
  * `finalize()`: finalize method is used just before an object is destroyed and called just prior to garbage collection.
  * `finally`: finally, a key word used in exception handling, creates a block of code that will be executed after a `try/catch` block has completed and before the code following the `try/catch` block. The `finally` block will execute whether or not an exception is thrown. For example, if a method opens a file upon exit, then you will not want the code that closes the file to be bypassed by the exception-handling mechanism. This finally keyword is designed to address this contingency.

* `throw` vs `throws` vs `Throwable`?
  * `Throwable` - the root (super) class of exceptions, allow a class to be "thrown"
  * `throws` - keyword in method signature after params that declare which exception the method might throw
  * `throw` - the keyword that will actually "throw" an exception in code

* What is try-with-resources? What interface must the resource implement to use this feature?
  * Try-with-resources allows for automatically closing resources in a try/catch block using `try(resource) {...}` syntax. Must implement the `AutoCloseable` interface

* Do you need a catch block? Can have more than 1? Order of them?
  * Catch block is not necessary - try/finally will compile. You can have more than one catch block, but the order must be from most narrow exception to most broad/general.

* What is base class of all exceptions? 
  * The base class is `Exception`, which extends the `Throwable` class.

* List some checked and unchecked exceptions?
  * Checked - `IOException`, `ClassNotFoundException`, `InterruptedException`
  * Unchecked - `ArithmeticException`, `ClassCastException`, `IndexOutOfBoundsException`, `NullPointerException`

* Multi-catch block - can you catch more than one exception in a single catch block?
  * Yes, use the `|` operator

* Is this an example of a checked or unchecked exception?
```java
public class MyException extends RuntimeException {}
```

<br>

## JUnit
* What is JUnit?
  * A Java unit testing framework for testing code - use it for TDD

* What is TDD?
  * Test-driven development - write unit tests before application code, then write code to make tests pass. Repeat this process until functionality is complete.

* What are the annotations in JUnit? Order of execution?
  * BeforeClass, AfterClass, Before, After, Test, Ignore

* Give an example of a test case?
  * Adding two numbers, check that the method returns the sum

<br>


## IO / Serialization
* How do you serialize / deserialize an object in Java?
  * Step 1: An object is marked serializable by implementing the `java.io.Serializable` interface, which signifies to the underlying API that the object can be flattened into bytes and subsequently inflated in the future.
  * Step 2: The next step is to actually persist the object. That is done with the `java.io.ObjectOutputStream` class. That class is a filter stream--it is wrapped around a lower-level byte stream (called a node stream) to handle the serialization protocol for us. Node streams can be used to write to file systems or even across sockets. That means we could easily transfer a flattened object across a network wire and have it be rebuilt on the other side!
  * To restore the object back, you use `ObjectInputStream.readObject()` method call. The method call reads in the raw bytes that we previously persisted and creates a live object that is an exact replica of the original. Because `readObject()` can read any serializable object, a cast to the correct type is required. With that in mind, the class file must be accessible from the system in which the restoration occurs. In other words, the object's class file and methods are not saved; only the object's state is saved.
