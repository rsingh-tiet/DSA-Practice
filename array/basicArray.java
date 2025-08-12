
import java.util.Scanner;

public class basicArray{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter aray length");
        int a = scn.nextInt();
        int [] arr1 = new int[a];
        int [] arr2 = arr1;
        for(int n= 0;n<arr1.length;n++){
            System.out.println("enter the element"+n);
            arr1[n] = scn.nextInt();
        }
        arr2[0]  = 456;
        for(int i = 0 ; i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
        
        System.out.println();
        for(int i = 0 ; i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }

        int[] arr;

        arr = new int[5];
        arr[0] = 33;
        arr[1] = 47;
        arr[2] = 45;
        arr[3] = 67;
        arr[4] =98;

        int[] two =  arr;
        two[2] = 590;

       for(int i = 0; i < arr.length; i++){
        System.out.print(arr[i]);
        }
        swap(arr1,4,2);
        for(int i = 0 ; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
    public static void swap(int[] arr,int i,int j) {
        int temp = arr[j];
        arr[j]  = arr[i];
        arr[i] = temp;
    }
}