# Description for the Stack and Heap topic

  - To run an application in an optimal way, JVM divides memory into stack and heap memory. Whenever we declare new variables and objects, call a new method, declare a String, or perform similar operations, JVM designates memory to these operations from either Stack Memory or Heap Space.
  - In this tutorial, we'll examine these memory models. First, we'll explore their key features. Then we'll learn how they are stored in RAM, and where to use them. Finally, we'll discuss the key differences between them.

### Stack Memory in Java

- Introduction
  - Stack Memory in Java is used for static memory allocation and the execution of a thread. It contains primitive values that are specific to a method and references to objects referred from the method that are in a heap.
  - Access to this memory is in Last-In-First-Out (LIFO) order. Whenever we call a new method, a new block is created on top of the stack which contains values specific to that method, like primitive variables and references to objects.
  - When the method finishes execution, its corresponding stack frame is flushed, the flow goes back to the calling method, and space becomes available for the next method.

- Key Features of Stack Memory
  - It grows and shrinks as new methods are called and returned, respectively.
  - Variables inside the stack exist only as long as the method that created them is running.
  - It's automatically allocated and deallocated when the method finishes execution.
  - If this memory is full, Java throws java.lang.StackOverFlowError.
  - Access to this memory is fast when compared to heap memory.
  - This memory is threadsafe, as each thread operates in its own stack.

### Heap Space in Java
- Introduction
  - Heap space is used for the dynamic memory allocation of Java objects and JRE classes at runtime. New objects are always created in heap space, and the references to these objects are stored in stack memory.
  - These objects have global access and we can access them from anywhere in the application.
- We can break this memory model down into smaller parts, called generations, which are:
  - Young Generation – this is where all new objects are allocated and aged. A minor Garbage collection occurs when this fills up.
  - Old or Tenured Generation – this is where long surviving objects are stored. When objects are stored in the Young Generation, a threshold for the object's age is set, and when that threshold is reached, the object is moved to the old generation.
  - Permanent Generation – this consists of JVM metadata for the runtime classes and application methods.
- Key Features of Java Heap Memory
  - Some other features of heap space include:
  - It's accessed via complex memory management techniques that include the Young Generation, Old or Tenured Generation, and Permanent Generation.
  - If heap space is full, Java throws java.lang.OutOfMemoryError.
  - Access to this memory is comparatively slower than stack memory
  - This memory, in contrast to stack, isn't automatically deallocated. It needs Garbage Collector to free up unused objects so as to keep the efficiency of the memory usage.
  - Unlike stack, a heap isn't threadsafe and needs to be guarded by properly synchronizing the code.

* Source: https://www.baeldung.com/java-stack-heap