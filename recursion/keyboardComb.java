import java.util.ArrayList;
import java.util.Scanner;

public class keyboardComb {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter comb number");
        String s = scn.next();
        ArrayList<String> res = keyComb(s);
        System.out.println(res);
        printKeyboardComb(s, "");
        scn.close();
    }
    static String[] keypad = {
        ".",    // 0    
        "abc",   // 1 (or "" depending on your problem)
        "def",  // 2
        "ghi",  // 3
        "jkl",  // 4
        "mno",  // 5
        "pqrs", // 6
        "tuv",  // 7
        "wxyz",  // 8
        "/*+-" //9
    };
    public static void printKeyboardComb(String s, String ans){
        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        String rest = s.substring(1);
        String key = keypad[ch-'0'];
        int length = key.length();
        for (int i = 0; i < length; i++) {
            char currOption = key.charAt(i);
            printKeyboardComb(rest, ans+currOption); 

        }
    }
    public static ArrayList<String> keyComb(String s){
        if(s.isEmpty()){
            ArrayList<String> intAns = new ArrayList<>();
            intAns.add("");
            return intAns;
        }
        char ch = s.charAt(0);
        String rest = s.substring(1);

        ArrayList<String> result = keyComb(rest);
        
        String key = keypad[ch-'0'];
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < key.length(); i++) {
            char curr = key.charAt(i);
            for (String val : result) {
                ans.add(curr+val);
            }
        }

        return ans;
    }
}
