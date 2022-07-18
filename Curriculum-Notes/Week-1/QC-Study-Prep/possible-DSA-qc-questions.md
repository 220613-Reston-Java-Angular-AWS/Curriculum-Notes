 ## DS&A - QC Questions

## DS&A
* What is time complexity?
    + The amount of time taken by an algorithm to run, as a function of the length of the input. It measures the time taken to execute each statement of code in an algorithm
* What is space complexity?
    + Measures the total amount of memory an algorithm or operation needs to run according to its input size
* What are data structures?
    - Is used to organize, manage and store data
    - Enables efficient access and modification when applied correctly to a specific situation/problem 
* What is an algorithm?
    - Is a set of instructions for solving a problem 
    - One example would be a recipe, it tells us how to create a dish, and what ingredients we would need
* What is Big O notation?
    - Is a way developers can use to analyze the running time of algorithms
* Explain the concept of Brute Force?
    - Systematically checking for all possible solutions through an exhaustive search 
* What are some benefits to Brute Force?
    - Allows us to reach the solution faster if we do not know about the correct data structure to solve the problem in the most efficient manner
    - Generally the first thing that comes to mind when solving coding challenges so it's simply the easiest go-to solution
* What are some downsides to Brute Force?
    - May not be the most optimal solution to a certain problem in the majority of cases
    - May easily run out of time due to the exhaustive search nature, brute force would have to check against all values which is time consuming, with problems that have runtime constraints this would not be ideal
* Explain the concept of Binary Search?
    + Search a sorted array by repeatedly dividing the search interval in half
    + If x is less than the item in the middle, look for the left half
    + If x is higher than mid, then we look at the right 
* What is the time complexity of Binary Search?
    + O(log n)
* What issues might implementing Binary Search have in Java?
    + m = (l + r) / 2
    + Sum overflows to a negative value, it stays negative when divided by two
    + Solve doing:
        + m = l + (( r - l) / 2)
        + M = (l + r) >>> 1;
        + Unsigned right bit-shift op in Java
* Can you tell me the time complexity of this piece of code?
    ```java
    public int fibo(int n) {
        System.out.println("Calling fibonaccis with input: " + n);
        if (n < 2) {
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
    ```
    + Recursive solution, time complexity is O(2 <sup> n </sup>)
* What is a linked list?
    + Linear data structure, in which elements are not stored at contiguous memory locations
    + Elements are linked using pointers 
    + Linked lists are dynamic meaning that they can increase or decrease in size
* What is a single linked list?
    + Defined as all nodes are linked together in a few sequential manner, hence it is also known as a linear linked list
    + Clearly is has the beginning and the end. 
    + Main problem is that we cannot access the predecessor of the node from the current node
* What are some advantages of a singly linked list?
    + Insertions and deletions can be done easily in O(1) time
    + Space is not wasted as we can get space according to our requirements
* what are some disadvantages of a singly linked list?
    + Accessing the preceding node of a current node is not possible as there is no backward traversal
    + If we have to go to a particular element then we have to go through all those elements that come before that element in O(n) time
    + We cannot traverse it starting from the end node, we can only do so from the beginning first node
* What is a double linked list?
    + Similar to a linked list but here each node has an extra pointer that stores the address of the previous node 
    + Internally, the `java.util.LinkedList` is implemented using a Doubly Linked List Data Structure
* What are some advantages to a Doubly Linked List?
    + Allows us to iterate in both directions
    + We can delete a node easily as we have access to its previous node
    + Reversing is easy
* What are some disadvantages to a Doubly Linked List?
    + Compared to a singly linked list, each node stores an extra pointer which consumes extra memory
    + Operations require more time due to the overhead of handling extra pointers as compared to singly-linked lists
