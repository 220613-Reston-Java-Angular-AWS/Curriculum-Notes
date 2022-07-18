# Variable Scopes

- A variable is a container which holds the value while the Java program is executed. A variable is assigned with a data type.
- A variable is also the name of memory location. There are three types of variables in java: local, instance and static.
  - Local Variable
    - A variable declared inside the body of the method is called local variable. 
    - You can use this variable only within that method and the other methods in the class aren't even aware that the variable exists.
    - A local variable cannot be defined with "static" keyword.
  - Instance Variable
    - A variable declared inside the class but outside the body of the method, is called an instance variable. It is not declared as static.
    - It is called an instance variable because its value is instance-specific and is not shared among instances
  - Static variable
    - A variable that is declared as static is called a static variable. 
    - It cannot be local. 
    - You can create a single copy of the static variable and share it among all the instances of the class. 
    - Memory allocation for static variables happens only once when the class is loaded in the memory.

### Variable scopes
When a variable is declared in a Java program, it is attached to a specific **scope** within the program, which determines where the variable resides. The different **scopes of a variable** in Java are:
* Instance, or object, scope
* Class, or static, scope
* Method scope
* Block scope

Instance scope means that the variable is attached to individual objects created from the class. When an instance-scoped variable is modified, it has no effect on other, distinct objects of the same class.

Class scoped variables reside on the class definition itself. This means that when objects update a class-scoped variable, the change is reflected across all instances of the class. Class scope is declared with the `static` keyword. Methods can also be declared as class scope. However, `static` methods cannot invoke instance methods or variables (think about it: which specific object would they reference?). Static methods and variables should be referenced through the class directly, not through an object. For example: `MyClass.myStaticMethod()` or `MyClass.myStaticVariable`.

Method scope is the scope of a variable declared within a method block, whether static or instance. Method-scoped variables are only available within the method they are declared; they do not exist after the method finishes execution (the stack frame is popped from the stack and removed from memory after execution).

Block scoped variables only exist within the specific control flow block, of which there are several in Java: `for`, `while`, and `do-while` loops, `if/else-if/else` blocks, `switch` cases, or even just regular blocks of code declared via curly braces (`{}`). After the block ends, variables declared within it are no longer available.

* Source: https://www.javatpoint.com/java-variables