## States of a Thread 

At any given time, a thread can be in one of these states:
1. **New**: newly created thread that has not started executing
2. **Runnable**: either running or ready for execution but waiting for its resource allocation
3. **Blocked**: waiting to acquire a monitor lock to enter or re-enter a synchronized block/method
4. **Waiting**: waiting for some other thread to perform an action without any time limit
5. **Timed_Waiting**: waiting for some other thread to perform a specific action for a specified time period
6. **Terminated**: has completed its execution


**Click on the picture to see it clearer*

![Thread lifecycle](https://www.javatpoint.com/images/thread-life-cycle.png)

