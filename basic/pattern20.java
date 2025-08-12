
import java.util.Scanner;

public class pattern20 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                if (j==1 ||j==a || (i==j && i>a/2)||((i+j==a+1)&&(i>a/2))) {
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
