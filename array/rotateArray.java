
import java.util.Scanner;

public class rotateArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter size");
        int a = scn.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter element "+i);
            arr[i] = scn.nextInt();    
            }

            for(int dog:arr){
                System.out.print(dog+" ");
            }
            System.out.println("\nenter k");
            int k = scn.nextInt();
            scn.close();
            k %=a;
            if(k<0){
                k+=arr.length;
            }
            System.out.println("k->"+k);
            // part 1 
            reverse(arr, 0, arr.length-k-1);
            // part 2
            reverse(arr, arr.length-k, arr.length-1);
            // part 3
            reverse(arr, 0, arr.length-1);
            System.out.println();
            for(int dog:arr){
                System.out.print(dog+" ");
            }

            

    }
    public static void reverse(int[] arr ,int i ,int j) {
        int temp;
        
        for ( ; i < arr.length/2; i++ ) {
            temp = arr[i];
            
            arr[i]=arr[j];
            arr[j] = temp;
            j--;

        }
    }
}
