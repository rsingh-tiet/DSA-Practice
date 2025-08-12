
import java.util.Scanner;

public class pattern7 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        scn.close();
        // int space = 0;
        // int star =1;
        for (int i = 0; i < a; i++) {
            System.out.println("\t".repeat(i)+"*");
        }
    }
}
