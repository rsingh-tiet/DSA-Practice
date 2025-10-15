import java.util.Scanner;

public class getValue {
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
        void getValue(int pos){
            if(size == 0){
                System.out.println("list is empty");
            }else{
                node curr = head;
                if(pos>=0 && pos < size){
                    for (int i = 0; i < pos; i++) {
                        curr = curr.next;
                    }
                    System.out.println("data: "+curr.data);
            
                }else{
                    System.out.println("pos is not in range");
                }
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
        System.out.println("we are adding at the last of linklist<int> \nenter no of element to be added");
        int a = scn.nextInt();

        LinkList ln = new LinkList();
        for (int i = 0; i < a; i++) {
            System.out.println("enter the element "+(i+1));
            ln.addList(scn.nextInt());
        }
        
        ln.print();
        System.out.println("\nenter the pos which you want to fetch");
        ln.getValue(scn.nextInt());
    }
}
