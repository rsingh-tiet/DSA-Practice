
import java.util.Scanner;

public class printprime {
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        int a= scn.nextInt();
        scn.close();
        for (int i = 2; i < a; i++) {
            if(isprime(i)){
                System.out.print(i+"\t");
            }
        }
    }
    public static boolean isprime(int k){
        int count=0;boolean b = true;
        for (int i = 2; i*i < k; i++) {
            if(k%i == 0){
                count++;
            }
        }
        if(count>0){
            b = false;
        }
        return b;
    }
}
