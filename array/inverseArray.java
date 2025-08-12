
import java.util.Scanner;

public class inverseArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.err.println("enter size");
        int a = scn.nextInt();
        int[] arr = new int[a];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter element "+i);
            arr[i] = scn.nextInt();

        }
        for(int cat:arr){
            System.out.print(cat+" ");
        }
        int[] inv = new int[arr.length];
        for (int i = 0;i<arr.length;i++) {
            int ele ;
            ele = arr[i];
            inv[ele] = i;
        }
        System.out.println();
        for(int hippo:inv){
            System.out.print(hippo+" ");
        }
    }

}
