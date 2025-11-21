import java.util.PriorityQueue;

public class basic {
    public static void kSorted(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
                pq.add(arr[i]);   
        }
        for (int i = k+1; i < arr.length; i++) {
            System.out.print(pq.remove()+"\t");
            pq.add(arr[i]);
        }
        while(pq.size()>0){
            System.out.print(pq.remove()+"\t");
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int[] arr = {1,2,3,4,5,6,7,8,9,0};
        // for (int i = 0; i < arr.length; i++) {
        //     pq.add(arr[i]);
        // }
        // while (!pq.isEmpty()) {
        //     System.out.println(pq.peek());
        //     pq.remove();
        // }
        int[] arr = {2,3,1,4,6,5,7,8,9};
        int k = 2;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        kSorted(arr, k);

    }
}
