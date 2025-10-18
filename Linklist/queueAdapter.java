import java.util.*;

public class queueAdapter {
    public static class node {
        int data;
        node next;
    }
    public static class LinkedList{
        node head;
        node tail;
        int size;
        void addFirst(int val){
            node temp = new node();
            temp.data = val;
            if(size == 0){
                head = tail = temp;
            }else{
                temp.next = head;
                head = temp;
            }
            size++;
        }
        void addlast(int val){
            node temp = new node();
            temp.data = val;
            if(size == 0){
                head = tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }
        int removeFirst(){
            node temp = head;
            if(size == 0){
                System.out.println("nothing to remove");
                return -1;
            }else if(size == 1){
                head = tail = null;
                size--;
                return temp.data;
            }else{
                head = head.next;
                size--;
                return temp.data;
            }
        }
        int getFirst(){
            node temp = head;
            if(size == 0){
                System.out.println("nothing to see");
                return -1;
            }else{
                return temp.data;
            }
        }
        int removeLast(){
            if(size == 0){
                System.out.println("nothing to remove");
                return -1;
            }else if(size == 1){
                node temp = head;
                head = tail = null;
                size = 0;
                return temp.data;
            }else{
                node temp = head;
                for (int i = 0; i < size-2; i++) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                size--;
                return temp.data;
            }
        }
        int getLast(){
            if(size == 0){
                return -1;
            }else if(size == 1){
                return head.data;
            }else{
                return tail.data;
            }
        }
        void display(){
            node temp  = head;
            while(temp != null){
                System.out.print("data: "+temp.data+" ->");
                temp = temp.next;
            }
            System.out.print("null");
        }

    }
    public static class QueueLL {
        node head;
        node tail;
        int size;
        LinkedList list = new LinkedList();
        // 👉 Add your logic here
        void add(int val) {
            // TODO: implement enqueue logic using linked list
            list.addlast(val);
        }

        int remove() {
            // TODO: implement dequeue logic
            return list.removeFirst();
        }

        int peek() {
            // TODO: return front element (without removing)
            return list.getFirst();
        }

        int size() {
            return list.size;
        }

        void display() {
            list.display();
    }

    // 👉 Driver code to test your implementation
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        QueueLL q = new QueueLL();

        while (true) {
            String cmd = scn.next();

            if (cmd.equals("add")) {
                int val = scn.nextInt();
                q.add(val);
            } 
            else if (cmd.equals("remove")) {
                int val = q.remove();
                if (val != -1)
                    System.out.println(val);
            } 
            else if (cmd.equals("peek")) {
                int val = q.peek();
                if (val != -1)
                    System.out.println(val);
            } 
            else if (cmd.equals("display")) {
                q.display();
            } 
            else if (cmd.equals("size")) {
                System.out.println(q.size());
            } 
            else if (cmd.equals("quit")) {
                break;
            }
        }
        scn.close();
    }
    }}
