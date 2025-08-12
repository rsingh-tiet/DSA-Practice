
import java.util.Scanner;

public class subsetArray {
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
        System.out.println("subst are");
        int limit = (int)Math.pow(2, arr.length);
        for (int i = 0; i < limit; i++) {
            int temp = i;
            String s ="";
            for ( int j = arr.length-1; j >= 0; j--) {
                int rem = temp%2;
                temp/=2;
                if(rem == 0){
                    s = "-"+s; 
                }
                else{
                    s = arr[j]+s; 
                }
            }
            System.out.println(s);
        }
        
    }
}
