import java.util.Scanner;

public class oddEven {
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
        void removeFirst(){
            if(size == 0){
                System.out.println("nothing to remove");
            }else if(size == 1){
                head = tail =null;
                size--;
            }else{
                head = head.next;
                size--;
            }
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
        
    }
    
    public static LinkList oddEven(LinkList l1){
        LinkList ans;
        LinkList even = new LinkList();
        LinkList odd = new LinkList();
        // ans.addFirst(l1.head.data);
        // l1.removeFirst();
        while(l1.size>0){
            if(l1.head.data %2 == 0){
                even.addList(l1.head.data);
                l1.removeFirst();
            }else{
                odd.addList(l1.head.data);
                l1.removeFirst();
            }
        }
        if(odd.size >0){
            ans = odd;
            ans.tail.next = even.head;
            ans.tail = even.tail;
        }else{
            ans = even;
        }
        ans.size = odd.size+even.size;
        return ans;
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
        LinkList q = oddEven(ln);
        q.print();
        scn.close();
    }
}
