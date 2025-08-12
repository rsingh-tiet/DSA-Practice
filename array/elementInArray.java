
import java.util.Scanner;

public class elementInArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter size");
        int a = scn.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter"+i);
            arr[i] = scn.nextInt();
        }
        // scn.close();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("find");
        int b = scn.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if(b == arr[i]){
                System.out.println(++i);
                return;
            }
        }
        
    }
}
