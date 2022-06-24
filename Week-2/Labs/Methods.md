# Methods

## Objectives

* Explore how to write simple methods.
    
## Background

In this exercise, you'll practice writing a simple **method** in your class. In previous lessons, you may have written code that exists directly in the `main` method. As you know, when you execute a class, the starting point is that class's `main` method. If you want any code to execute it will need to eventually link back to some code that was invoked in `main`.

The benefit of writing a method is that it acts as a container for code. 

In this lab, we'll walk you through writing a method in your class and how to _call_ it from the `main` method.

> The terms _invoke_ and _execute_ are used interchangeably with the term _call_ in relation to running a method. 


### Components of a Method
A method has several parts:

*   modifier
*   return\_type
*   methodName
*   parameters
*   exceptions
*   method body
    

Methods follow the following syntax:

```java
modifier return_type methodName(parameters) exceptions {
    //method body 
}
```

#### Modifier

The modifier controls which classes can access the method.

There are four levels of control. There is the default level and 3 others specified by the keywords **public**, **private**, and  **protected**.

#### Return Type

The _return type_ is a specified data type that your method will provide back to code invoking it. A return type can be any primitive type (`boolean`, `int`, `char`, etc.) or object type. If your method doesn't return anything, you'll use the **void** keyword.

#### Method Naming Rules

Methods are defined with a specified name. There are a few rules that you should follow when writing a name for a method:

* reserved keywords cannot be used. 
* names cannot start with a digit.  
  * digits can be used after the first character (e.g., n11, n22e are valid method names).   
* names must start with a letter, an underscore (i.e., "\_") or a dollar sign (i.e., "$").   
* names cannot use other symbols or spaces (e.g., "%","^","&","#").
    
#### Parameters

**Parameters** are input values that your method can accept. You can have any number of parameters that you like. 

> A good rule of thumb though, is if your parameter list is very long (above 10 items), then there is probably an easier way to write your method.

To declare a parameter you'll specify the datatype and a name for your parameter. The same rules that apply to variable names apply to parameter names.

#### Exceptions

If your method throws any exceptions then they'll be listed here.

> Exceptions are an entire topic that is outside of the scope of this lesson.

#### Method Body

This is the main portion of your method that determines what it actually does. All methods should have an opening and closing curly brace to indicate the start and end of the method body. The body is just a line or several lines of code to execute whenever this method is called or invoked.

## Guided Practice

Now that you have some background on the basics of methods, let's write a few together. 

### Project Setup

1. Open your IDE (Eclipse), and select File > New > Java Project.
2. Provide the name, Lab-Method and click **Finish**.
   a. If a module dialog appears asking to create a module, then click **Don't Create**. 
3. Right-click on the newly created project and select New > Class.
4. Provide the class the name, _MethodDeclaration_ and click OK.
5. Now edit the file so that it looks like the following:

```java
public class MethodDeclaration{

    public static void main(String[] args) {
        //create a class instance

        //call your first method here
    }

    //create your first method here
}
```

### Creating a Method

Next we'll create a method in our class. We'll provide the name _talk_ for the method. It will be `public`, return nothing (so specify the `void` keyword), and declare no parameters or exceptions:

```java
public void talk(){
    
}
```

As part of our method body, we can declare a simple `print` statement to display "Inside of the talk method" to the console.

```java
public void talk(){
    System.out.println("Inside of the talk method");
}
```

Great! With the above code you have now created a method.

### Invoking a Method

One question still remains. How do we call or invoke our `talk` method? 

We'll first have to create an instance of a class. Using this class we'll later invoke our method. 

```java
public class MethodDeclaration{

    public static void main(String[] args) {
        //create a class instance
        MethodDeclaration md = new MethodDeclaration();
    }

    //create your first method here
    public void talk(){
        System.out.println("Inside of the talk method");
    }
}
```

> We can create an instance of a class from within its own method. In this case we create an instance within the `main` method and label the reference variable `md`. 

Now that we have an instance to work with, we can _call_ our method.

In order to do so, you'll use the reference variable name `md` and then use the **dot operator** followed by the name of the method and a set of parentheses. 

> Recall that the **dot operator** is used whenever you want to execute a method on an object. You first specify a variable name, a period, and then the name of the method. 

```java
public class MethodDeclaration{

    public static void main(String[] args) {
        //create a class instance
        MethodDeclaration md = new MethodDeclaration();

        //call your first method here
        md.talk();
    }

    //create your first method here
    public void talk(){
        System.out.println("Inside of the talk method");
    }
}
```

Notice that because `talk` is a method, we specify a pair of parentheses after the name in order to invoke it. It would be erroneous to write `md.talk;` as this is how a property is accessed and not how to invoke a method.

Run the program. You'll see the output of the program.

![Results of MethodDeclaration execution](images/image-1.png)

Notice that our program displays the phrase of our `talk` method on the console. This indicates that our program successfully transferred program control from `main` to `talk` and executed all lines within `talk`. 

Congratulations. You've successfully written and invoked a method. 

One benefit of organizing code within methods is that a method can be invoked as many times as you need and simplifies the calling method. 

For example, say we needed to invoke the method 3 times. We could update `main` as follows:

```java
public static void main(String[] args){
    //create a class instance
    MethodDeclaration md = new MethodDeclaration();

    //call your first method here
    md.talk();
    md.talk();
    md.talk();
}
```

This way our program contains useful functionality inside of methods that you can create and invoke as often as you need. 

This concludes this lab.