import java.util.Scanner;

public class superPow {
    public static class node {
        int data;
        node next;
    }

    public static class LinkList {
        node head;
        node tail;
        int size;

        void print() {
            for (node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " -> ");
            }
            System.out.println("null, size: " + size);
        }

        // ✅ Add at end
        void addList(int val) {
            node temp = new node();
            temp.data = val;
            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        // ✅ Recursive Print
        void displayHelper(node temp) {
            if (temp == null) return;
            System.out.print(temp.data + " ");
            displayHelper(temp.next);
        }
        void displayRecur() {
            displayHelper(head);
            System.out.println();
        }

        // ✅ Find middle element using fast/slow approach
        int middle() {
            if (head == null) return -1;

            node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }

        // ✅ Kth from End
        void getKend(int k) {
            node slow = head, fast = head;

            for (int i = 0; i < k; i++) {
                if (fast == null) return;
                fast = fast.next;
            }
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            System.out.println(k + "th from end = " + slow.data);
        }

        
        node reverseRec(node curr) {
            if (curr == null || curr.next == null) {
                head = curr;
                return curr;
            }
            node newHead = reverseRec(curr.next);
            curr.next.next = curr;
            curr.next = null;
            return newHead;
        }

        void reverse() {
            reverseRec(head);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        LinkList ln = new LinkList();

        System.out.println("Enter number of elements:");
        int a = scn.nextInt();

        for (int i = 0; i < a; i++) {
            System.out.println("Enter element " + (i + 1));
            ln.addList(scn.nextInt());
        }

        ln.print();
        System.out.println("Recursive display:");
        ln.displayRecur();
        System.out.println("Middle element: " + ln.middle());
        
        System.out.println("Enter k to find kth from end:");
        ln.getKend(scn.nextInt());

        System.out.println("Reversing list...");
        ln.reverse();
        ln.print();

        scn.close();
    }
}
