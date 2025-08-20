
import java.util.Scanner;

public class toogleCase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String z = toogleCaseHelper(s);
        System.out.println(z);
    }
    public static String toogleCaseHelper(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch>='a'&& ch <='z') {//lower case to upper
                char upr = (char)('A'+ch-'a');
                sb.setCharAt(i, upr);
            }else if (ch>= 'A'&& ch <='Z') {//upper to lower
                char lwr = (char)('a'+ch-'A');
                sb.setCharAt(i, lwr);
            }
        }

        s= sb.toString();
        return s;
    }
}
