import java.util.*;

public class reverseArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print(" enter the size of array ->");
        int a = scn.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            System.out.println("enter element "+i);
            arr[i] = scn.nextInt();
        }
        for(int val:arr){
            System.out.print(val+" ");
        }
        System.out.println("\nreverse is");
        int temp,j=arr.length-1;
        for (int i = 0; i < arr.length/2; i++) {
            temp = arr[i];
            
            arr[i]=arr[j];
            arr[j] = temp;
            j--;

        }
        for(int val:arr){
            System.out.print(val+" ");
        }
    }
    
}
