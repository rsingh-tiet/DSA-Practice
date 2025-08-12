
import java.util.Scanner;

public class sum2array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter size 1");
        System.out.println("enter size 2");
        int a = scn.nextInt();
        int b = scn.nextInt();

        int[] arr1 = new int[a]; 
        int[] arr2= new int[b];

        for (int i = 0; i < arr1.length; i++) {
            System.err.println("enter element"+i);
            arr1[i] = scn.nextInt();
        }
        System.out.println("--");
        for (int i = 0; i < arr2.length; i++) {
            System.err.println("enter element"+i);
            arr2[i] = scn.nextInt();
        }
        for (int i = 0; i < arr1.length; i++) {
            System.err.print(arr1[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.err.print(arr2[i]+" ");   
        }
        System.out.println();
        int min;
        if(a<b){
            min = a;
        }
        else{min = b;}
        int[] add = new int[min];
        for (int i = 0; i < add.length; i++) {
            add[i] = arr1[i]+arr2[i];
        }
        for (int i = 0; i < add.length; i++) {
            System.err.print(add[i]+" ");
    
        }



    }
}
