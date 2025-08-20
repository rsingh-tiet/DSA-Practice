
import java.util.Scanner;
import javax.swing.border.SoftBevelBorder;

public class permutationString {
    public static void main(String[] args) {
        // System.out.println(factorial(3));
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        scn.close();
        permutationHelper(s);

    }
    public static int factorial(int n) {
        
        for (int i = n-1; i >=1; i--) {
            n*=i;
        }
        
        return n;
    }
    public static void permutationHelper(String s) {
        
        int n= factorial(s.length());
        for (int i = 0; i <n ; i++) {
            StringBuilder sb = new StringBuilder(s);
            for (int j = sb.length(); j >0; j--) {
                int temp_i =i;
                int ptr = temp_i%j;
                temp_i/=j;
                System.out.print(sb.charAt(ptr));
                sb.deleteCharAt(ptr);


            }
            System.out.println(i+" ");

        }
    
    }
}
