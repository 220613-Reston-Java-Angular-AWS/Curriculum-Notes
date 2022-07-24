Difficulty,Question,Answer
,What is multi-threading?,Handling multiple threads / paths of execution in your program.
,In what ways can you create a thread?,By extending the Thread Class or by implementing the `Runnable` Interface. You must call Thread's `.start()` method to start it as a new thread of execution.
,Lifecycle of a thread,"When created, in NEW state.
When `.start()` is called, it goes to RUNNABLE state.
When `.run()` is called, goes to RUNNING state.
If `.sleep()` or `.wait()` is called, will go to WAITING.
If dependent on another thread to release a lock, it will go to BLOCKED state.
When finished executing, will be in DEAD state and cannot be restarted."
,What is deadlock?,"When two or more threads are waiting on locks held by the others, such that no thread can execute"

<br>
// Multiple choice: 6
// T/F: 4
// TOTAL: 10

// GUID: 89f4ff70-0acb-41e9-98c6-e2b8c1ceefd4
::Thread definition::
What is a thread? {
~A special method that executes only once
~A class which allows for more efficient and faster processing
=A representation of a path of execution, allowing for concurrent processing
~A separate program which can be run only after the end of the current program
}

// GUID: e50dace2-0085-485d-a703-45e52a03d08b
::Which of the following is NOT a virtual machine state of a thread?::
Which of the following is NOT a virtual machine state of a thread?{
~RUNNABLE
~BLOCKED
=START
~TERMINATED
~WAITING
}


::Synchronized keyword::
What is the synchronized keyword used for? 
Answer = addressing the problem of deadlock by preventing access to the resource by more than one thread at a given time
~synchronizing the execution of many separate threads so they finish execution at the same time
~preventing access to the resource from outside the class
~enabling the class to be serialized


::Thread creation - 1::
Threads can be created by... 
~passing a Thread into the constructor of Runnable: new Runnable(Thread)
Answer = passing a Runnable into the constructor of Thread: new Thread(Runnable)
~extending the Thread class and overriding the .start() method
~extending the Runnable class and overriding the .run() method



::Thread methods::
Which of the following Thread methods is used to wait for the thread to finish execution? 
Answer = Thread.join()
~Thread.sleep()
~Thread.wait()
~Thread.interrupt()
~Thread.yield()


::Deadlock::
What is deadlock? 
Answer = Deadlock occurs when one thread is waiting on a resource held by another thread, which is waiting on a resource the first has. In this scenario, execution of both threads is blocked and the program is stuck indefinitely.
~Deadlock occurs when a thread ends unexpectedly and disrupts execution of the program
~Deadlock occurs when two threads call each other and get stuck in an infinite loop
~Deadlock occurs when the program terminates before a thread can finish executing



::Thread creation - 2::
Threads can be created by extending the Runnable class.{FALSE#Runnable is an interface, not a class}


::Threads - stack and heap::
Each thread gets its own stack and heap. {FALSE # Threads receive their own stack, not their own heap}


::The run() method comes from the Thread class.::
The run() method comes from the Thread class.{FALSE#It comes from the Runnable functional interface.}


::The synchronized keyword can be used for a class.::
The synchronized keyword can be used for a class.{FALSE#It is said that a class is synchronized or thread safe if all or some of its methods are synchronized.}