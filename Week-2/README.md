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

