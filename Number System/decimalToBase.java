import java.util.Scanner;
public class decimalToBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a = scn.nextInt();

        System.out.println(f(n,a));
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
