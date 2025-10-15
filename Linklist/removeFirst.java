import java.util.Scanner;

public class removeFirst {
    public static class node {
        int data;
        node next;
        
    }
    public static class LinkList {
        node head;
        node tail;
        int size;
        void display() {
            node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }
        void print(){
            for(node temp = head;temp != null;temp = temp.next){
                System.out.print("data: "+temp.data+" ->");
            }
            // System.out.print(tail.data);
            System.out.print(" null");
        }
        int size(){
            return size;
        }
        void removeFirst(){
            // node temp = head;
            // head = temp.next;
            // above lines can be written as 
            if(size == 0){
                System.out.println("nothing to remove");  
            }else if(size == 1){
                head = tail = null;
                size = 0;
            }else{
                head = head.next;
                size--;
            }
            

            // temp.next=null;
            
            

        }
        void addList( int val){
            node temp = new node();
                temp.data = val;
                temp.next = null;
            if(size == 0){
                
                head = tail = temp;
                // size = 1;
                // size++;
            }else{
                tail.next = temp;
                tail = temp;
                // size++;
            }
            size++;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("we are adding at the last of linklist<int> \nenter no of element to be added");
        int a = scn.nextInt();

        LinkList ln = new LinkList();
        for (int i = 0; i < a; i++) {
            ln.addList(scn.nextInt());
        }
        
        
        ln.print();
        ln.removeFirst();
        System.out.println("\nremove first");
        ln.display();
    }
}
