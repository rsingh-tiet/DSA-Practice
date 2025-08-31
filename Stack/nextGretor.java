
import java.util.Scanner;

public class nextGretor {
    public static void main(String Args[]){
        Scanner scn  =new Scanner(System.in);
        System.out.println("enter array size");
        int[] arr = new int[scn.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter element-"+(i+1));
            arr[i] = scn.nextInt();
        }
        for(int dhatu:arr){
            System.out.print(dhatu+"\t");
        }
        System.out.println();
        // logic
        for (int i = 0; i < arr.length; i++) {
            int nextMax = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]>nextMax){
                    nextMax = arr[j];
                    break;
                }
            }
            System.out.println("next grator for "+arr[i]+" is-"+nextMax);
        }
    }
}
