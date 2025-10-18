import java.util.*;

public class stackAdaptor {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head, tail;
        int size;

        void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) tail = temp;
            size++;
        }

        int removeFirst() {
            if (size == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else if (size == 1) {
                Node ans = head;
                head = tail = null;
                size = 0;
                
            return ans.data;
            } else {
                Node ans = head;
                head = head.next;
                size--;
                
            return ans.data;
            }
        }

        int getFirst() {
            if (size == 0) {
                System.out.println("Stack underflow");
                return -1;
            }
            return head.data;
        }

        int size() {
            return size;
        }

        void display() {
            for (Node temp = head; temp != null; temp = temp.next)
                System.out.print(temp.data + " ");
            System.out.println();
        }
    }

    public static class LLToStackAdapter {
        LinkedList list = new LinkedList();

        // TODO: Implement these methods 👇
        void push(int val) {
            // Write logic here using LinkedList methods
            list.addFirst(val);
        }

        int pop() {
            // Write logic here using LinkedList methods
            // return -1; // placeholder
            return list.removeFirst();
        }

        int top() {
            // Write logic here using LinkedList methods
            return list.getFirst(); // placeholder
        }

        int size() {
            return list.size();
        }

        void display() {
            list.display();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LLToStackAdapter st = new LLToStackAdapter();

        String cmd = scn.next();
        while (!cmd.equals("quit")) {
            if (cmd.equals("push")) {
                int val = scn.nextInt();
                st.push(val);
            } else if (cmd.equals("pop")) {
                int val = st.pop();
                if (val != -1) System.out.println(val);
            } else if (cmd.equals("top")) {
                int val = st.top();
                if (val != -1) System.out.println(val);
            } else if (cmd.equals("size")) {
                System.out.println(st.size());
            } else if (cmd.equals("display")) {
                st.display();
            }
            cmd = scn.next();
        }
        scn.close();
    }
}
