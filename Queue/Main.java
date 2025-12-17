import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    /**
     * Implements a Stack using two Queues, prioritizing O(1) complexity for pop() 
     * and top(). This means push() will be O(n).
     */
    public static class QueueToStackAdapter {

        // The primary queue, where the stack's "top" element is always kept at the front.
        private Queue<Integer> mainQ;
        
        // The auxiliary queue used temporarily during the push operation.
        private Queue<Integer> helperQ;

        /** * Initializes the adapter. */
        public QueueToStackAdapter() {
            // Using ArrayDeque for efficient queue operations
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        /**
         * Returns the number of elements in the stack.
         * (Implement this method)
         */
        public int size() {
            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR size() HERE.
            // Rule: Return the size of the mainQ.
            // ---------------------------------------------------------------------
            if(mainQ.isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            return mainQ.size(); // Placeholder until implemented
        }
        
        /**
         * Pushes the element val onto the stack. O(n) operation.
         * * @param val The value to push.
         * (Implement this method)
         */
        public void push(int val) {
            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR push(int val) HERE.
            // 1. Add 'val' to helperQ.
            // 2. Move all elements from mainQ to helperQ.
            // 3. Swap references: mainQ becomes helperQ, helperQ becomes mainQ (to reuse it).
            // ---------------------------------------------------------------------
            if(mainQ.isEmpty()){
                mainQ.add(val);
            }else{
                while(!mainQ.isEmpty()){
                    helperQ.add(mainQ.remove());
                }
                mainQ.add(val);
                while (!helperQ.isEmpty()) {
                    mainQ.add(helperQ.remove());
                }
            }

            // Alternative clean logic
             
            // helperQ.add(val);
            // while(!mainQ.isEmpty()){
            //     helperQ.add(mainQ.remove());
            // }
            // Queue<Integer> temp = new ArrayDeque<>();
            // temp = mainQ;
            // mainQ = helperQ;
            // helperQ = temp;

        }

        /**
         * Removes and returns the element on top of the stack. O(1) operation.
         * * @return The popped element value, or -1 on underflow.
         * (Implement this method)
         */
        public int pop() {
            if (mainQ.isEmpty()) {
                System.out.println("Stack underflow");
                return -1; // Return -1 as per common practice for error indication
            }else{
                
                return mainQ.remove();
            }


            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR pop() HERE.
            // Rule: Since the top element is always at the front of mainQ, simply remove it.
            // ---------------------------------------------------------------------
            
            // return -1; // Placeholder until implemented
        }

        /**
         * Gets the top element of the stack without removing it. O(1) operation.
         * * @return The top element, or -1 on underflow.
         * (Implement this method)
         */
        public int top() {
            if (mainQ.isEmpty()) {
                 System.out.println("Stack underflow");
                 return -1;
            }else{
                return mainQ.peek();
            }
            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR top() HERE.
            // Rule: Return the element at the front of mainQ (peek).
            // ---------------------------------------------------------------------
            
            // return -1; // Placeholder until implemented
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
        QueueToStackAdapter st = new QueueToStackAdapter();
        
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
                    case "size":
                        System.out.println(st.size());
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
