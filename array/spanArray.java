
import java.util.Scanner;

public class spanArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        System.out.println("enter n/ size of arr");
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int n1= 0;n1<arr.length;n1++){
            System.out.println("enter the element"+n1);
            arr[n1] = scn.nextInt();
        }
        for(int i = 0 ; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        for(int i = 0;i<arr.length;i++){
            if(max > arr[i]){//min element
                max = arr[i];
                System.out.println("min is ->"+max);
            }
            if(min<arr[i]){// max
                min = arr[i];
                System.out.println("max is -> "+min);
            }
        }
        int span = min - max;
        System.out.println(span);
        
    }
}
