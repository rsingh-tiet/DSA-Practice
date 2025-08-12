
import java.util.Scanner;

public class inverseNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        scn.close();

        int count=1;
        int inv=0;


        while(num>0){
        int temp;
        temp = num%10;
        inv = inv+count*(int)Math.pow(10, temp-1);
        num = num/10;
        count++;
        System.out.println(num+"  "+inv+"*");
        }
        System.out.println(inv);
    }
}
