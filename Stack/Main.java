import java.io.*;
import java.util.Stack;

public class Main {

    /**
     * Implements a Stack that supports push, pop, top, and retrieving the minimum
     * element in constant time O(1).
     */
    public static class MinStack {

        // The main stack to store all elements
        private Stack<Integer> allData;
        
        // The auxiliary stack to store the minimum element at each corresponding level 
        // of the allData stack. This allows min() to be O(1).
        private Stack<Integer> minData;

        /** * Initializes the stack object. */
        public MinStack() {
            allData = new Stack<>();
            minData = new Stack<>();
        }

        /**
         * Returns the number of elements in the stack.
         * (Implement this method)
         */
        public int size() {
            int size = 0;
            Stack<Integer> helper = new Stack<>();
            while(allData.peek() != null){
                
                helper.push(allData.pop());
                size++;
            }
            while(helper.peek()!=null){
                allData.push(helper.pop());
            }
            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR size() HERE.
            // Rule: Return the size of the allData stack.
            // ---------------------------------------------------------------------
            return size; // Placeholder until implemented
        }
        
        /**
         * Pushes the element val onto the stack.
         * * @param val The value to push.
         * (Implement this method)
         */
        public void push(int val) {
            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR push(int val) HERE.
            // Rule: Always push to allData. Only push to minData if 'val' 
            // is less than or equal to the current minimum in minData.
            // ---------------------------------------------------------------------
            
        }

        /**
         * Removes the element on top of the stack.
         * * @return The popped element value.
         * (Implement this method)
         */
        public int pop() {
            if (allData.isEmpty()) {
                System.out.println("Stack underflow");
                return -1; // Return -1 as per common practice for error indication
            }

            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR pop() HERE.
            // Rule: Pop from allData. If the popped value equals the value at 
            // the top of minData, pop from minData as well. Return the popped value.
            // ---------------------------------------------------------------------
            
            return -1; // Placeholder until implemented
        }

        /**
         * Gets the top element of the stack.
         * * @return The top element.
         * (Implement this method)
         */
        public int top() {
            if (allData.isEmpty()) {
                 System.out.println("Stack underflow");
                 return -1;
            }
            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR top() HERE.
            // Rule: Return the top element of allData without removing it.
            // ---------------------------------------------------------------------
            
            return -1; // Placeholder until implemented
        }

        /**
         * Retrieves the minimum element in the stack.
         * * @return The minimum element.
         * (Implement this method)
         */
        public int min() {
            if (minData.isEmpty()) {
                System.out.println("Stack underflow");
                return -1;
            }
            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR min() HERE.
            // Rule: Return the top element of minData without removing it.
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
        
        // Initialize the stack
        MinStack st = new MinStack();
        
        String str = br.readLine();
        
        // Loop until the "quit" command is received
        while (str != null && !str.equals("quit")) {
            
            String[] parts = str.split(" ");
            String command = parts[0];

            try {
                switch (command) {
                    case "push":
                        if (parts.length > 1) {
                            int val = Integer.parseInt(parts[1]);
                            st.push(val);
                        }
                        break;
                    case "pop":
                        int poppedVal = st.pop();
                        // Only print the value if the pop was successful (not -1 for underflow)
                        if (poppedVal != -1) {
                             System.out.println(poppedVal);
                        }
                        break;
                    case "top":
                        int topVal = st.top();
                        if (topVal != -1) {
                            System.out.println(topVal);
                        }
                        break;
                    case "min":
                        int minVal = st.min();
                        if (minVal != -1) {
                            System.out.println(minVal);
                        }
                        break;
                    case "size":
                        System.out.println(st.size());
                        break;
                    default:
                        // Ignore unknown commands
                        break;
                }
            } catch (Exception e) {
                // In a real environment, you might log the error, 
                // but for this exercise, we'll generally proceed.
                // System.out.println("An error occurred: " + e.getMessage());
            }

            // Read next line for the loop condition
            str = br.readLine();
        }
    }
}