* Where would we use Linked Lists/Doubly Linked Lists?
    + Can be used to implement various data structures like hash-tables, stacks, binary trees etc.
    - Can be used to implement functionalities such as undo/redo
    - Used by a thread scheduler in many OS to maintain a list of all running processes
    - Can also be used in games e.g. representing a deck of cards
    - Can be used in any software that requires forward and backward navigation e.g. music players, in web-browsers to move between previously visited and current page etc.
* What is Merge Sort?
    + Uses the `divide and conquer` strategy for sorting elements in an array 
    + Recursively breaking down a problem into 2 or more sub-problems of the same or related type
* What is the time complexity of Merge Sort?
    - Runtime is O(n log n) which is much faster and requires less operations than Insertion or Selection Sort O(n<sup>2</sup>)
* What is a Heap?
    - Is a special type of tree where the tree is a complete binary tree
    - Generally 2 types of heap:
        - Max-Heap:
            - The root node must be the greatest among all of the elements present within the tree and all of the sub-nodes must also be larger than their children 
        - Min-Heap:
            - The root node must be the smallest among all the elements in the tree and all of the sub-nodes must also be smaller than their children
* What is Heap Sort?
    + Eliminate the elements one by one from the heap part of the list, and then insert them into the sorted part of the list
* How does heap sort work?
    - 2 phases
        - First step includes the creation of a heap by adjusting the elements of the array
        - Remove the root element of the heap repeatedly by shifting it to the end of the array
        - Store the heap structure with the remaining elements
* What is the worst case time complexity for heap sort? Why?
    - O(n log n)
    - Occurs when the array elements are required to be sorted in reverse order
    - E.g. You have to sort in ascending order but its elements are in descending order
* What is a map?
    - Has a key value pair and allows for fast look up for the value if the key is known
* What are some real world uses for maps?
    - A map of the zip code and cities
    - A map of regions and the countries in each region
* Can maps contain duplicate keys?
    - No, each key can only be mapped to 1 value
* Do maps allow for null keys and null values?
    - Specific implmentations allow it such as HashMap and LinkedHashMap
    - TreeMap does not support null keys and null values
* What is Insertion Sort?
    - The array is split into a sorted and unsorted part, values from the unsorted part are picked and placed in the correct position in the sorted part
* What is the time complexity of Insertion Sort?
    - O(n<sup> 2 </sup>)
* What is Selection Sort?
    + We are repeatedly finding the minimum element from unsorted part and putting it at the beginning
    - We have 2 subarrays in 1 array
    - 1 subarray is sorted while the other remains unsorted
* What is the time complexity for Selection Sort?
    - O(n<sup>2</sup>)
* What is a benefit of Selection Sort?
    - It never makes more than O(n) swaps
    - Useful when memory writes are a costly operation
* What is Bubble Sort?
    - Swaps adjacent elements repeatedly if they are in the wrong order
* What are some downsides to Bubble Sort?
    - The algorithm needs 1 whole extra pass to know if the array is sorted even after the array is done being sorted
* What is a stack?
    - Linear data type with a predefined capacity or boundary
    - Last In First Out (LIFO) or First In Last Out (FILO) ordering
* What are some benefits of using stacks?
    - Implement functions, parsers, expression evaluation, and some algorithms
    - Great for processing nested structures
* What would be a simple real-world application of a stack?
    - Reversing a string letter by letter
    - Undo and redo function on a computer or text editor
* What is a queue?
    - Linear structure that follows a First In First Out (FIFO) order
    - Queues open from both ends
        - One end for inserting data (enqueue), and the other for removing data (dequeue)
    - Stack is only open from one end
* What is a deque?
    - Elements can be added or removed from either the front or back of the queue
    - Short for double ended queue
* When would we want to use a linked list over an ArrayList?
    + When we have a ton of insertions and deletions
    + Linkedlist insertion/deletion is O(1) while ArrayList insertion/deletion is O(n)
