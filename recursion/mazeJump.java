import java.util.ArrayList;
import java.util.Scanner;

public class mazeJump {
    public static ArrayList<String> path(int r,int c,int row ,int col){
        if(r == row && c == col){
            ArrayList<String> intAns = new ArrayList<>();
            intAns.add("");
            return intAns;
        }
        if(r>row || c>col){
            ArrayList<String> intAns = new ArrayList<>();
            // intAns.add("");
            return intAns;
        
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int h = 1; h <=col-c;h++ ){
            ArrayList<String> hpath = path(r, c+h, row, col);
            for (String key : hpath) {
                ans.add("H"+h+key);
            }
        }
        for(int v = 1; v <=row-r;v++ ){
            ArrayList<String> vpath = path(r+v, c, row, col);
            for (String key : vpath) {
                ans.add("V"+v+key);
            }
        }
        for(int h=1,v = 1; h <=row-r && v<= col -c;h++,v++ ){
            ArrayList<String> dpath = path(r+h, c+h, row, col);
            for (String key : dpath) {
                ans.add("D"+h+key);

            }
        }
        return ans;
    }
    public static void printMazeJumo(int r,int c,int row,int col,String ans){
        if(r == row && c == col){
            System.out.println(ans);
            return;
        }
        // if(r>row || c>col){
        //     return;
        // }
        
            for (int hjump = 1; hjump <= col-c; hjump++) {//starts from 1 as zero will put it in infinite loop
                printMazeJumo(r, c+hjump, row, col, ans+"H"+hjump);
            }
        
            for (int vjump = 1; vjump <= row-r; vjump++) {
                printMazeJumo(r+vjump, c, row, col, ans+"V"+vjump);
            }
            for (int hjump = 1,vjump =1; vjump<=row-r && hjump<= col-c ; hjump++,vjump++) {
                printMazeJumo(r+vjump, c+hjump, row, col, ans+"D"+hjump);
            }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter maze dimen row x col");
        int row = scn.nextInt();
        int col = scn.nextInt();
        ArrayList<String> res = path(1,1,row, col);
        System.out.println(res);
        printMazeJumo(1, 1, row, col, "");
        scn.close();
    }
}

// import java.util.ArrayList;
// import java.util.Scanner;

// public class mazeJump {
//     public static ArrayList<String> path(int r,int c,int row ,int col){

//         // ✅ destination reached
//         if(r == row && c == col){
//             ArrayList<String> base = new ArrayList<>();
//             base.add("");
//             return base;
//         }

//         // ✅ out of boundary
//         if(r > row || c > col){
//             return new ArrayList<>();
//         }

//         ArrayList<String> ans = new ArrayList<>();

//         // ✅ Horizontal jumps
//         for(int jump = 1; jump <= col - c; jump++){
//             for(String key : path(r, c + jump, row, col)){
//                 ans.add("H" + jump + key);
//             }
//         }

//         // ✅ Vertical jumps
//         for(int jump = 1; jump <= row - r; jump++){
//             for(String key : path(r + jump, c, row, col)){
//                 ans.add("V" + jump + key);
//             }
//         }

//         // ✅ Diagonal jumps
//         for(int jump = 1; jump <= row - r && jump <= col - c; jump++){
//             for(String key : path(r + jump, c + jump, row, col)){
//                 ans.add("D" + jump + key);
//             }
//         }

//         return ans;
//     }

//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         System.out.println("enter maze dimen row x col");
//         int row = scn.nextInt();
//         int col = scn.nextInt();
        
//         // ✅ Start from (1,1) because grid uses 1-based positions here
//         System.out.println(path(1, 1, row, col));
//     }
// }
