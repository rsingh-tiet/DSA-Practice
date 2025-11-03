import java.util.ArrayList;
import java.util.Scanner;

public class mazePath {
    public static ArrayList<String> path(int r,int c,int row,int col){
        if(r == row && c == col){
            ArrayList<String> intAns = new ArrayList<>();
            intAns.add("");
            return intAns;
        }
        // if(r>row || c> col){{
        //     ArrayList<String> intAns = new ArrayList<>();
        //     // intAns.add("");
        //     return intAns;
        
        // }}
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> path1 =  new ArrayList<>();
        ArrayList<String> path2 = new ArrayList<>();
        ArrayList<String> path3 = new ArrayList<>();
        
        if(r<row && c<col){
            path3 = path(r+1, c+1,row,col);
            for (String key : path3) {
                ans.add('D'+key);
            }  
        }
         if(r<row){
            path2 = path(r+1, c,row,col);
            for (String key : path2) {
                ans.add('V'+key);
            }
        }
         if(c<col){
            path1 = path(r, c+1,row,col);
            for (String key : path1) {
                ans.add('H'+key);
            }
        }
        
        return ans;
    }
    public static void printMazePath(int r,int c,int row,int col,String ans){
        if(r == row && c == col){
            System.out.println(ans);
            return;
        }
        if(r<row){
            printMazePath(r+1, c, row, col, ans+"V");
        }if(c<col){
            printMazePath(r, c+1, row, col, ans+"H");
        }if(r<row && c<col){
            printMazePath(r+1, c+1, row, col, ans+"D");
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter maze dimen row x col");
        int row = scn.nextInt();
        int col = scn.nextInt();
        ArrayList<String> res = path(1,1,row, col);
        System.out.println(res);
        printMazePath(1, 1, row, col, "");
        scn.close();
    }
}
