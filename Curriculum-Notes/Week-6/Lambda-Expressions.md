## Lambda Expressions
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