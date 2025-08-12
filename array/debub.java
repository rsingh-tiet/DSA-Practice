import java.util.Scanner;
public class debub {
    


    public static void main(String[] args) {
        System.out.println("Assumption: First number is greater or equal to second number.");
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter size of first number:");
        int a = scn.nextInt();

        System.out.println("Enter size of second number:");
        int b = scn.nextInt();

        int[] arr1 = new int[a];
        int[] arr2 = new int[b];

        for (int i = 0; i < arr1.length; i++) {
            System.err.print("Enter element " + i + " of number 1: ");
            arr1[i] = scn.nextInt();
        }

        for (int i = 0; i < arr2.length; i++) {
            System.err.print("Enter element " + i + " of number 2: ");
            arr2[i] = scn.nextInt();
        }

        int[] diff = new int[a];

        int carry = 0;
        int i = a - 1, j = b - 1, k = a - 1;

        for (; k >= 0; k--) {
            int sub = (j >= 0) ? arr2[j] : 0;
            int dig = (i >= 0) ? arr1[i] + carry : carry;

            if (dig >= sub) {
                dig -= sub;
                carry = 0;
            } else {
                dig += 10 - sub;
                carry = -1;
            }

            diff[k] = dig;

            i--;
            j--;
        }

        // Print result without leading zeros
        boolean leadingZero = true;
        for (int d : diff) {
            if (d != 0) leadingZero = false;
            if (!leadingZero) System.out.print(d);
        }
        if (leadingZero) System.out.print(0); // all zero case
        System.out.println();
    }
}

