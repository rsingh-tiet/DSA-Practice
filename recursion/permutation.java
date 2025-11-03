import java.util.ArrayList;
import java.util.Scanner;

public class permutation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the word for its permutation");
        String s = scn.next();
        printPermutation(s,"");
        ArrayList<String> res = permutation(s);
        System.out.println(res);
        scn.close();
    }
    public static void printPermutation(String s,String ans){
        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String rest = s.substring(0, i)+s.substring(i+1);
            printPermutation(rest, ans+ch);
        }
    }
    public static ArrayList<String> permutation(String s){
        ArrayList<String> ans = new ArrayList<>();
        if(s.isEmpty()){
            ArrayList<String> intAns = new ArrayList<>();
            intAns.add("");
            return intAns;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String rest = s.substring(0, i)+s.substring(i+1);
            ArrayList<String> result = permutation(rest);
            for (String key : result) {
                ans.add(ch+key);
            }
        }
        return ans;
    }
}
