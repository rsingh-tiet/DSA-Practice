import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class MedianPriorityQueue {

    // Max-Heap (stores smaller half)
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());

    // Min-Heap (stores larger half)
    PriorityQueue<Integer> right = new PriorityQueue<>();

    // ➤ Insert element
    public void add(int val) {
        if(val>right.peek()){
            right.add(val);
            balanceHeaps();
        }
        left.add(val);
        balanceHeaps();
    }


    // ➤ Remove median
    public int remove() {
        if(left.size() ==0 && right.size() ==0){System.out.println("underflow");return-1;}
        if(left.size()>right.size()){
            return left.remove();
        }else if(left.size()<right.size()){
            return right.remove();
        }else{
            return left.remove();
        }
    }

    // ➤ Return median
    public int peek() {
        if(left.size() ==0 && right.size() ==0){System.out.println("underflow");return-1;}
        if(left.size()>=right.size()){
            int peek = left.peek();
            return peek;
        }else if(left.size()<right.size()){
            int peek = right.peek();
            return peek;
        }else{
            return left.peek();
        }
    }

    // ➤ Return size
    public int size() {
        return left.size()+right.size();
    }

    // ➤ Keep sizes balanced
    private void balanceHeaps() {
        if (left.size() - right.size() == 2) {
            right.add(left.remove());
        } else if (right.size() - left.size() == 2) {
            left.add(right.remove());
        }
    }
}

public class median {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MedianPriorityQueue mpq = new MedianPriorityQueue();

        while (true) {
            String cmd = sc.next();

            if (cmd.equals("quit")) {
                break;
            } else if (cmd.equals("add")) {
                int val = sc.nextInt();
                mpq.add(val);
            } else if (cmd.equals("remove")) {
                int ans = mpq.remove();
                if (ans != -1) System.out.println(ans);
            } else if (cmd.equals("peek")) {
                int ans = mpq.peek();
                if (ans != -1) System.out.println(ans);
            } else if (cmd.equals("size")) {
                System.out.println(mpq.size());
            }
        }
    }
}
