
import java.util.Scanner;

public class pattern1{
    public static void main(String[] args) {
        // int a=5;
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("*\t".repeat(i));
            // for(int j =0;j<i;j++){System.out.print("x");}
        }
    }
}


