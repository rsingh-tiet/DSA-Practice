import java.util.Scanner;

public class removeIndex {
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
            System.out.println("null size: "+size);
        }
        void print(){
            for(node temp = head;temp != null;temp = temp.next){
                System.out.print("data: "+temp.data+" ->");
            }
            // System.out.print(tail.data);
            System.out.print(" null + size: "+size);
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
        void removeLast(){
            if(size == 0){
                System.out.println("nothinng to remove");
            }else if(size == 1){
                head = tail = null;
                size--;
            }else{
                node curr = head;
                for (int i = 0; i < size-2; i++) {
                    curr = curr.next;
                }
                curr.next = null;
                tail = curr;
                size--;
            }
        }

        void removeIndex(int pos){
            if(pos>=size || pos<0){
                System.out.println("nothing to remove");
            }else if(pos == 0){
                removeFirst();
            }else if(pos == size-1){
                removeLast();
            }else{
                node curr = head;
                for (int i = 0; i < pos-1; i++) {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
                size--;
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
        Scanner scn = new Scanner(System.in);
        System.out.println("enter no of element to be added");
        int a = scn.nextInt();

        LinkList ln = new LinkList();
        for (int i = 0; i < a; i++) {
            System.out.println("enter the element "+(i+1));
            ln.addList(scn.nextInt());
        }
        
        
        ln.print();
        System.out.println("\nenter the pos to be removed");
        ln.removeIndex(scn.nextInt()-1);
        ln.print();

    }
}
