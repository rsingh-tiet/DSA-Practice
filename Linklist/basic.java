import java.util.Scanner;

import org.w3c.dom.Node;

public class basic {
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
        int middle(){
            if(size == 0){
                System.out.println("empty list");
                return -1;
            }else if(size == 1){
                System.out.println("one element is present defining middle is now irrelevent");
                return head.data;
            }else{
                node i = head,j = head;
                // here 2 pointer approach from the last and start to id will not work if size is not allowed to use
                while(j != tail && j.next.next!=null){
                    i = i.next;
                    j = j.next.next;
                }
                return i.data;
            }
        }
        void getKend(int k){
            if(size == 0){
                System.out.println("empty list");
            }else if(size == 1){
                System.err.println("only 1 element");
            }else{
                node i = head,j = head;
                for (int idx = 0; idx < k; idx++) {
                 j = j.next;
                }
                while(j.next!=null){
                    i = i.next;
                    j = j.next;
                }
                System.out.println("Kth from end is "+i.data);
            }
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
        void helperDis(node n){
            if(n == null){
                return;
            }
            helperDis(n.next);
            System.out.print(n.data+" ");
        }
        void displayRecurRev(){
            helperDis(head);
            
        }
        node left;
        void helperRev(node n,int ctrl){
            if(n == null){
                return;
            }
            helperRev(n.next, ctrl+1);
            if(ctrl>size/2){
                
                int temp = left.data;
                left.data = n.data;
                n.data= temp;
                left = left.next;
            }
        }
        void revRec(){
            left = head;
            helRev(head);
            head.next = null;
            node temp = head;
            head = tail;
            tail = temp;
        }
        void helRev(node right){
            if(right == null){
                return;
            }
            helRev(right.next);
            if(right == tail){

            }else{
                right.next.next = right; 
            }
        }
        void reverseRec(){
            left = head;//i cannot crete node left here not in  scope and can't initialize it there as head is formed after linklist is created
            helperRev(head,0);
        }
        boolean helperPal(node right,int floor){
            if(right == null){
                // flag = true;
                return true;
            }
            boolean intermediate = helperPal(right.next, floor+1);
            if(floor>size/2){
                if(left.data == right.data && intermediate == true ){
                    left = left.next;
                    return true;
                }else{
                    // System.out.println("not palindrome");
                    // flag = false;
                    return false;
                }
            }
            return intermediate;
        }
        void isPalindrome(){
            left =head;
            boolean ans = helperPal(head,0);
            System.out.println(ans);
        }
        void helperFold(node right, int floor) {
            if (right == null) return;

            helperFold(right.next, floor + 1);

            if (floor > size / 2) {
                node temp = left.next;
                left.next = right;
                right.next = temp;
                left = temp;
            } else if (floor == size / 2) {
                // middle reached, break chain
                tail = right;
                tail.next = null;
            }
        }

        void foldList() {
            left = head;
            helperFold(head, 0);
        }
        boolean isCircular(node head) {
            // Your code here
            node curr = head.next;
            while(curr != head){
                if(curr == null){
                    return false;
                }
                curr = curr.next;
            }
            return true;
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
        System.out.println();
        // System.out.println("\nenter the k element from end");
        // ln.getKend(scn.nextInt()-1);
        // System.out.println(ln.middle());
        ln.displayRecurRev();
        ln.reverseRec();
        ln.print();
        ln.revRec();
        ln.display();
        System.out.println("is list a palindrome");
        ln.isPalindrome();
        ln.foldList();
        ln.display();
        boolean z = ln.isCircular(ln.head);
        System.out.println(z);
        scn.close();
    }
}
