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
