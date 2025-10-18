import java.util.Scanner;

public class merge2sorted {
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
            System.out.println("null | size: " + size);
        }

        void addLast(int val) {
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

        void print() {
            for (node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " -> ");
            }
            System.out.println("null | size: " + size);
        }

        int size() {
            return size;
        }
    }

    public static LinkList merLinkList(LinkList l1, LinkList l2) {
        LinkList res = new LinkList();
        node first = l1.head;
        node second = l2.head;

        while (first != null && second != null) {
            if (first.data <= second.data) {
                res.addLast(first.data);
                first = first.next;
            } else {
                res.addLast(second.data);
                second = second.next;
            }
        }

        while (first != null) {
            res.addLast(first.data);
            first = first.next;
        }

        while (second != null) {
            res.addLast(second.data);
            second = second.next;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter no of elements in list 1:");
        int a = scn.nextInt();

        LinkList ln = new LinkList();
        for (int i = 0; i < a; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            ln.addLast(scn.nextInt());
        }

        System.out.println("Enter no of elements in list 2:");
        int a2 = scn.nextInt();

        LinkList ln2 = new LinkList();
        for (int i = 0; i < a2; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            ln2.addLast(scn.nextInt());
        }

        System.out.println("\nList 1:");
        ln.print();
        System.out.println("List 2:");
        ln2.print();

        LinkList merged = merLinkList(ln, ln2);

        System.out.println("\nMerged Sorted List:");
        merged.display();

        scn.close();
    }
}
