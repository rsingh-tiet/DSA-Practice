
import java.util.Scanner;

public class pattern3 {
    public static void main(String[] args) {
        // int a =5;
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        // int space = a-1;
        
        int space = a;
        // int star ;

        for (int i = 0; i < a; i++) {
            space--;
            /*// int star =0;
            // star+=1;*/
            System.out.println("\t".repeat(space)+"*\t".repeat(i+1));
            
            // System.out.println("");
            // for(int j= 0;j<=space;j++){
            //     System.out.print("\t");
            // }
            // for(int j= 0;j<=i;j++){
            //     System.out.print("*\t");
            // }

        }
    }
}
