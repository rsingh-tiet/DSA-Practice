import java.util.Scanner;

public class mergeSort {
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
        void addLast(int val){
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
    
    public static node midnode(node head, node tail) {
    node slow = head;
    node fast = head;

    while (fast != tail && fast.next != tail) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

    public static LinkList merge2List(LinkList l1, LinkList l2){
        LinkList merged = new LinkList();
        node f = l1.head;
        node s = l2.head;
        while(f != null && s != null){
            if(f.data > s.data){
                merged.addLast(s.data);
                s = s.next;
            }else{
                merged.addLast(f.data);
                f= f.next;
            }
        }
        while(f != null){
            merged.addLast(f.data);
            f = f.next;
        }
        while(s != null){
            merged.addLast(s.data);
            s = s.next;
        }

        return merged;
    }
    public static LinkList mergeSort(node head,node tail){
        
        if(head == tail){
            LinkList l = new LinkList();
            l.addLast(head.data);
            return l;
        }
        
        node mid  = midnode(head, tail);
        LinkList first =  mergeSort(head, mid);
        LinkList second = mergeSort(mid.next, tail); 
        LinkList merged = merge2List(first, second);
        return merged;
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
        System.out.println("\nsorted list is");
        LinkList l = mergeSort(ln.head, ln.tail);
        l.print();
        scn.close();
    }
}