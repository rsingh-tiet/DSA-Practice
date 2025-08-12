
import java.util.Scanner;

public class baseToBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the number's base");
        int b1 = scn.nextInt();
        System.out.println("enter the number");
        int num = scn.nextInt();
        System.out.println("enter the base in which u want to convert");
        int b2 = scn.nextInt();
        scn.close();;

        System.out.println(driver( b1, num, b2));
    }
    public static int driver(int b1,int n,int b2) {
       int number;
       number = baseToDecimal(n, b1);
        // return 0 ;
        int number2;
        number2 = f(number, b2);
        return number2;
    }
    public static int baseToDecimal(int n, int b) {
        int decimalNum = 0;
        int counter = 0;  // Move outside the loop

        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            decimalNum += rem * (int) Math.pow(b, counter);
            counter++;

            // System.out.println(counter + " " + rem + " " + n + " " + decimalNum);
        }

        return decimalNum;
    }
    public static int f(int n,int b){
        int counter= 0;
        int conNUm=0;
        while(n>0){
          int rem=n%b;
          n=n/b;
          conNUm+=rem*(int)Math.pow(10, counter);
        //   System.out.print(conNUm+"->"); 
          counter++; 
        }

        return conNUm;

    }
}
