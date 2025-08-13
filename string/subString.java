
import java.util.Scanner;

public class subString {
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        String a = scn.nextLine();
        
        for (int i = 0; i < a.length(); i++) {
            for (int j = i+1; j <=a.length(); j++) {
                System.out.println(a.substring(i,j));
            }
        }
    }
}
