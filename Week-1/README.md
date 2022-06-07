# Object-Oriented Prgramming (OOP)

Object-Oriented Programming is a programming paradigm based on the concept of objects, which can contain data and code. Data in the form of fields (AKA variables, attributes, properties), and code in the form of procedures (AKA functions, methods). In Java we call the data **fields** and the procedures **methods**. There are four main principles that are often used to describe object-oriented programming and provide guidance. 

### The 4 Pillars of OOP
 - Encapsulation
 - Abstraction 
 - Inheritance
 - Polymorphism

## Encapsulation
Encapsulation is the idea of combining data and behavior into a single logical unit, the class. The concept also includes hiding and preventing changes to class members, as an encapsulated object should control access to it's own internal state. This is very similar to some of the concepts behind **Abstraction** but the two should not be confused. Abstraction can be seen as a sort of extension to the concept of encapsulation. Encapsulation is about bundling fields and methods into a single object, and restricting access to the internals of that object so that the object itself is in charge of it's state.
  
## Abstraction
Abstraction is a principle in which we hide underlying complexity and expose a simplified interface. Consider a TV, We can turn volume up or down, change the channel, power it on and off, but we never know the inner workings of the TV that makes this possible. We don't care how the images are displayed nor how the functions work, these thigns are abstracted away from us. Instead we simply interface with the TV by pushing buttons on the remote. 
  
## Inheritance
Inheritance is the ability of an entity acquiring some or all of the data and behaviors of another entity. In Java these entities are classes, and child classes inherit from a parent class. These are also sometimes called "base class" or "super class" and "sub-class". In Java all non-private fields and methods are inherited by a child class using the `extends` keyword. In Java, you can only inherit from a single parent class. 
  
The benefit of inheritance is mainly re-use of code. Rather than re-invent the wheel every time, we can re-use an existing class and alter some of it's behavior to suit a new purpose.
  
## Polymorphism
Polymorphism is the most difficult pillar to conceptualize. By definition, polymorphism means "taking on many forms". In the realm of programming, it describes how objects can behave differently in different contexts. The most common examples of polymorphism in Java are method [overloading and overriding](./java-fundamentals.md#overloading).

<br>

# Introduction to Java
Java is a high-level, class-based, object-oriented, programming language that is designed to have as few implementation dependencies as possible. 
 - **high level** - No direct memory management, abstracted away from hardware
 - **class based** - Everything written is inside a class, inheritance based on class
 - **object oriented** - Bundle data and behavior into a single logical unit, the class. (Encapsulation)

Java is a general-purpose programming language intended to let developers ***write once, run anywhere***. Compiled Java code can run on any **Java Virtual Machine (JVM)** regardless of the hardware and software environment.  
  
Java is a C derivative, which means its syntax is similar to that of C/C++. While Java has fewer low-level features such as direct memory access, it has high-level features C and C++ lack, such as reflection.  
  
## JVM, JRE, JDK
Java is write once, run anywhere (WORA) thanks to the JVM. Java code is compiled into **bytecode**, which are instructions the JVM understands. The JVM is specific to the operating system - there is a JVM for Windows, one for Mac, one for Linux, etc. The JVM reads the compiled Java bytecode and translates it to machine code to be executed on the given system.
  
In order to run Java code on a machine, the **JRE** or **Java Runtime Environment** is also required. The JRE contains all the runtime libraries that your code will be using. The JRE includes the JVM. When users talk about "installing Java" this usually refers to installing the JRE. In order to run Java applications, all you need is the JRE.
  
To develop Java applications you need the **JDK**, or **Java Development Kit**. The JDK provides developer tools like a compiler, debugger, documentation tools (javadoc), and other command-line utilities. The JDK also includes the JRE, and by extension the JVM, so when you write your code you can compile and run it as well. 
  
  
<div align="center"><img src="./../Documents/JDK_JRE_JVM.PNG"> </div>
  
  
So, to recap - the JDK contains tools for Java development as well as a JRE, which contains the built-in Java libraries as well as a JVM, which actually executes our Java bytecode and runs it on the specific operating system it is installed upon.


