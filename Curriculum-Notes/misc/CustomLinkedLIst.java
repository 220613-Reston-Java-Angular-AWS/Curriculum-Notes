import java.util.Iterator;


/**
 * Simple doubly linkedlist implementation, extending custom list interface.
 * Also implements Iterable interface. (commented out)
 * @param <T>
 */
public class CustomLinkedList<T> implements CustomListInterface<T>, Iterable<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;


    /**
     * Adds an object to the end of the linked list
     * @param t object to be added to the list
     */
    @Override
    public void add(T t) {
        Node<T> newNode = new Node<T>(t);
        if (head == null) {
            head = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    /**
     * Adds an object to the linked list at the specified index, splicing into place
     * and effectively shifting all further objects
     * @param index position to add object
     * @param t object to be added
     */
    @Override
    public void add(T t, int index) {
        //Implement this method
    }

    /**
     * gets the object found at provided index position
     * @param index location of the object to get
     * @return object found at index position
     */
    @Override
    public T get(int index) {
        //Implement this method
    }

    /**
     * Clears the linked list by setting head and tail to null.
     *
     */
    @Override
    public void clear() {
        //Implement this method
    }

    /**
     * Searches linked list for an object using Object.equals() to compare
     * returns the index of the first matching object found. -1 if not found.
     * @param t the object to match
     * @return index of the first matching object found. -1 if not found
     */
    @Override
    public int contains(T t) {
        //Implement this method
    }

    /**
     * removes an object from linked list and splices the two resulting separate lists
     * together.
     * @param index the location of the object to be removed.
     */
    @Override
    public void remove(int index) {
        //Implement this method
    }


    /**
     * returns the size of the linked list
     * @return size of linked list
     */
    @Override
    public int size() {
        //Implement this method
    }

    /**
     * iterator implementation
     * @return returns an iterator object to traverse the linked list
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> cursor = head;

            /**
             * checks if the linked list has another node, testing if the cursor points to a node
             * or if it is null
             * @return true if the cursor points to a node, false if the cursor node reference is null
             */
            @Override
            public boolean hasNext() {
                if (cursor == null){
                    return false;
                }
                return true;
            }

            /**
             * returns the node the cursor points to, then advances the cursor to the next node
             * @return the object at the location of the cursor
             */
            @Override
            public T next() {
                T t = cursor.obj;
                cursor = cursor.next;
                return t;
            }
        };
    }


    /**
     * Private node class contains a reference to object of list type, a reference to the next node, and
     * to the previous node.
     * @param <T>
     */
    private class Node<T> {
        Node<T> next;
        Node<T> prev;
        T obj;

        /**
         * empty constructor creates an empty node
         */
        Node() {

        }

        /**
         * creates a node and stores an object by reference
         * @param t the stored object
         */
        Node(T t) {
            obj = t;
        }

        /**
         * creates a node which stores an object by reference and has a reference to another node
         * @param t object to be stored
         * @param next next node in list
         */
        Node(T t, Node<T> next) {
            this(t);
            this.next = next;
        }

        /**
         * creates a node which stores an object by reference and has refrences to two nodes,
         * previous and next in the list
         * @param t the object to be stored
         * @param next reference to next node in list
         * @param prev reference to previous node in list
         */
        Node(T t, Node<T> next, Node<T> prev) {
            this(t, next);
            this.prev = prev;
        }
    }


    /**
     * You can use this method to test the list, but it may be a good idea to add more tests
     * to make sure everything works properly. This test will print all the strings given in
     * the parameter list.
     * @param greeting - a string with a greeting message - first item added to list
     * @param goodbye - a string with a closing message - last item added to list
     * @param args - variable arguments, any number of strings which will be added to list
     */
    public void testMethod(String greeting, String goodbye, String... args) {
        System.out.println(greeting);
        for(int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println(goodbye);
    }

    /**
     * Another method that can be used to test the list, give any number of ints in the parameter list
     * and it will return the sum of those integers.
     * @param nums - variable arguments - any number of integer values
     * @return - the sum of the integers given in the parameter list
     */
    public int testSum(Integer... nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }


}
