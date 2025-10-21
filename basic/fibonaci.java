import java.util.Scanner;

public class fibonaci{
    public static void main(String Args[]){
        Scanner scn = new Scanner(System.in);
        System.out.println("enter upto which pos u want fibonaci");
        int n = scn.nextInt();
        int a = 0,b =1 ,c;
        System.out.println("0\n1");
        for(int i = 2; i< n;i++){
            c = a+b;
            System.out.println(c);
            a = b;
            b = c;
            c++;
        }

    }
}