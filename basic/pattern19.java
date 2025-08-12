
import java.util.Scanner;

public class pattern19 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        scn.close();

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                if(i==1 && (j==a||j<=a/2+1 )){
                    System.out.print("*\t");
                }
                else if(i<=a/2 && (j==a||j==a/2+1)){
                    System.out.print("*\t");
                }
                else if (i==a/2+1) {
                    System.out.print("*\t");
                }
                else if(i>a/2+1 && (j==1|| j==a/2+1)){
                    System.out.print("*\t");
                }
                else if (i==a && (j==1||j>=a/2+1)) {
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
                
            }
            System.out.println();
        }
    }
}
