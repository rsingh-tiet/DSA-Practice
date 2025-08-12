
import java.util.Scanner;

public class pattern17 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        scn.close();
        int count=1;

        for (int i = 0; i <a; i++) {
            if(i<a/2){
                for (int j = 0; j < a/2; j++) {
                    System.out.print("\t");

                }
                System.out.println("*\t".repeat(count));

                // for (int j = 1; j <=a/2; j++) {
                //     System.out.print("*\t");
                // }
                count++;
            }
            else if(i==a/2){
                for (int j = 0; j < a; j++) {
                    System.out.print("*\t");
                }
            }
            else{
                count--;
                for (int j = 0; j < a/2; j++) {
                    System.out.print("\t");

                }
                System.out.println("*\t".repeat(count));
            }
            System.out.println();
            
        }
    }
}
