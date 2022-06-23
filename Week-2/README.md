# Monday

## Non- Access Modifiers

### Static Keyword
`Static` denotes a method, or field to be part of the class itself, rather than part of an object instantiated from the class. This means that all objects of that class share a single method or field. Consider the class below:
  
```
public class Example {
    public static int x = 5;
}
```
  
That static int x will be shared among all instances of this class. If we create two different objects from the class and print the value of x for each, they will both be 5. If we change one to 10 and then print them both again, both will show 10. There is only one version of x, which is kept in memory with the class itself.
  
Likewise we can classify methods as static as well. Static methods can be invoked on a class itself, and do not have access to non-static fields and methods. Consider a class with a non-static field, y. If you never instantiate an object from the class, y never exists. If you can invoke a static method without ever instantiating an object, and that method tries to access the field y, it would throw an error. Static methods can be invoked on a class object as well, and can be invoked on sub-classes as though inherited.
  
Lastly, we can modify some classes to be static as well. We can't make a top-most class static (every .java file must contain one top-most class which the file is named after) but we can "nest" a class inside another. These nested classes can be made static. Static nested classes can only access static members of the outer class. Nested classes can access even private members of the outer class.

### Final

The keyword `final` can be applied to a class, method or variable. In all cases it means the structure _cannot be changed_, but what that actually means depends upon the construct that it is applied to.

When applied to a variable, it means that you cannot reassign the variable to another value. You must initialize a final variable when declaring it.

```java
public final int x = 124;
```
When applied to a method, it means that you cannot _override_ the method.

```java
public final int someMethod(){ . . . }
```

When applied to a class, it means that you cannot create a subclass of this class.

```java
    public final class FinalClass { . . . }
```

A common example of a final class is the String class.

### Abstract

The abstract modifier is used to define methods that will be implemented in a subclass later on. Most often it's used to suggest that some functionality should be implemented in a subclass, or (for some reason) it can't be implemented in the superclass. If a class contains an abstract method, it must also be declared abstract.

Note: You can not create an object of an abstract class. In order to do that, you need to provide an implementation for all the abstract methods.

An example would be if we had a simple class called Employee that encapsulates data and methods for an employee. Let's say that not every employee is paid in the same way, some types of employees are paid by the hour and some are paid a fixed salary.

```java
   abstract class Employee {
    int totalHours; // In a month
    int perHour;    // Payment per hour
    int fixedRate;  // Fixed monthly rate
    
    
    
    abstract int salary();
    
}
```

```java
     class Contractor extends Employee {
   
    // Must override salary if we wish to create an object of this class
    int salary() {
        return totalHours*perHour; 
    }
   
}
```

```java
        
    class FullTimeEmployee extends Employee {
   
    int salary() {
        return fixedRate; 
    }

}
```

```java
     
    
    class Intern extends Employee {
   
    int salary() {
        return 0; 
    }
  
}
```

