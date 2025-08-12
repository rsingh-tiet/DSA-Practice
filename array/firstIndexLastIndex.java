
import java.util.Scanner;

public class firstIndexLastIndex {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the sie ");
        int a = scn.nextInt();
        int[] arr = new int[a];

        for (int idx = 0; idx < arr.length; idx++) {
            System.out.println("enter ele "+idx);
            arr[idx] = scn.nextInt();
        }
        for(int cat:arr){
            System.out.print(cat +" ");
        }
        System.out.println();
        System.out.println("enter the element which index to be noted");
        int k = scn.nextInt();
        int Ist=0,count=0,last =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==k){
                if(count ==0){
                    Ist = i;
                }
                count++;
                if(count!=0){
                    last = i;
                }
            }
        }
        System.out.println("the first index of "+k+" element is :"+Ist+" & last is "+last);
        System.out.println("in human indexes");
        Ist++;last++;
        System.out.println("the first index of "+k+" element is :"+Ist+" & last is "+last);
        
    }
}
