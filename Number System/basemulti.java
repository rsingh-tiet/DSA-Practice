import java.util.Scanner;

public class basemulti {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number 1:");
        int num1 = scn.nextInt();
        System.out.println("Enter base:");
        int b1 = scn.nextInt();
        System.out.println("Enter number 2:");
        int num2 = scn.nextInt();
        System.out.println("Enter number's base:");
        int b2 = scn.nextInt();
        scn.close();

        if (b1 != b2) {
            System.out.println("Cannot multiply directly, bases differ.");
            return;
        }

        int mulNum = 0;
        int count2 = 0;

        while (num2 > 0) {
            int d2 = num2 % 10;
            num2 /= 10;

            int dubNum = num1;
            int intNum = 0;
            int place = 1;
            int carry = 0;

            while (dubNum > 0 || carry > 0) {
                int d1 = dubNum % 10;
                dubNum /= 10;

                int prod = d1 * d2 + carry;
                carry = prod / b1;
                prod = prod % b1;

                intNum += prod * place;
                place *= 10;
            }

            // Shift intNum to left by count2 digits (position of d2 in num2)
            intNum *= Math.pow(10, count2);

            // Add the result into mulNum (base addition)
            mulNum = addInBase(mulNum, intNum, b1);

            count2++;
        }

        System.out.println("Final Answer in base " + b1 + " => " + mulNum);
    }

    public static int addInBase(int n1, int n2, int base) {
        int result = 0;
        int carry = 0;
        int place = 1;

        while (n1 > 0 || n2 > 0 || carry > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 /= 10;
            n2 /= 10;

            int sum = d1 + d2 + carry;
            carry = sum / base;
            sum = sum % base;

            result += sum * place;
            place *= 10;
        }

        return result;
    }
}
