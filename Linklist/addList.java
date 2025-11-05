import java.util.Scanner;

public class addList {
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
        int helperAdd(node one,node two,int pv1,int pv2,LinkList ans){
            if(pv1 ==0 && pv2 ==0){
                return 0;
            }
            int data =0;
            if(pv1>pv2){
                int carry = helperAdd(one.next, two, pv1-1, pv2, ans);
                data = carry+one.data;

            }else if(pv1<pv2){
                int carry = helperAdd(one, two.next, pv1, pv2-1, ans);
                data = carry + two.data;
            }else{
                int carry = helperAdd(one.next, two.next, pv1-1, pv2-1, ans);
                data = carry+ one.data+two.data;
            }
            int carry = data/10;
            data = data%10;
            ans.addFirst(data);

            return carry;
        }
        LinkList addTwoList(LinkList one,LinkList two){
            LinkList ans = new LinkList();
            int carry = helperAdd(one.head,two.head,one.size,two.size,ans);
            if(carry>0){
                ans.addFirst(carry);
            }
            return ans;
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

        LinkList ln1 = new LinkList();
        for (int i = 0; i < a; i++) {
            System.out.println("enter the element "+(i+1));
            ln1.addList(scn.nextInt());
        }
          
        LinkList ln2 = new LinkList();
        System.out.println("enter the size of ln2");
        int b = scn.nextInt();
        for (int i = 0; i < b; i++) {
            System.out.println("enter the element "+(i+1));
            ln2.addList(scn.nextInt());
        }

        ln1.print();
        System.out.println();
        ln2.print();
        System.out.println();
        LinkList ans = ln1.addTwoList(ln1, ln2);
        ans.print();
        // System.out.println("\nenter the k element from end");
        // ln.getKend(scn.nextInt()-1);
        // System.out.println(ln.middle());
        scn.close();
    }
}