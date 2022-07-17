# Monday 

## Advanced Java

### Generics - Advanced
When using generics, sometimes you don't want to specify a specific type or concrete class - you may want your class to be able to accept a range of type parameters. To do this, you'll use a wildcard character, represented by a question mark `?`. The [Oracle tutorial](https://docs.oracle.com/javase/tutorial/java/generics/wildcards.html) on wildcards provides examples of how to use wildcards, along with upper and lower-bounded wildcards.

## Java 7 Features
Java 7 was released in 2011 and contains several new features that help speed development.

### `try-with-resources`
When using `try/catch` blocks, often times some object used in the code is a resource that should be closed after it is no longer needed to prevent memory leaks - for example a `FileReader`, `InputStream`, or a JDBC `Connection` object. With Java 7, we can use a `try-with-resources` block which will automatically close the resource for us:

#### Old way
```java
try {
  InputStream is = new FileInputStream("./some/file.ext");
  String s = is.read();
} catch(IOException e) {
} finally {
  is.close();
}
```

#### New way
```java
try(InputStream is = new FileInputStream("./some/file.ext")) {
  String s = is.read();
} catch(IOException e) {}
```

Whatever is placed within the parenthesis of the `try` statement will be closed automatically - thus, we don't need to explicitly call it within our `finally` block above. This new format requires the object in the `try` statement to **implement the [AutoCloseable](https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html) interface**.

### Diamond operator
Another nifty feature of Java 7 is the diamond operator - `&lt;&gt;`. To demonstrate, let's look at a line of Java code:

```java
List<String> strings = new ArrayList<String>();
```

In this one line, we've repeated the type information for the `List` in two places - on the left and right side of the assignment operation. The diamond operator simplifies this syntax by allowing the compiler to *infer* the type of the `List` from the left-hand side. The new syntax is:

```java
List<String> strings = new ArrayList<>(); // cool! less verbose
```

## Java 8 Features
Java 8 was released in 2014 and is one of the biggest updates to the language. It contains many new features that overhaul the way Java developers can write code.

### Date and Time API
Before Java 8, dates and times were represented using the `java.util.Date` and `java.util.Calendar` classes. There were several issues with these APIs, including lack of thread safety, timezones, and ease of use. Java 8 introduced a new API through the `java.time` package, which includes:
* `LocalDate` - only contains date information
* `LocalTime` - only contains time information
* `LocalDateTime` - contains a date and time
* `ZonedDateTime` - for working with time zones
* `Period` - represents a quantity of time (years, months, days)
* `Duration` - represents quantity of time (seconds, nanoseconds)
* `DateTimeFormatter` - for representing dates/times in a given format

More detailed explanations of the new Date and Time API is given in the [Javadocs](https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html).

### Lambda Expressions
Lambda expressions are one of the biggest new features of Java 8, and they introduce some important aspects of **functional programming** to Java. The most basic syntax of a lambda expression is:

```java
parameter(s) -> expression
```

For example, we can use the `.forEach` method of the `Iterable` interface, which accepts a lambda expression as its argument:

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

#### Functional Interfaces
[Functional interfaces](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html) are interfaces that **have only one abstract method**. This method is what lambdas are implementing when they are declared - the parameter types and return types of the lambda must match the functional interface method declaration. The Java 8 JDK comes with many built-in functional interfaces, listed in the Javadocs link above.

We can also use functional interfaces as types to which we can assign lambda functions, like so:

```java
interface MyFunctionalInt {
  int doMath(int number);
}

public class Execute {
  public static void main(String[] args) {
    MyFunctionalInt doubleIt = n -> n * 2;
	MyFunctionalInt subtractIt = n -> n - 2;
	int result1 = doubleIt.doMath(2);
	int result2 = subtractIt.doMath(8);
	System.out.println(result1); // 4
	System.out.println(result2); // 6
  }
}
```

### Stream API
The Java 8 [Stream API](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html) is a functional-style way of defining operations on a stream of elements. Streams are an abstraction which allow defining operations which do not modify the source data and are lazily executed. Streams **do not store data**, they simply define operations like filtering, mapping, or reducing, and can be combined with other operations and then executed. Some built-in `Stream`s are located in the `java.util.stream` package.

Streams are divided into *intermediate* and *terminal* operations. Intermediate streams return a new stream and are always lazy - they don't actually execute until a terminal operation is called. Terminal operations trigger the execution of the stream pipeline, which allows efficiency by perfoming all operations in a single pass over the data.

Finally, reduction operations take a sequence of elements and combine them into a single result. Stream classes have the `reduce()` and `collect()` methods for this purpose, with many built-in operations defined in the `Collectors` class.

```java
List<Student> students = new ArrayList<>();
// add students...
List<Double> grades = students.stream()
                          .filter(s -> s.isAttending())
						  .mapToDouble(s -> s.getGrade)
						  .collect(Collectors.toList());
```

### Optional Class
[The `Optional` class](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html) was introduced in Java 8 to reduce the need for excessive `null` value checking. An `Optional` is a kind of wrapper object which may or may not contain a value, with a few helper methods to handle existing or non-existent values (see Javadocs above).

Optionals are useful as replacements for `null` values when returning an "empty" response from a method. For example:

```java
public class OptionalExample {
  public Optional<String> getAmbiguousString(boolean b) {
    if (true) {
	  return Optional.of("awesome string!");
	} else {
	  return Optional.empty();
	}
  }
  
  public static void main(String[] args) {
    Optional<String> optString = getAmbiguousString(false);
	String theString = optString.orElse(""); // specify a fallback value
	System.out.println(theString);
	// we can use the String without fear of NullPointerException now
  }
}
```

### `default` and `static` methods in interfaces
Java 8 also adds new functionality to interfaces, by allowing interface methods to have implementations in some situations. By declaring a method as `default` in an interface, a "default" implementation of that method can be defined. The purpose of this is to allow additions to interfaces without breaking and having to change code in any of the classes which implement the interface. Thus, the `default` keyword allows updating existing interfaces in a way that is backwards compatible.

Methods can also now be declared as `static` in interfaces with an implementation. Since static methods belong to the interface, no overriding is necessary (or allowed, since it would simply be method hiding). `static` methods in interfaces are generally used as helper methods to assist with reusability of code.

The new features of interfaces in Java 8 bring them closer to the functionality of abstract classes, but there are still key differences. First, constructors are still not allowed in interfaces while they are in abstract classes. Secondly, interfaces allow for multiple inheritance while abstract classes cannot.

However, when two interfaces with `default` methods of the same method signature are implemented, the "diamond problem" - or multiple inheritance problem - can occur. The compiler will complain about duplicate default method inheritance, which can be resolved by overriding the default method with a custom implementation in the class.

<br>

# Tuesday

## Log4j

Log4j is a reliable, fast, and flexible logging framework for Java supported by Apache. It's commonly used to record application events, log granular debugging information for developers, and write exception events to files.

## Why do we need logging?
Logging records events that occur during software execution. As users execute programs on the client side, the system accumulates log entries for support teams. In general, it allows for developers to access information about applications to which we do not have direct access. Without logs, we would have no idea of knowing what went wrong when an application crashes, or track and monitor application performance.

Also, a logging framework like Log4j is critical because it allows us to use various logging levels and configure a threshold to determine which messages will be recorded in the application log files.
