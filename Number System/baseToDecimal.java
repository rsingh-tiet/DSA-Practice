import java.util.Scanner;

public class baseToDecimal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("base");
        int base = scn.nextInt();
        System.out.println("number");

        int num = scn.nextInt();
        scn.close();

        System.out.println(logic(num, base));
    }

    public static int logic(int n, int b) {
        int decimalNum = 0;
        int counter = 0;  // Move outside the loop

        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            decimalNum += rem * (int) Math.pow(b, counter);
            counter++;

            System.out.println(counter + " " + rem + " " + n + " " + decimalNum);
        }

        return decimalNum;
    }
}
