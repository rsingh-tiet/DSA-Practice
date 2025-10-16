import java.util.Scanner;

public class addTindex {
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
        }void addLast(int val){
            node temp = new node();
            temp.data = val;
            if(size == 0){
                head = tail = temp;
                // size++;
            }else{
                tail.next = temp;
                tail = temp;
                // size++;
            }
            size++;
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
        
        void addTindex(int pos, int val){
            node temp = new node();
            temp.data = val;
            if(pos>size || pos<0){
                System.out.println("adding at invalid address");
            }else if(size ==0){
                head = tail = temp;
                size++;
            }else if(pos == 0){
                addFirst(val);
            }else if(pos == size){
                addLast(val);
            }
            else{
                node curr = head;
                for (int i = 0; i < pos-1; i++) {
                    curr = curr.next;
                }
                temp.next = curr.next;
                curr.next = temp;
                size++;
            }
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
        System.out.println("in this we are adding at any valid index in the list");
        Scanner scn = new Scanner(System.in);
        System.out.println("we are adding at the last of linklist<int> \nenter no of element to be added");
        int a = scn.nextInt();

        LinkList ln = new LinkList();
        for (int i = 0; i < a; i++) {
            System.out.println("enter the element "+(i+1));
            ln.addList(scn.nextInt());
        }
         
        ln.print();
        System.out.println("\nenter the pos where to be added");
        int pos = scn.nextInt();
        System.out.println("enter the element");
        int val = scn.nextInt();

        ln.addTindex(pos,val);
        ln.display();
    }
}
