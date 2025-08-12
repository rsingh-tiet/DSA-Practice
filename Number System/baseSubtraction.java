
import java.util.Scanner;

public class baseSubtraction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter greator number");
        int num1 = scn.nextInt();
        System.out.println("enter num's base");
        int b1 = scn.nextInt();
        System.out.println("enter smaller num");
        int num2 = scn.nextInt();
        System.out.println("enter num's base");
        int b2 = scn.nextInt();
        scn.close();

        if(b1!=b2){
            System.err.println("error");
            return;
        }
        if(num1<num2){
            System.err.println("err...  ..");
        }
        else{
            // System.out.println("in else");
            int n1, n2,count=0,digit,carry=0,rv=0;
            // System.out.println(" "+count);
            while(num1>0){
                n1  = num1%10;
                num1/=10;
                n2 = num2%10;
                num2/=10;
                n1 +=carry;
                if(n1>=n2){
                    carry= 0;
                    digit = n1-n2;
                }
                else{carry=-1;
                digit = n1-n2+b1;}
                rv +=digit*(int)Math.pow(10, count);
                System.out.println("rv->"+rv+"carry->"+carry);
                count++;
            }
            System.out.println(rv);
        }

    }
}
