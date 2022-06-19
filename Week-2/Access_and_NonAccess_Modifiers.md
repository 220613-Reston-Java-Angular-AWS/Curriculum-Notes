
##Access & Non-Access Modifiers

There are four access modifiers in Java:
- `public`: Available anywhere
- `private`: Access within the same package and the class's subclasses
- `default`: Access within the same package.
- `protected`: Access only within the same class.

These modifiers help determine what files in the application have access to the classes, methods, or fields in a class, method, or field.

Java also has **non-access** modifiers which can be placed on various class members:
- `static` - denotes "class" scope, meaning the member resides on the class itself, not object instances.
  - `static` variables can be accessed through the class, e.g. `MyClass.staticVariable`
  - `static` methods can be called directly without needing an instance of the class, e.g. `MyClass.someMethod()`
- `final`
  - when applied to a variable, it means the variable **cannot be re-assigned**
  - when applied to a class, it means the class **cannot be extended**
  - when applied to a method, it means the method **cannot be overriden**
- `abstract`
  - when applied to a class, the class **cannot be instantiated** directly (instead, it should be *inherited*)
  - when applied to a method, only the method signature is defined, not the implementation. Also, the class where the method resides must also be abstract. Concrete subclasses **must implement the abstract method**.
- `synchronized` - relevant to threads and preventing deadlock phenomena (discussed in a separate module)
- `transient` - marks a variables as non-serializable, meaning it will not be persisted when written to a byte stream (discussed in another module)
- `volatile` - marks a variable to never be cached thread-locally. Obscure, rarely-used keyword.
- `strictfp` - restricts floating point calculations for portability. Obscure, rarely-used keyword.
