import java.util.ArrayList;
import java.util.Scanner;

public class stairPath {
    public static ArrayList<String> path( int s , int imt){
        if(s < 0){
            ArrayList<String> intAns = new ArrayList<>();
            // intAns.add("");
            return intAns;
        
        }
        if(s == 0){
            ArrayList<String> intAns = new ArrayList<>();
            intAns.add("");
            return intAns;
        
        }
        ArrayList<String> ans = new ArrayList<>();

        ArrayList<String> path1 = path(s-1,0);
        for (String key : path1) {
            ans.add(1+key);
        }
        ArrayList<String> path2 = path(s-2,0);
        for (String key : path2) {
            ans.add(2+key);
        }
        ArrayList<String> path3 = path(s-3,0);
        for (String key : path3) {
            ans.add(3+key);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter floors");
        int s = scn.nextInt();
            ArrayList<String> res = path(s, 0);
            System.out.println(res);
           
        
    }
}
