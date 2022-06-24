# Notes

## Vocabulary

- `Static` means that the method (field) IS shared amongst all instances of the class.

### Variable Scopes

1. `Instance` (object) : attached to individual objects created from the class.
* When an instance-scoped variable is modified, it has no effect on other, distinct objects of the same class.

2. `Class` (static) : apply to the class type itself.
* When a class-scope variable is changed, the change is reflected (can be seen) across all instances of t+he class.
<br>--> Methods can also be declared `static` as class scope. They cannot invoke instance methods or variables, as they should be referenced through the class directly, not through an object.

3. `Method` : declared within a method, which can be static or instance. Only available within the method they are declared within and do not exist after the method finishes execution in the code.

4. `Block` : only exist within the specific control flow block. (i.e. `for`, `while`, and `do-while` loops; `if/else-if/else` blocks; `switch` cases; regular code within curly braces (`{}`) ) These variables are no longer available once the block ends.

### Access // Non-Access Modifiers
1. Access
- `public` : accessible everywhere
- `private` : accessible within the same package and the class' subclasses (inherited classes)
- `default` : accessible within the same package 
- `protected` : accessible ONLY within the same package

2. Non-Access
- `static` : class scope; object resides in the class itself, not the object instance
<br>
--> Variables can be accessed through the class.
--> Methods can be called without being instantiated in the class.
- `final` : **VARIABLE CANNOT BE REASSIGNED; CLASS CANNOT BE EXTENDED; METHOD CANNOT BE OVERRIDEN**
- `abstract` : Class **cannot** be instantiated **directly**, but should be *inherited*. If applied to a method, only the method signature is defined, not the implementation. (The class where the method is located must also be abstract.)
<br>
--> Concrete subclasses **MUST IMPLEMENT THE ABSTRACT METHOD**.
- `synchronized` : relevant to threads and prevents deadlock phenomena
- `transient` : variables are non-serializable, meaning they will not persist when written into a byte stream
- `volatile` : variables are never to be cached thread-locally **(OBSCURE, RARELY-USED KEYWORD)**
- `strictfp` : restricts floating point calculations for portability **(OBSCURE, RARELY-USED KEYWORD)**