import java.util.Scanner;

public class intersectList {
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
        int intersectPoint(LinkList one,LinkList two){
            int delta = Math.abs(one.size-two.size);
            node o1 = one.head;
            node o2 = two.head;
            if(one.size>two.size){
                for (int i = 0; i < delta; i++) {
                    o1 = o1.next;
                }
            }else{
                for (int i = 0; i < delta; i++) {
                    o2 = o2.next;
                }
            }
            while(o1 != o2){
                o1 = o1.next;
                o2 = o2.next;
            }
            return o1.data;
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
        System.out.println("enter initial size of ln2");
        int b = scn.nextInt();
        LinkList ln2 = new LinkList();
        for (int i = 0; i <b; i++) {
            System.out.println("enter the element "+(i+1));
            ln2.addList(scn.nextInt());
        }
        node temp = ln.head;
        for (int i = 0; i < ln.size-1; i++) {
            temp = temp.next;
        }
        temp.next = ln2.head;
        ln.size+=ln2.size;

        ln.print();
        System.out.println();
        ln2.print();
        System.out.println();
        int ans = ln.intersectPoint(ln, ln2);
        System.out.println(ans);
        scn.close();
    }
}