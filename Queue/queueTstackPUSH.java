import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class queueTstackPUSH {

    /**
     * Implements a Stack using two Queues, prioritizing O(1) complexity for push(). 
     * This means pop() and top() will be O(n).
     */
    public static class QueueToStackAdapter {

        // The primary queue. New elements are simply appended (O(1) push).
        // The stack's "top" element is at the end of this queue.
        private Queue<Integer> mainQ;
        
        // The auxiliary queue used temporarily during the pop/top operation (O(n)).
        private Queue<Integer> helperQ;

        /** * Initializes the adapter. */
        public QueueToStackAdapter() {
            // Using ArrayDeque for efficient queue operations
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        /**
         * Returns the number of elements in the stack. O(1) operation.
         */
        public int size() {
            // ---------------------------------------------------------------------
            // Completed: Return the size of the mainQ.
            // ---------------------------------------------------------------------
            return mainQ.size(); 
        }
        
        /**
         * Pushes the element val onto the stack. O(1) operation.
         * * @param val The value to push.
         * (Implement this method)
         */
        public void push(int val) {
            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR push(int val) HERE.
            // Rule: Simply add the new element to the back of mainQ. This is the O(1) part.
            // ---------------------------------------------------------------------
           mainQ.add(val);
            
        }

        /**
         * Removes and returns the element on top of the stack. O(n) operation.
         * * @return The popped element value, or -1 on underflow.
         * (Implement this method)
         */
        public int pop() {
            if (mainQ.isEmpty()) {
                System.out.println("Stack underflow");
                return -1; // Return -1 as per common practice for error indication
            }else{
                while(mainQ.size() >1){
                    helperQ.add(mainQ.remove());
                }
                int val = helperQ.remove();
                while (!helperQ.isEmpty()) {
                    mainQ.add(helperQ.remove());
                }
                return val;
            }
             
            // Alternate clean way 

            // for(int i = 0 ;i < mainQ.size()-2;i++){
            //     helperQ.add(mainQ.remove());
            
            // }
            // int val = mainQ.remove();
            // Queue<Integer> temp = mainQ;
            // mainQ = helperQ;
            // helperQ = temp;
            // return val;

            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR pop() HERE.
            // Rule: Move n-1 elements from mainQ to helperQ. Remove the last element 
            // (which is the stack top). Then swap mainQ and helperQ references.
            // ---------------------------------------------------------------------
            
            // return -1; // Placeholder until implemented
        }

        /**
         * Gets the top element of the stack without removing it. O(n) operation.
         * * @return The top element, or -1 on underflow.
         * (Implement this method)
         */
        public int top() {
            if (mainQ.isEmpty()) {
                 System.out.println("Stack underflow");
                 return -1;
            }else{
                while(mainQ.size()>1){
                    helperQ.add(mainQ.remove());
                }
                int val = helperQ.peek();
                while (!helperQ.isEmpty()) {
                    mainQ.add(helperQ.remove());
                }
                return val;
            }
            // ---------------------------------------------------------------------
            // TODO: WRITE YOUR LOGIC FOR top() HERE.
            // Rule: Move n-1 elements to helperQ. The last element is the top. 
            // Store it, move it to helperQ, then swap queues.
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
