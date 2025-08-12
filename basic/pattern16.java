
import java.util.Scanner;

public class pattern16 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        scn.close();
        int val=1;
        int inrsp = 2*a-3;
        for (int i = 1; i <=a; i++) {
            int inrval=1;
            
            for (int j = 1; j <= val; j++) {
                
                System.out.print(inrval+"\t");
                
                    inrval+=1;
            }
            for (int j = 1; j <= inrsp; j++) {
                System.err.print("*\t");
            }
            if(i==a){val-=1;
            inrval--;
            }
            for (int j = 0; j < val; j++) {
                inrval--;
                System.out.print(inrval+"\t");
            }
            // if (i != a - 1) {
            //     for (int j = 0; j < val; j++) {
            //         System.out.print(inrval + "\t");
            //     }
            // }
            
            System.out.println();
            
            val++;
            inrsp-=2;
        }
    }
}
