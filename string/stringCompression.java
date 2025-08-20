
import java.util.Scanner;

public class stringCompression {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        scn.nextLine();
        scn.close();
        StringBuilder sb = new StringBuilder("");
        StringBuilder sb2 = new StringBuilder("");
        sb.append(s.charAt(0));
        sb2.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i-1)!=s.charAt(i)){
                sb.append(s.charAt(i));
            }
        }

        // 2nd tech
        int count=1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i-1)==s.charAt(i)){
                count++;
            }
            if(s.charAt(i-1)!=s.charAt(i)){
                if(count>1){
                     sb2.append(count);
                }
                sb2.append(s.charAt(i));
                count=1;
            }
        }
        if(count>1){
            sb2.append(count);
        }
        System.out.println(sb);
        System.out.println(sb2);
    }
}
