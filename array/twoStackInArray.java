import java.io.*;
import java.util.Scanner;

public class twoStackInArray {

    public static class TwoStack {
        private int[] arr;
        private int size;
        private int top1; // top pointer for stack1
        private int top2; // top pointer for stack2

        public TwoStack(int n) {
            arr = new int[n];
            size = n;
            top1 = -1;       // stack1 starts from left
            top2 = n;        // stack2 starts from right
        }

        // Push element x to stack1
        public void push1(int x) {
            // TODO: Write your logic here
            if(top1 == top2 +1){
                System.out.println("element will override the thing in other stack\nsize overflow");
            }else{
                top1++;
                arr[top1] = x;
            }
        }

        // Push element x to stack2
        public void push2(int x) {
            // TODO: Write your logic here
            if(top2 == top1 +1){
                System.out.println("element will override the thing in other stack\nsize overflow");
            }else{
                top2--;
                arr[top2] = x;
            }
        }

        // Pop element from stack1
        public int pop1() {
            // TODO: Write your logic here
            if(top1 == -1){
                System.out.println("stack underflow");
                return -1;
            }
            int val = arr[top1];
            top1--;
            return val;
        }

        // Pop element from stack2
        public int pop2() {
            // TODO: Write your logic here
            if(top2 == size){
                System.out.println("stack underflow");
                return -1;
            }
            int val = arr[top2];
            top2++;
            return val;
            
        }

        // Peek top of stack1
        public int top1() {
            // TODO: Write your logic here
            if(top1 == -1){
                System.out.println("stack underflow");
                return -1;
            }
            int val = arr[top1];
            return val;
            
        }

        // Peek top of stack2
        public int top2() {
            // TODO: Write your logic here
            if(top2 == size){
                System.out.println("stack underflow");
                return -1;
            }
            int val = arr[top2];
            return val;
            
        }

        // Size of stack1
        public int size1() {
            return top1 + 1;
        }

        // Size of stack2
        public int size2() {
            return size - top2;
        }

        // Check if stack1 is empty
        public boolean isEmpty1() {
            return top1 == -1;
        }

        // Check if stack2 is empty
        public boolean isEmpty2() {
            return top2 == size;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        TwoStack ts = new TwoStack(n);

        while (true) {
            System.out.println("\nCommands: push1 x, push2 x, pop1, pop2, top1, top2, size1, size2, quit");
            String cmd = sc.next();

            if (cmd.equals("quit")) break;

            switch (cmd) {
                case "push1":
                    int x1 = sc.nextInt();
                    ts.push1(x1);
                    break;
                case "push2":
                    int x2 = sc.nextInt();
                    ts.push2(x2);
                    break;
                case "pop1":
                    System.out.println(ts.pop1());
                    break;
                case "pop2":
                    System.out.println(ts.pop2());
                    break;
                case "top1":
                    System.out.println(ts.top1());
                    break;
                case "top2":
                    System.out.println(ts.top2());
                    break;
                case "size1":
                    System.out.println(ts.size1());
                    break;
                case "size2":
                    System.out.println(ts.size2());
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }

        sc.close();
    }
}
