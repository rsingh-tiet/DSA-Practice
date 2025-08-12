import java.util.Scanner;

public class barChart {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter size");
        int a = scn.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter"+i);
            arr[i] = scn.nextInt();
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i]){
                max = arr[i];
            }
        }

        for(int floor = max; floor>0;floor--){
            for(int build = 0;build<arr.length;build++){
                if(arr[build]>=floor){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

    }
}
