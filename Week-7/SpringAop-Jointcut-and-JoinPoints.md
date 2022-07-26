# Spring Module - Pointcut and Join Points

This page details pointcuts and join points in Spring.

### References
* [Spring 4.0.x Documentation - Pointcuts](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/aop.html#aop-pointcuts)


## Pointcuts and Join Points
Recall the pointcuts determine join points, in that they define which methods in our application advice ought to be injected into or around, while join points are the specific moment during the execution of a program in which the advice can be taken. Though these may sound similar, you can think of the relationship between pointcuts and join points in that pointcuts determine which _methods_ in your application advice should take place and join points determine which _package or class_ that advice should take place.

Pointcuts are comprised of two parts: a name, and any parameters. Additionally, keep in mind that pointcut expression determine _exactly_ which method execution we are interested in. In Spring AOP, pointcut expressions use annotations with regular method signatures, and are indicated using the `@Pointcut` annotation. To use this annotation you must import the `org.aspectj.lang.annotation.Pointcut` class. Note that methods serving as the pointcut signature _must_ have a return type of `void`.

The Spring AOP supports the following pointcut designators:
* _execution_ - Used to match a method execution join point. This is the primary pointcut designator used. More detail on this expression can be found below.
```
@Pointcut("execution(public String getName())")
public void executionExample() {}
```
* _within_ - Limits method execution to those of a matching type.
```
@Pointcut("within(com.revature.examples.*)")
public void executionExample() {}
```
* _this_ - Limits method execution where the bean referenced is an instance of the specified type.
```
@Pointcut("this(com.revature.examples.ExampleService)")
public void executionExample() {}
```
* _target_ - Limits method execution where the target, proxied object, in an instance of a given type.
```
@Pointcut("target(com.revature.examples.ExampleService)")
public void executionExample() {}
```
* _args_ - Limits method execution where the arguments are instances of the given type.
```
@Pointcut("java.io.Serializable")
public void executionExample() {}
```
* `@target` - Limits method execution where the class of the executing boject has an annotation of the given type.
```
@Pointcut("@target(org.springframework.transaction.annotation.Transactional)")
public void executionExample() {}
```
* `@args` - Limits method execution where the runtime type of the actual arguments passed have annotations of a given type.
```
@Pointcut("@args(org.springframework.transaction.annotation.Transactional)")
public void executionExample() {}
```
* `@within` - Limits method execution within types that have a given annotation.
```
@Pointcut("@within(org.springframework.transaction.annotation.Transactional)")
public void executionExample() {}
```
* `@annotation` - Limits method execution where the join point has a given annotation.
```
@Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
public void executionExample() {}
```

## Parameter Patterns for _execution_ expression
As stated previously, the _execution_ expression is the most widely used pointcut designator. As such, it is key to understand the specific syntax for this expression:
```
execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)
            throws-pattern?)
```
Note that only the return type pattern, name pattern and parameter patterns are required. Additionally, when declaring these patterns it is possible to use wildcard indicators (*) to substitute all or parts of these patterns. As you may guess, the return type pattern indicates a specific type of data returned by the method must match in order for the join point to be matched. Often this return type will use the *, or wildcard, to specify any return type for a given method. The name pattern specifies that a name must match. Note that this name may also use a * to substitute part or all of the name for a given method. The parameters pattern is slightly more complex. () indicates a method that takes no parameters, whereas (..) specifies a method with any number of parameters (zero or more). The wildcard * specifies the type of parameter, while listing the specific type requires the type to match at that parameter index. For instance: (*,String) matches methods which take two parameters, the first can be any type, while the second must be a String.

```
execution(public String getName())
```
This point cut specifies a public method (note this `public` access modifier is optional) named _getName_ that returns String data.

```
execution(public * getName())
```
This pointcut specifies any public method that returns any type of data, so long as the method is named _getName_.

```
execution(* get*())
```
Here, the pointcut matches a method of any return type whose name begins with '_get_'

```
execution(* set*(*))
```
This pointcut matches methods whose name begins with '_set_' which take one argument of any type

```
execution(void com.revature.*.set*(..))
```
Note that you can also use fully qualified type names, and wildcards for these names as well. This pointcut matches any method who name begins with '_set_' (which returns void) within any package from com.revature (such as com.revature.service, com.revature.dao, com.revature.examples, etc...), and can take any number of parameters.