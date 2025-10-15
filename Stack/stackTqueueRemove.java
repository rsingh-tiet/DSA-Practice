import java.io.*;
import java.util.Stack;

public class stackTqueueRemove {

    /**
     * Implements a Queue using two Stacks, prioritizing O(1) complexity for remove() (dequeue). 
     * This means add() (enqueue) will be O(n).
     */
    public static class StackToQueueAdapter {

        // The stack used to store elements as they are added (enqueue).
        // This stack will need to be reversed into the removeS during add().
        private Stack<Integer> addS;
        
        // The stack used for efficient removal (dequeue) and peeking.
        // The queue's 'front' element is at the top of this stack.
        private Stack<Integer> removeS;

        /** * Initializes the adapter. */
        public StackToQueueAdapter() {
            addS = new Stack<>();
            removeS = new Stack<>();
        }

        /**
         * Returns the number of elements in the queue. O(1) operation.
         */
        public int size() {
            // ---------------------------------------------------------------------
            // Completed: Return the total size of elements across both stacks.
            // ---------------------------------------------------------------------
            return addS.size() + removeS.size(); 
        }
        
        /**
         * Adds the element val to the back of the queue (enqueue). O(n) operation.
         * * @param val The value to add.
         * (Implement this method)
         */
        public void add(int val) {
            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR add(int val) HERE.
            // Rule: Transfer all elements from removeS back to addS.
            // Then push the new element 'val' onto addS.
            // This is the expensive O(n) part.
            // ---------------------------------------------------------------------
            
        }

        /**
         * Removes and returns the element at the front of the queue (dequeue). O(1) operation.
         * * @return The removed element value, or -1 on underflow.
         * (Implement this method)
         */
        public int remove() {
            if (size() == 0) {
                System.out.println("Queue underflow");
                return -1; // Return -1 as per common practice for error indication
            }

            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR remove() HERE.
            // Rule: If removeS is empty, transfer all elements from addS to removeS 
            // (this reverses the order for correct queue behavior).
            // Then pop and return the element from removeS.
            // ---------------------------------------------------------------------
            
            return -1; // Placeholder until implemented
        }

        /**
         * Gets the element at the front of the queue without removing it (peek). O(1) operation.
         * * @return The front element, or -1 on underflow.
         * (Implement this method)
         */
        public int peek() {
            if (size() == 0) {
                 System.out.println("Queue underflow");
                 return -1;
            }
            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR peek() HERE.
            // Rule: If removeS is empty, transfer all elements from addS to removeS.
            // Then peek and return the element from removeS.
            // ---------------------------------------------------------------------
            
            return -1; // Placeholder until implemented
        }
    }

    /**
     * Main method to handle input commands via BufferedReader.
     * (Handled by the assistant)
     */
    public static void main(String[] args) throws Exception {
        // Setup input reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Initialize the adapter
        StackToQueueAdapter qu = new StackToQueueAdapter();
        
        String str = br.readLine();
        
        // Loop until the "quit" command is received
        while (str != null && !str.equals("quit")) {
            
            String[] parts = str.split(" ");
            String command = parts[0];

            try {
                switch (command) {
                    case "add":
                        if (parts.length > 1) {
                            int val = Integer.parseInt(parts[1]);
                            qu.add(val);
                        }
                        break;
                    case "remove":
                        int removedVal = qu.remove();
                        // Only print the value if the remove was successful (not -1 for underflow)
                        if (removedVal != -1) {
                             System.out.println(removedVal);
                        }
                        break;
                    case "peek":
                        int peekVal = qu.peek();
                        if (peekVal != -1) {
                            System.out.println(peekVal);
                        }
                        break;
                    case "size":
                        System.out.println(qu.size());
                        break;
                    default:
                        // Ignore unknown commands
                        break;
                }
            } catch (Exception e) {
                 // Print error message for debugging purposes
                 System.out.println("Execution Error: " + e.getMessage());
            }

            // Read next line for the loop condition
            str = br.readLine();
        }
    }
}
