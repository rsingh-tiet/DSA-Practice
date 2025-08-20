
import java.util.Scanner;

public class asciiDifference {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        scn.nextLine();
        scn.close();
        System.out.println(helper(s));
    }
    public static String helper(String s) {
        StringBuilder sb = new StringBuilder("");
        sb.append(s.charAt(0));
        int diff;
        for (int i = 1; i < s.length(); i++) {
            diff = (int)(s.charAt(i)-s.charAt(i-1));
            sb.append(diff);
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
