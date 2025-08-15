
import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter string 'it will check for all substring palin drome'");
        String s = "abccbc";
        // scn.nextLine();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String a = s.substring(i,j);
                if(checkPalin(a)== true){
                    System.out.println(a);
                }
            }
        }
    }
    public static boolean  checkPalin(String s){
        int i =0,j=s.length()-1;
        for (i = 0; i < j; i++,j--) {
            if(s.charAt(i) == s.charAt(j)){
                
            }
            else{
                return false;
            }
            
        }
        return true;
    }
}
