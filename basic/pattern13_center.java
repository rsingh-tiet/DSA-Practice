import java.util.Scanner;

public class pattern13_center {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        scn.close();

        for (int i = 0; i < a; i++) {
            // Print leading spaces to center-align
            for (int s = 0; s < a - i - 1; s++) {
                System.out.print("  "); // Two spaces for each gap
            }

            int icj = 1;
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", icj);  // Print number with width of 4
                icj = icj * (i - j) / (j + 1);
            }
            System.out.println();  // Move to next row
        }
    }
}
