import java.util.Scanner;

public class addFirst {
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
        void addFirst(int val){
            if(size == 0){
                node temp = new node();
                temp.data = val;
                head = tail = temp;
                
            }else{
                node temp = new node();
                // temp = head; this will make the reference of the temp node to head then we will be
                //              changing the val to head making its next head only and them making head to head 
                //              this breaks the structure of linklist
                temp.data = val;
                temp.next = head;
                head = temp;
            }
            size++;
            
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
        System.out.println("\n enter element to be added at first");
        ln.addFirst(scn.nextInt());
        ln.print();
        scn.close();
    }
}
