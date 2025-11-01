import java.util.ArrayList;
import java.util.Scanner;

public class subsecquence {

    public static ArrayList subSecquence(String s){
        if(s.isEmpty()){
         ArrayList<String> intAns = new ArrayList<>();
         intAns.add("");
         return intAns; 
        }
        char ch = s.charAt(0);
        String restString = s.substring(1);
        ArrayList<String> result = subSecquence(restString);

        ArrayList<String> ans = new ArrayList<>();
        for (String val : result) {
            ans.add(""+result);
            ans.add(ch+restString);
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the string");
        
        String s = new String();
        s = scn.next();
        ArrayList<String> result = subSecquence(s);
        System.out.println(result);
    }
}
