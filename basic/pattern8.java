import java.util.Scanner;

public class pattern8 {
// in this the diagonal i +j = n+1(j is the second loop which is shown in .repeat(count))
    public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int a = scn.nextInt();
         for (int i = a-1; i >= 0; i--) {
             System.out.println("\t".repeat(i)+"*");
         }

    }
}
