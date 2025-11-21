import java.util.PriorityQueue;
import java.util.Scanner;

public class kLargest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("ebter size");
        int k = scn.nextInt();
        int[] arr = {1,4,2,7,45,23,48,9,78,12};
        for (int i = 0; i < arr.length; i++) {
            while(k>0){
                pq.add(arr[i]);
                k--;
            }
            if(pq.peek()<arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        System.out.println("k largest:"+pq);
    }
}
