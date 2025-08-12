
import java.util.Scanner;

public class benjaminBulb {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        scn.close();

        for (int i = 1; i*i <= a; i++) {
            System.out.print(i*i+",");
        }
    }
}