* What is recursion?
    - Occurs when a method invokes itself
    ```java
    public static void foo() {
        foo();
    }
    ```
    - The above will keep calling itself and adding 1 frame on top of another in the stack until we reach a StackOverflowError so we must add a condition for the method to be invoked
    ```java
    public static void reduceByOne(int n) {
        if (n >= 0) {
            reduceByOne(n-1);
        }
        System.out.println("Completed Call: " + n);
    }
    ```
* What are Greedy Algorithms?
    - Each small piece of the puzzle will provide an immediate output but generally does not consider the larger picture for the problem
    - Works recursively to construct a set of objects from the smallest possible pieces 
    - Mainly used for solving optimization problems
* What are some characteristics of Greedy Algorithms?
    - Creates 2 sets, one set contains all the chosen items, and another set contains the rejected items
    - Makes good local choices at every step in hope that the solution will either be feasible or optimal
* What type of situations would Greedy Algorithms be used for? 
    - Used to find the shortest path
    - Used to find the minimum spanning tree using the prim's algorithm or the Kruskal's algorithm
    - Used to solve the fractional knapsack problem
* What are some downsides of Greedy Algorithm?
    - Since it makes decisions based on the available information at each phase without considering the whole problem, there may be a possibility that the greedy solution does not yield the best solution for said problem
* What is a set?
    - Stores unordered elements 
    - Cannot contain duplicate elements
* What is a Hash Set?
    - Hash set stores the elements by using a mechanism called hashing
    - HashSet contains unique elements only
    - HashSet allows null values
    - HashSet is non-synchronized
* What is a tree?
    - The data structure is shaped like a tree
    - Each data element is stored in a node, all nodes are connected to each other in a hierarchical fashion
* Where would trees be useful?
    - Creating a family tree
* What is a graph?
    - A non-linear data structure consisting of nodes and edges
    - Nodes are sometimes also referred to as vertices
    - Edges are just lines or arcs that connect any 2 nodes in the graph
* What types of real world applications would we see graphs being implemented?
    - Commonly used in social networks like linkedIn, Facebook
    - Each person is represented with a node, each node is a structure and contains info such as a person's id, name, gender, locale, etc.
* What is Breadth First Search?
    - A graph traversal algorithm
    - Very similar to a binary tree
    - We use queue to traverse a graph
    - Put first node in queue
    - Repeatedly extracts nodes and put its neighbours in the queue
* How is a graph different than a binary tree?
    - We need to track a node if it has been visited before or not in a graph
    - Can easily accomplish tracking a node with a boolean variable 
    - If node have been visited then we won't visit it again
* What is divide and conquer algorithm?
    - Has 3 parts:
        - Divide the problem into smaller bits
        - Solve the small bits recursively
        - Combine the small bits to get the final solution of the problem

###Advanced
* What is a spanning tree?
    - Is a subgraph of an undirected connected graph
* What is a minimum spanning tree?
    - A spanning tree but the sum of the weights of the edge is minimum
    - The weights of the spanning tree is the sum of the weights given to the edges of the spanning tree
* What is Kruskal's algorithm?
    - Finds a minimum cost spanning trees using the greedy approach
    - Treats the graph as a forest and every node as an individual tree
    - One of the algorithms that fall under the greedy algorithm in graph theory
* How does Kruskal's algorithm work?
    - Sort all the edges based on weight from low to high
    - Take the edge with the lowest weight and add it to the spanning tree
    - If the edge that we are going to add creates a cycle, don't add it
    - Continue to add edges until we reach all the vertices
* What are some real world applications of Kruskal's algorithm? 
    - LAN connections
    - Electrical wiring among cities
* What algorithms follow the divide and conquer idea?
    - Quick sort
    - Merge sort
* What is Quick sort?
    - Picks an element and places all the elements smaller than it on its left and the greater ones on the right then recursively sorts the 2 subarrays on the left and right of the element
* What is Merge sort?
    - Splits the array into 2 and recursively sorts 
    - Upon completion it will merge the 2 sorted arrays together into 1

