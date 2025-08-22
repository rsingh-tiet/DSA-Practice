
import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a= scn.nextInt();
        for (int i = 0; i < a; i++) {
            int k = scn.nextInt();
            isprime(k);
        }

    }
    public static void isprime(int k){
        int count=0;
        for (int i = 2; i*i<k; i++) {
            if(k%i == 0){
                count++;
            }
        }
        if(count>0){
            System.out.println("not prime");
        }
        else{
            System.out.println("prime");
        }
    }
}
