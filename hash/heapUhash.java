import java.util.ArrayList;
import java.util.Scanner;

public class heapUhash {
    public static class  priorityQ {
        ArrayList<Integer> data;
        public priorityQ(){
            data = new ArrayList<>();
        }
        public void add(int val){

        }
        public int remove(){
            return -1;
        }
        public int peek(){
            return -1;
        }
        public int size(){
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        priorityQ pq = new priorityQ();

        while (true) {
            String cmd = sc.next();

            if (cmd.equals("quit")) {
                break;
            } else if (cmd.equals("add")) {
                int val = sc.nextInt();
                pq.add(val);
            } else if (cmd.equals("remove")) {
                int ans = pq.remove();
                if (ans != -1) System.out.println(ans);
            } else if (cmd.equals("peek")) {
                int ans = pq.peek();
                if (ans != -1) System.out.println(ans);
            } else if (cmd.equals("size")) {
                System.out.println(pq.size());
            }
        }
        sc.close();
    }
}
