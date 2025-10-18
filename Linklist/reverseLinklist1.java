import java.util.Scanner;

public class reverseLinklist1 {
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
        private node getAt(int pos){
            node temp = head;
            for(int i = 0 ; i < pos ; i++){
                temp = temp.next;
            }
            return temp;
        }
        void reversing(){
            if(size == 0){
                System.out.println("nothing to reverse");
            }else{
                int li = 0,ri = size-1;
                while (li<ri) {
                    node left = getAt(li);
                    node right = getAt(ri);
                    int temp = left.data;
                    left.data = right.data;
                    right.data = temp;
                    li++;
                    ri--;
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
        System.out.println("we are reversing the linklist via data changing iteratively O(n^2)\nenter no of elements");
        int a = scn.nextInt();

        LinkList ln = new LinkList();
        for (int i = 0; i < a; i++) {
            System.out.println("enter the element "+(i+1));
            ln.addList(scn.nextInt());
        }
        
        
        ln.print();
        System.out.println();
        ln.reversing();
        ln.print();
        scn.close();
    }
}
