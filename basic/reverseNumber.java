
import java.util.Scanner;

public class reverseNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int dub =a;
        scn.close();
        int reverse;int count=0;int number;
        while(a>0){
            reverse=a%10;
            a=a/10;count++;
            System.out.print(reverse);
        }
        System.out.println();
        // for printing that number
        System.out.println(count);
        int div;
        div = (int)Math.pow(10, count-1);
        while(div!=0){  
        div = (int)Math.pow(10, count-1);
        count--;
        number = dub/div;
        dub=dub%(int)div;
        System.out.print(number+" ");
        }

    }
}
