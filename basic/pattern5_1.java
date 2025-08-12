import java.util.*;

public class pattern5_1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();  // Closing scanner to avoid resource leak

        int sp = n / 2;
        int st = 1;

        for (int i = 1; i <= n; i++) {
            // Printing spaces
            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }

            // Printing stars
            for (int j = 1; j <= st; j++) {
                System.out.print("*\t");
            }

            // Move to the next line
            System.out.println();

            // Update space and star counts
            if (i <= n / 2) {
                sp--;
                st += 2;
            } else {
                sp++;
                st -= 2;
            }
        }
    }
}
