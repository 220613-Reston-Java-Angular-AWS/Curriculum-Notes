## Runnable Interface

In Java, Multithreading is achieved via the [`Thread`](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html) class and/or the [`Runnable`](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html) interface.

`java.lang.Runnable` is an interface that is to be implemented by a class whose instances are intended to be executed by a thread.


### Creating Threads using `Runnable` Interface

- Create a class that implements the `Runnable` functional interface
	* implement the `run()` method
	* pass an instance of your class to a `Thread` constructor
	* call the `start()` method on the thread
	
```java
	public class MyRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("Inside the MyRunnable class");
		}
	}
```

### Runnable and Lambda Expressions
Because `Runnable` is a *functional* interface, we can use a lambda expression to define thread behavior inline instead of implementing the interface in a separate class. We pass a lambda expression as the `Runnable` type required in the `Thread` constructor. For example:

```java
public class ThreadLambda {
  public static main(String[] args) {
    Thread willRun = new Thread(() -> {
	  System.out.println("Running!");
	});
	willRun.start();
  }
}
```