
import java.util.Scanner;

public class subArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("eneter size of array");
        int a = scn.nextInt();
        int[] arr = new int[a];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter element "+i);
            arr[i] = scn.nextInt();
        }
        System.out.println("arr is :");
        for (int idx = 0; idx < arr.length; idx++) {
            System.out.print(arr[idx]+"\t");
        }
        System.out.println("sub array are:");
        for (int i = 0; i < arr.length; i++) {
            for(int j =i;j<arr.length;j++){
                for(int k =i;k<=j;k++){
                    System.out.print(arr[k]+"\t");
                }
                System.out.println();
            }
        }

    }
}
