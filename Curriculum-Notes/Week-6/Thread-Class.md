## Thread Class 

In Java, Multithreading is achieved via the [`Thread`](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html) class and/or the [`Runnable`](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html) interface.

### Thread methods

A few important methods in the `Thread` class include:
* getters and setters for id, name, and priority
* `interrupt()` to explicitly interrupt the thread
* `isAlive()`, `isInterrupted()` and `isDaemon()` to test the state of the thread
* `join()` to wait for the thread to finish execution
* `start()` to actually begin thread execution after instantiation

A few important `static` methods are also defined:
* `Thread.currentThread()` which returns the thread that is currently executing
* `Thread.sleep(long millis)` which causes the currently executing thread to temporarily stop for a specified number of milliseconds

### Thread Priorities
Priorities signify which order threads are to be run. The Thread class contains a few static variables for priority:

* MIN_PRIORITY = 1
* NORM_PRIORITY = 5, default
* MAX_PRIORITY = 10

## Creating Threads using `Thread` class

- Create a class that extends `Thread`
    * implement the `run()` method
    * instantiate your class
    * call the `start()` method
	
```java
	public class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("Inside the MyThread class");
		}
	}
```

```java
	public class ThreadDemo {
		public static void main(String[] args) {
			Thread myRunnable = new Thread(new MyRunnable());
			Thread myThread = new MyThread();
			myRunnable.start();
			myThread.start();
		}
	}
```