[Here](https://github.com/220613-Reston-Java-Angular-AWS/Curriculum-Notes/blob/mainBackup/Week-2/Access_and_NonAccess_Modifiers.md) we can find all of the modifiers and their access levels. 

<br>

## Variable Scopes
When a variable is declared in a Java program, it is attached to a specific **scope** within the program, which determines where the variable resides. The different **scopes of a variable** in Java are:
* Instance, or object, scope
* Class, or static, scope
* Method scope
* Block scope

Instance scope means that the variable is attached to individual objects created from the class. When an instance-scoped variable is modified, it has no effect on other, distinct objects of the same class.

Class scoped variables reside on the class definition itself. This means that when objects update a class-scoped variable, the change is reflected across all instances of the class. Class scope is declared with the `static` keyword. Methods can also be declared as class scope. However, `static` methods cannot invoke instance methods or variables (think about it: which specific object would they reference?). Static methods and variables should be referenced through the class directly, not through an object. For example: `MyClass.myStaticMethod()` or `MyClass.myStaticVariable`.

Method scope is the scope of a variable declared within a method block, whether static or instance. Method-scoped variables are only available within the method they are declared; they do not exist after the method finishes execution (the stack frame is popped from the stack and removed from memory after execution).

Block scoped variables only exist within the specific control flow block, of which there are several in Java: `for`, `while`, and `do-while` loops, `if/else-if/else` blocks, `switch` cases, or even just regular blocks of code declared via curly braces (`{}`). After the block ends, variables declared within it are no longer available.


## Introduction to Git
[Into To Git Video](https://git-scm.com/video/what-is-version-control)

[Git Cheat Sheet](https://training.github.com/downloads/github-git-cheat-sheet/)

Git is a **distributed version control system**. This means that the entire codebase and history of a project is available on every developer’s computer as a **local repository** , which allows for easy branching and merging. 

This repository contains all of the information that the **remote repository** has, based on the last time that you synced those two together.

Even if you don't have access to the **remote repository**, you can still view all of the changes that have been made, and contributers can maintain a copy of this record on their own machines.

### Working directory

* Untracked and modified files will exisit within the **Working Directory**. The files in the **Working Directory** are listed when we run `git status`.

* The **Staging Area** is where we organize what we want to be commited to our repository.  The **Staging Area** allows us to pick and choose which files we want to commit and when.  Commits should be details regarding what changes were made in individual files.

1. To add files to the **Staging Area** run the commmand `git add <file-name>`. To add all of the changes we've just made, run the following command.

```
$ git add .
```

When you run `git status` again, you should see the recently staged files in green.

2. To **commit** these changes run:
```
$ git commit -m "initial commit"
```

![](./../images/working-directory.png)

### Commits

Commits are the core building block units of a Git project timeline. Commits can be thought of as snapshots or milestones along the timeline of a Git project. Commits are created with the git commit command to capture the state of a project at that point in time.

### Committing work

By default, git commit will open up the locally configured text editor, and prompt for a commit message to be entered. However, passing the -m option will forgo the text editor prompt in-favor of an inline message. 

```
git commit -m "Here is where you give a brief description of what you are committing to your repository"

```
#### Remember the steps you will take whenever commiting changes: As we practice you will develop your own specfic order BUT you always want to have the most recent code in your local repositiry before pushing your code to prevent conflicts. 
```
$ git add .
$ git commit -m "a message about changes"
$ git pull
$ git push
```

The `git pull` command is used to fetch and download content from a remote repository and immediately update the local repository to match that content, **before** you push your changes.


### Branches

[Quick Tutorial](https://www.atlassian.com/git/tutorials/using-branches#:~:text=A%20branch%20represents%20an%20independent,staging%20area%2C%20and%20project%20history)

Branching is a feature available in most modern version control systems.  Instead of copying files from directory to directory, Git stores a **branch** as a reference to commit.  The branch itself represents the `HEAD` of a series of commits.

The default branch name in Git is `main`, which commonly represents the official, working version of your project.  As you start making commits, the master branch points to the last commit you made.  Everytime you commit, the master branch pointer moves forward automatically. Think of a branch as a timeline of versions of a project as it progresses.

Branching is a strategy that allows developers to take a snapshot of the master branch and test a new feature without corrupting the project in production. If the tests are successful, that feature can be **merged** back to the master branch and pushed to production.

![](./../images/git-branching.png)

  **DEMO - We'll create personal projects and push them to github.**

#### Create a login branch 
**NOTE** this must be done in a directory that is already under git

Imagine that you want to create a login functionality feature on your project.

1. To create a new branch called `login`, within your directory run: 
```
$ git branch login
```
2. To `checkout` to the newly created branch, run:
```
$ git checkout login
```
Now you will be able to create and edit files that will only exist on this branch until you merge it with `main`.



### Pull requests

A pull request – also referred to as a merge request – is an event that takes place in software development when a contributor/developer is ready to begin the process of merging new code changes with the main project repository.

It is best to do this process in Github becuase Github offers interfaces and options that we just cannot have in command line.


*Break into groups - We are going to practice branches, committing, pushing and making pull requests*


[Git-Flow WorkFlow]() - Here is taking Git Flow to the next step. 

<br>

# Tuesday 

## Object Class

#### The Object class is a special class in Java. It is the root class that ALL other classes inherit from, either firectly or indirectly. Therefore all classes have atleast the methods defined on the Object class.

- Object clone()
- boolean equals(Object o)
- void finalize()
- Class<?> getClass()
- int hashCode()
- void notify()
- void notifyAll()
- String toString()
- void wait()
- void wait(long timeout)
- void wait(long timeout, int nanos)

**Object class methods**

The toString() method is automatically called if you print an Object. Usually, this is overridden to provide human-readable output. Otherwise, you will print out fully.qualified.ClassName@memoryAddress

The equals(Object o) method compares two Objects. The == operator also compares objects, but only the memory address (i.e. will return true if and only if the variables refer to the exact same object in memory). By default, and unless you explicitly override it, the equals method simply calls the == operator.

The hashCode() method returns a hash code - a number that puts instances of a class into a finite number of categories. There are a few rules that the method follows:

You are expected to override hashCode() if you override equals()
The result of hashCode() should not change in a program
if .equals() returns true, the hash codes should be equal
if .equals() returns false, the hash codes do not have to be distinct. However, doing so will help the performance of hash tables.
Finally, the .finalize() method is called by the garbage collector when it determines there are no more references to the object. It can be overriden to perform cleanup activities before garbage collection, although it has been deprecated in newer versions of Java.

[Here](https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html) is a great resource about the Object Class.

<br>

## Exceptions
When an exceptional condition occurs in the course of a Java program, a special class called an `Exception` can be **thrown**, which indicates that something went wrong during the execution of the program. If the exception is not handled anywhere in the program, it will propagate up through the call stack until it is handled by the JVM which then terminates the program.

### Exception Class Hierarchy
![Exceptions hierarchy](https://i.pinimg.com/originals/a6/ab/f3/a6abf35c5fbbb57ebd4e949945839f31.jpg)

The exception class hierarchy starts with the `Throwable` class which inherits from `Object`. Any object which is a `Throwable` can be "thrown" in a program by the JVM or by the programmer using the `throws` keyword. The `Exception` and `Error` classes both extend `Throwable`. An `Error` represents something that went so horribly wrong with your application that you should not attempt to recover from. Some examples of errors are:
* `ExceptionInInitializerError`
* `OutOfMemoryError`
* `StackOverflowError`

`Exception` is a general exception class which provides an abstraction for all exceptions. There are many subclasses of `Exception`, as shown above.

#### Unchecked vs Checked Exceptions
The `Exception` class and all of its subclasses, except for `RuntimeException`, are known as "checked exceptions". These represent occasions where it is reasonable to anticipate an unexpected condition, like a file not existing when attempting to write to it (which would result in a `FileNotFoundException`). **Checked exceptions are required to be handled or declared by the programmer** - otherwise, the code will not compile.

`RuntimeException` is a special type of exception - it, and all of its subclasses - are known as "unchecked exceptions". An **unchecked exception** is an exception that **is not required to be handled or declared** like checked exceptions are. Some examples include:
* `ArithmeticException` for illegal math operations
* `IndexOutOfBoundsException` for if you reference an index that is greater than the length of an array
* `NullPointerException` for if you attempt to perform an operation on a reference variable that points to a `null` value

#### Handling / Declaring Exceptions
When risky code is written that has the possibility of throwing an exception, it can be dealt with in one of two ways:
1. Handling means that the risky code is placed inside a try/catch block
2. Declaring means that the type of exception to be thrown is listed in the method signature with the `throws` keyword. This is also called "ducking" the exception - you let the code which calls the method deal with it.

## `try/catch/finally` Blocks
In order to handle exceptions that could be thrown in our application, a `try/catch` block can be used. The `try` block encloses the code that may throw an exception, and the `catch` block defines an exception to catch and then runs the code inside only if that type of exception is thrown. We can optionally include a `finally` block which will run whether an exception is thrown or not. A simple example is shown below:

```java
try {
  object.someRiskyMethodCall();
} catch(Exception e) {
  System.out.println("phew! that was close!");
} finally {
  System.out.println("I'll run whether there was a problem or not!");
}
```

### `try/catch/finally` Block Rules
Catch and finally blocks have several different rules which must be followed:
* Multiple catch blocks are allowed. More specific exceptions must come before more general exception types.
* Multi-catch blocks (catching more than one exception in a given block) are allowed, exception types are separated by `|`
* The `finally` block is optional
* A `try/finally` block only IS allowed, but a `try` block by itself is not
* A `finally` block will always execute, unless of course `System.exit()` is called

### Try-With-Resources
Try with resources is a newer syntax for try blocks. When using try/catch blocks, often times some object used in the code is a resource that should be closed after it is no longer needed to prevent memory leaks - for example a FileReader, InputStream, or a JDBC Connection object. With Java 7, we can use a try-with-resources block which will automatically close the resource for us:

```java

try(Connection connection = ConnectionUtil.getConnection()) {
	logger.info("Connection successful");
} catch (SQLException e) {
	logger.error("Couldn't connect to the database", e);
}

```

## Custom Exceptions
A programmer can create custom exceptions in Java by extending any exception class. If you extend `RuntimeException`, however, you will be creating an unchecked exception. This is a good idea if you do **not** want other code to have to handle your exception being thrown. If you do always want to require your exception to be handled, then create a checked exception by extending any existing one, or the `Exception` class itself.

```java
public class MyCheckedException extends Exception {}
public class MyUncheckedException extends RuntimeException {}

public class ExceptionThrower {

  public static void main(String[] args) {
    try {
	  throw new MyCheckedException("uh oh");
	} catch(MyCheckedException e) {} // we're just ignoring it here
	
    if ( 100 > 1) {
	  throw new MyUncheckedException("you're not required to handle me!");
	}
  }
  
  public static void declareChecked() throws MyCheckedException {
    throw new MyCheckedException("this one is declared!");
  }
}
```
<br> 

# Wednesday 

## Arrays

An array is a contiguous block of memory storing a group of sequentially stored elements of the same type. Arrays in Java are of a fixed size and cannot be resized after declaration. Arrays are declared with square brackets after the type of the array like so:
```java
int[] myInts = new int[]{1, 2, 3, 4};
String languages[] = {"Java", "JavaScript", "SQL"};
```

Items in an array are referenced via their index in square bracket notation, which begins with `0` for the first element. Arrays also have a `length` property specifying the length of the array. This is helpful when iterating over arrays with a `for` loop:
```java
String[] myArr = {"first", "second", "third"};
for (int i = 0; i < myArr.length; i++) {
  System.out.println(myArr[i]);
}
```

### Varargs
Instead of writing our `main` method the standard way, we can use an alternative notation:
```java
public static void main(String... args) { }
```

Here we are using the `varargs` construct `...` which replaces the array notation. `varargs` stands for "variable arguments", and allows us to set an argument to a method whose size is determined at runtime. Java will create an array under the hood to fit the arguments provided. You can only ever have 1 varargs parameter in a method, and it **MUST** be the last parameter defined (otherwise, how would the JVM know the difference between the last value in varargs and the next parameter of the method?). You can omit the vararg value when invoking the method and Java creates an array of size 0.

```java
public class VarargsExample {
  public static void someMethod(int a, int... manyInts) {
    System.out.println("First argument: " + a);
	System.out.println("Next argument: ");
	for (int i = 0; i < manyInts.length; i++) {
	  System.out.println(manyInts[i]);
	}
  }
  
  public static void main(String[] args) {
    VarargsExample.someMethod(1, 3, 4, 5, 6);
	// First argument: 1
	// Next argument:
	// 3
	// 4
	// 5
	// 6
  }
}
```

### forEach() Method
We can use the `.forEach` method of the `Iterable` interface, which accepts a lambda expression as its argument:

```java
List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
names.add("Charlie");
names.forEach(str -> System.out.println(str));
```

This will print out the names just as if we had used a `for` loop. The lambda syntax could also be done with an explicit type declaration for the parameter, but the compiler can infer the type from the value used. For multiple parameters, parentheses are required around them. Also, curly braces are optional for single statements but required for multiple. Finally, the `return` keyword is also optional for a single expression because the value will be returned by default.

#### `.forEach()` method
The `forEach()` method actually accepts what is called a functional interface as its parameter (specifically a `Consumer`), which the lambda expression then implements at runtime. The `forEach()` method then loops through `names` and passes each element to the lambda expression to be "consumed".


## Strings
In Java, Strings are **not** primitives - they are immutable, constant objects derived from the [`String`](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html) class. To be immutable means that the state or value of the object cannot be altered once created - this is accomplished by having internal, private and final fields and not implementing any "setter" methods which would alter the state of those fields.

Because Strings are immutable, all of the methods in the String class return a **new** String - the original is not modified. For example:
```java
String str1 = "my string";
str1.concat(" is the best!");
System.out.println(str1);
```
will print out `my string`. Why? Because the `.concat()` method **returns** a completely different string which we are not assigning to any variable, and the original object is not changed (it is immutable). Thus, `str1` still refers to the String "my string". In order to make the code print "my string is the best!", we would need to change line 2: `str1 = str1.concat(" is the best!");` which **re-assigns** the reference variable `str1` to the new String returned from the method (the original String hasn't changed, however).

### String Pool
When Strings are created they are placed in a special location within the heap called the String Pool. When String literals are created, if there is an existing String that matches in the String Pool, the reference variable will point to the existing value. Duplicates will not exist in the String Pool. This is important because Strings take up a lot of memory. Being able to reuse the same value throughout your application is advantageous.

One way to circumvent the above process is to use the `new` keyword along with the String constructor, which will explicitly create a new String object in memory, even if one already exists in the String Pool.

```java
String a = "foo";
String b = "foo";
String c = new String("foo");
System.out.println(a == b); // true
System.out.println(a == c); // false
```

## StringBuffer and StringBuilder

Since Strings are immutable, it becomes inefficient to use them if we are making many new Strings constantly, for example if we are generating new Strings in a `for` or `while` loop. Instead, we can use the `StringBuilder` and `StringBuffer` classes, both of which are **mutable**. [`StringBuilder`](https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html) contains helpful methods like `.append()` and `.insert()` which mutate its internal sequence of characters. [`StringBuffer`](https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuffer.html) is like `StringBuilder` but is synchronized, which is useful for multi-threaded applications.

| Class | Immutable? | Thread-safe? | Speed |
| ----  | ---------- | ------------ | ----- |
| String | Y | Y | Slowest |
| StringBuilder | N | N | Fastest |
| StringBuffer | N | Y | Fast |

[`StringTokenizer`](https://docs.oracle.com/javase/8/docs/api/java/util/StringTokenizer.html) is a related class which can parse a String and splits it based on a delimiter.

## Reading User Input from the Console
The `Scanner` class can be used to read user input from the command line:

```java
Scanner sc = new Scanner(System.in);
while (true) {
  String input = sc.nextLine();
  System.out.println("Your input: " + input);
}
```

When the code above is run, the program acts to "echo" back any input given from `stdin`.

## Interfaces

An interface acts as a contract for behaviors that a class can implement.

```java
public interface InterfaceA {
 public void methodName(); //You don't implement the method!
}
```
Interfaces have implicit modifiers on methods and variables.
- Methods are 'public' and 'abstract'
- Variables are 'public', 'static', and 'final'
To inherit interfaces, a class must *implement* them and they are REQUIRED to implement all methods, unless the class is abstract.

## Abstract Classes

- An abstract class is a class that is declared `abstract` —it may or may not include abstract methods. Abstract classes cannot be instantiated, but they can be subclassed.
- An abstract class can have 0 or more abstract methods, but if a class has at least one abstract method then the whole class has to be abstract.
- An abstract class can have implemented methods as well.
- Use the `extends` keyword to extend an abstract class.

```java
public abstract class GraphicObject {
   // declare fields
   // declare nonabstract methods
   abstract void draw();
}

class Circle extends GraphicObject {
    void draw() {
        ...
    }
    void resize() {
        ...
    }
}

class Rectangle extends GraphicObject {
    void draw() {
        ...
    }
    void resize() {
        ...
    }
}
```

### Difference between interface and Abstract classes
- Conceptually, interfaces define behaviors and abstract classes are for concepts and inheritance.
- You can implement multiple interfaces, but you can extend only one class.

#### Abstract Classes and Interfaces - Summary
Abstract classes, as mentioned above, are more general classes which cannot be instantiated. They instead act as templates for other classes to extend from. Abstract classes can have both concrete and abstract methods - the `abstract` methods must be implemented by concrete subclasses.

Interfaces also cannot be instantiated. They instead serve as contracts for methods that classes must implement. In order to inherit from interfaces, a class declares that it `implements` some interface, or multiple interfaces. Methods declared on an interface are implicitly `public` and `abstract`. Interfaces can have variables, but they are implicitly `public`, `static`, and `final`. Since Java 8, interfaces can also provide method implementations if the method is marked `static` or `default`.

Abstract classes are better suited for defining *common characteristics* of objects and are named as nouns by convention, whereas interfaces are better for defining common *behavior* the implementing class promises to provide.

## Stack and Heap
Inside the JVM, our application memory is divided into the "[stack][1]" and the "[heap][2]". The stack is where method invocations and reference variables are stored in stack frames. For example, when the JVM invokes the `main` method a stack frame is created for it and placed on the stack. Multiple stacks are possible - for example, when a thread is created it is given its own stack.

The heap, in contrast, is a central location in memory where all objects are stored. New objects are created via the `new` keyword and (optionally) assigned to a reference variable, which can then be re-assigned to reference different objects later. Thus, multiple reference variables could point to the same object in memory.

**Note:** Errors at runtime can be thrown if a program runs out of memory addresses for new stack frames (`StackOverflowError`), or if no memory is available in the heap for object creation (`OutOfMemoryError`).

[1]: https://en.wikipedia.org/wiki/Stack_(abstract_data_type)
[2]: https://en.wikipedia.org/wiki/Heap_(data_structure)

[Here](https://github.com/220613-Reston-Java-Angular-AWS/Curriculum-Notes/blob/mainBackup/Week-2/Stack_and_Heap.md) we have more info on this topic

## Garbage Collection 

- Garbage collection in Java is the process by which Java programs perform automatic memory management. 
- Java programs compile to bytecode that can be run on a Java Virtual Machine, or JVM for short. 
- When Java programs run on the JVM, objects are created on the heap, which is a portion of memory dedicated to the program. 
- Eventually, some objects will no longer be needed. The garbage collector finds these unused objects and deletes them to free up memory.
- While garbage collection in Java is automatic, there are instances where a programmer will want to enforce garbage collection in their programs.

[More details on Garbage Collection](https://github.com/220613-Reston-Java-Angular-AWS/Curriculum-Notes/blob/mainBackup/Week-2/Garbage_Collection.md)

## Annotations
Java [annotations](https://en.wikipedia.org/wiki/Java_annotation) are special constructs you may see throughout Java code, which use the `@` symbol followed by the name of the annotation. These annotations provide metadata about the source code to the compiler and the JVM. They can be placed on classes, methods, interfaces, and other constructs - however some annotations are restricted to only being placed on certain types or class members.

Annotations can be used to enforce rules in the code, or to abstract some functionality provided by a library or framework. Java frameworks and libraries often process annotations using the Reflection API (covered in another module) to dynamically provide functionality to developers.

Java has a few built-in annotations you should be familiar with:
* `@Override` - declares the method must override an inherited method (otherwise, a compilation error occurs)
* `@Deprecated` - marks a method as obsolete (compilation warning if used anywhere)
* `@SuppressWarnings` - instructs compiler to supress compilation warnings
* `@FunctionalInterface` - designates an interface to be a functional interface (covered in another module)

[1]: https://en.wikipedia.org/wiki/Stack_(abstract_data_type)
[2]: https://en.wikipedia.org/wiki/Heap_(data_structure)

<br>

#Thursday

## TDD - Test Driven Development
When developing software, it is important to ensure that most if not all of the code being written is tested to verify the functionality of the code. One way to ensure this is to follow a process called **test-driven development**, or TDD.

### TDD Process
The TDD process consists of writing unit tests first, **before** the application code has been written. Then, code can be written to make the test pass and the process can be completed for each piece of functionality required. Thus, the process is:
1. Write a unit test
2. Run the test => test will fail
3. Fix the test by writing application code
4. Retest until the test passes
5. Repeat

Following the TDD process can be useful for ensuring that a valid unit tests always exists for any class or method that is written. Later, when refactoring code, the unit tests give us confidence that we can change the source code without breaking existing functionality. If we mess up somewhere, when the unit tests are run we can pinpoint exactly where the problem lies. This makes debugging much easier.

## Unit Testing
Unit testing is the testing of individual software components in isolation from the rest of the system. This is done by writing unit tests which execute the code we want to inspect. When the code under test deviates from an expected outcome or behavior, the test will fail. If a test passes, it means the application performs as expected (unless there is a problem with the test itself). In Java, the most common unit testing framework is called JUnit.


## JUnit Annotations
JUnit is a Java framework for unit testing. JUnit has several annotations within the `org.junit` package that developers can use to create tests and setup test environments:
* `@Test` - declares a method as a test method
* `@BeforeClass` - declares a setup method that runs once, before all other methods in the class
* `@Before` - declares a setup method that runs before each test method
* `@After` - declares a tear-down method that runs before each test method
* `@AfterClass` - declares a tear-down method that runs once, after all other methods in the class

When writing a test method, JUnit helps us check the functionality of the code being tested by providing static `Assert` methods, of which there are many. A few include:
* `assertTrue()`
* `assertFalse()`
* `assertEquals()`
* `assertNotEquals()`
* `assertThat()`

## JUnit Assertions
Assertions verify that the state of the application meets what is expected. For example, to test a simple addition method:

```java
@Test
public void additionTest() {
  Assert.assertEquals(4, Calculator.addNumbers(2,2));
}
```

If the `.addNumbers()` method returns anything other than `4`, the test will fail. This will alert us that something is wrong in the logic of the method and we can then debug the issue. When we think we've fixed the problem, just run the test again and check that it passes.

**Note:** to avoid needing to reference `Assert` every time, we can use a `static import org.junit.Assert.*;` statement to import all `static` members of the `Assert` class.



### Ignoring Tests

To prevent a test from running, use the `@Ignore` annotation. Use this sparingly, however, because ignoring valid tests only means that you are pretending a problem does not exist. If tests are constantly ignored, you will have no guarantee that the application functionality has not regressed.


### Testing Best Practices
When it comes to testing code, a few best practices to follow include:
* [Utilize dependency injection](https://en.wikipedia.org/wiki/Dependency_injection)
* [Write testable code](https://www.toptal.com/qa/how-to-write-testable-code-and-why-it-matters)
* Use a mocking library like [Mockito](https://site.mockito.org/) for dependencies
* Measure your code coverage with a tool like [Jacoco](https://www.eclemma.org/jacoco/trunk/doc/maven.html)
* Externalize test data when possible (i.e. read in the test data from an external file or generate it dynamically)
* Generally, you want to use **only 1 assert statement per test** - this ensures you can pinpoint the defect when debugging
* Write deterministic tests (they shouldn't fail sometimes and pass other times - otherwise known as "flaky" tests)

### Summary for the Intro to TDD And Unit Testing

- When developing software, it is important to ensure that most if not all of the code being written is tested to verify the functionality of the code. One way to ensure this is to follow a process called **test-driven development**, or TDD.
- The TDD process consists of writing unit tests first, **before** the application code has been written. Then, code can be written to make the test pass and the process can be completed for each piece of functionality required. 
- Unit testing is the testing of individual software components in isolation from the rest of the system. This is done by writing unit tests which execute the code we want to inspect.


## Collections Framework
The Collections framework in Java is a set of classes and interfaces that implement commonly used data structures. A collection is a single object which acts as a container for other objects. The Collections API is organized in a class hierarchy shown in simplified version below:

![Collection API class hierarchy](https://javaconceptoftheday.com/wp-content/uploads/2014/11/CollectionHierarchy.png)

The important interfaces in the Collections API are:
* `Iterable` - guarantees the collection can be iterated over
* `List` - an ordered collection
* `Set` - a collection does not contain duplicates
* `Queue` - a collection that operates on a first-in-first-out (FIFO) basis
* `Map` - contains key/value pairs. Does not extend `Iterable`.

### Collections Class
The [Collections](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html) class - not to be confused with the Collection interface - defines many `static` helper methods which operate on any given collection. Use this class for help with sorting, searching, reversing, or performing other operations on collections.

### Types of Collections

#### List Interface
A `List` is a collection that is ordered and preserves the order in which elements are inserted into the list. Contrary to sets, duplicate entries are allowed. Also, elements are accessed by their index, which begins with 0 for the first element in the list.

##### Vector
`Vector` is an older class which implements `List` - it is essentially a thread-safe implementation of an `ArrayList`.

##### Stack
`Stack` is an older implementation of the stack data structure (last-in-first-out, or LIFO). Generally you should use an `ArrayDeque` for implementing a stack.

#### Set Interface
`Set` is an interface which defines a data structure which:
* is NOT index driven
* only allows unique elements
* generally DOES NOT preserve the order in which elements were inserted

#### Queue Interface
A `Queue` is a data structure used when elements should be added and removed in a specific order. Unless specified, elements are ordered FIFO (first-in-first-out). Some useful methods declared are:
* `offer()`
* `peek()`
* `poll()`

#### Map Interface
Map does not implement the Collection interface, however it is considered to be part of the Collections framework. It is used to identify a value by a key, and each entry in a map is a key-value pair. Because it does not implement `Iterable`, Maps cannot be iterated over directly. Instead, one must either:
* use the `entrySet()` method to iterate over the set of `Map.Entry`
* use the `keySet()` method to iterate over the set of keys
* use the `values()` method to return a `Collection` of values which can then be iterated over

##### HashMap
`HashMap` is a Map which:
* Stores elements in key-value pairs
* Insertion/Retrieval of element by key is fast
* Tradeoff is that it does not maintain the order of insertion
* Permits one null key and null values

##### TreeMap
`TreeMap` is a Map whose:
* Keys are stored in a Sorted Tree structure
* Main benefit is that keys are always in a sorted order
* Insertion/Retrieval are slow
* Cannot contain null keys as null cannot be compared for sorting

##### HashTable
`HashTable` is an older, thread-safe implementation of a `HashMap`. It does not allow null keys or null values.

