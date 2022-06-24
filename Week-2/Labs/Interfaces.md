# Interfaces

## Objectives

*   Code an interface and an implementing class
    
## Background

An interface defines a new construct similar to a class. Likewise, they create a form of inheritance where an interface can be labeled as the parent class and an implementation can be a child class. 

Interfaces, however, are limited in the variables and types of methods they can define, and as a result this form of inheritance relationship differs in important ways from classes. 

By defining an interface you are creating a type of contract.

> When a class implements an interface, it must adhere to the outline of the interface. In other words, it must provide an implementation for methods outlined in the interface. 

An interface typically outlines some number of abstract methods as depicted below:

```java
public interface Abstractor {
    String computeOutput(..);
}
```
> Note that all interface methods are implicitly `public` and `abstract`.

If you want to implement this interface in a class, then you would have to provide an implementation for the inherited abstract method `computeOutput()`.

```java
public Class ComplexClass implements Abstractor{

    //instance variables
    ...

    //methods
    ...

    public String computeOutput(..){
        //provide an implementation that can use other
        //methods and performs any operations
        ...
    }
}
```

## Guided Practice

Below we will set up a new project to guide you through creating and implementing an interface. 

### Project Setup

1.  Open your IDE (IntelliJ), and select File > New > Project.
    
2.  Provide the name, **Lab-Interfaces** and click OK. 
    \
    
3.  Right-click on the newly created project and select New > Package.

4.  Provide the name com.example.model for your package. 
    
5.  Right-click on the newly created package and select New > Class.
    
6.  Create the following classes in this package (`com.example.model`)
    

Mammal Class
```java
package com.example.model;

public class Mammal{

}
```

Whale Class
```java
package com.example.model;

public class Whale extends Mammal{

}
```

In the above, we defined an inheritance hierarchy between the class `Mammal` and `Whale`. They are empty classes that we'll later use to tie in the use of an interface. 

Now let's say that we want to expand our program and we need a lot of pieces that will rely on the ability of an animal to be a *swimmer*. In order, to be considered a *swimmer* all an animal needs to do is to be able to *swim*. 

This is the perfect use case for an interface. 

### Defining an Interface

Right-click on your project and select New > Interface.


Provide the name Swimmer. 


Eclipse will generate the interface that should resemble the following:

```java
package com.example.model;

public interface Swimmer {

}
```

Recall that to be a Swimmer, the object must be able to *swim*, so we will outline that method. 

> We will not provide an implementation for the method, as interface methods are abstract. Later you will find a workaround for this by using `default` or `static` methods.

Edit your code so that it looks like the following:
```java
package com.example.model;

public interface Swimmer {
    void swim(); 
}
```
Let's say that we want the Whale class to be considered a Swimmer. In order to do so, update the Whale class to implement this interface by using the `implements` keyword. 

```java
package com.example.model;

public class Whale extends Mammal implements Swimmer{

}
```

Notice that IntelliJ will underline our Whale class in red. Hover your mouse over it to see the compiler message:



It says that our class needs to implement the `swim()` method.

Right. We're getting to that.

As a shortcut, click on the first suggestion in the quick fixes area **Add unimplemented methods**.

If you scroll down, you'll see that IntelliJ added a default (empty) implementation for us:


> Notice the `@Override` annotation. This is an annotation used by the compiler to check that the method exists on a super class or interface that is declared somewhere in the class's hierarchy. If none exists, it will generate a compiler error. Note that this annotation is not needed to override a method, it exists only as a safety check.

Edit that method to be the following:

```java
@Override
public void swim() {
    System.out.println("Swim swim swim");
}
```

Great. Now we've implemented our interface.

As a last task, we need to write a test class to check how this works.

Create a new class `TestSwimmer` under a new package `com.example.test`.Edit the file to be the following:

```java
package com.example.test;

import com.example.model.Whale;
import com.example.model.Swimmer;

public class TestSwimmer {

    public static void main(String[] args) {
        Swimmer beluga;
        beluga = new Whale(); 
        beluga.swim(); 
    }
}
```

>We can assign and instance of the Whale class to our Swimmer reference variable due to the IS-A relationship between them. Remember Whale _implements_ Swimmer.  

Run the program.

You'll observe the following output:


Everything works great! And "Swim swim swim" prints successfully to the console.

### Default Methods

Now imagine that all Swimmer objects should also be able to dive. 

Well then we would go back to our interface and outline the *dive* method. 

Edit your interface to resemble the following:

```java
package com.example.model;

public interface Swimmer {
    void swim(); 
    void dive(); 
}
```
You will notice an error appear on the implementing Whale class. 


Of course, now Whale is inheriting an abstract method once again. 

To fix this we could simply edit Whale, but what if we had implemented Swimmer in a hundred different classes? 

This is where `default` methods come into play. They allow us to provide a default implementation to methods in an interface and they should be used specifically to add to previously implemented interfaces. 

Edit `Swimmer` to look like this.

```java
package com.example.model;

public interface Swimmer {
    void swim(); 
    default void dive(){
        System.out.println("Diving"); 
    }
}
```
> When a method is `default`, a method body should be present.

Notice the error disappears in Whale. 

Now we can test this in the TestSwimmer class. Edit the TestSwimmer class to match the following:
```java
package com.example.test;

import com.example.model.Swimmer;
import com.example.model.Whale;

public class TestSwimmer {
	public static void main(String[] args) {
		Swimmer beluga;
        beluga = new Whale();
		beluga.swim();
		beluga.dive();
	}

}
```
swim swim swim
<br>
Diving

Excellent.

### Defining Variables and Static Methods

We can also use interfaces to define public static variables and public static methods. 

Edit your interface to resemble the following. 
```java
package com.example.model;

public interface Swimmer {
	int NUMBER_OF_FEET_IN_A_LEAGUE = 18_228;
	
	void swim();
	default void dive() {
		System.out.println("Diving");
	}
	
	static int convertFromFeetToLeagues(int feet) {
		return feet/NUMBER_OF_FEET_IN_A_LEAGUE; 
	}
}
```

Then edit your TestSwimmer class to resemble:
```java
package com.example.test;

import com.example.model.Swimmer;
import com.example.model.Whale;

public class TestSwimmer {
	public static void main(String[] args) {
		Swimmer beluga;
        beluga = new Whale();
		beluga.swim();
		beluga.dive();
		
		System.out.println("There are "+Swimmer.NUMBER_OF_FEET_IN_A_LEAGUE+" in a league.");
		
		int feetTraveled = 80_000;
		System.out.println("So if the whales went "+feetTraveled+" feet, they "
				+ "would have gone "+ Swimmer.convertFromFeetToLeagues(feetTraveled)+" leagues.");
	}

}
```

Notice that we access our static variable and method via Swimmer, the interface, and not through `beluga`, the reference variable. 

When you run this, you should see:

There are 18228 in a league
So if the whales went 80000 feet they would have gone 4 leagues

### Summary

As a quick recap, the point of this exercise was to demonstrate the usage of interfaces. 

* You define an interface by using the keyword `interface`. 
* You typically leave off implementations for any listed methods unless they are `default` or `static`. 
* You can also create variables (that are implicitly `public` and `static`) on interfaces.

This concludes the lab.
