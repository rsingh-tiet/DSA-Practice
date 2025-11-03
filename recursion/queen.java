import java.util.Scanner;

public class queen {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the board size");
        int size = scn.nextInt();
        int[][] arr = new int[size][size];
        printQueen(arr,0,"");
        scn.close();
    }
    public static void printQueen(int[][] arr, int row, String ans){
        if(row == arr.length){
            System.out.println(ans);
            return;
        }
        for(int i = 0; i< arr.length;i++){
            if(isQueenSafe(arr,row,i)){
                arr[row][i] = 1;
                printQueen(arr, row+1, ans+" "+row+" "+i+" ");
                arr[row][i] = 0;
            }
        }
    }
    public static boolean isQueenSafe(int[][] arr,int row,int col){
        for(int i =row-1,j = col;i>=0;i--){
            if(arr[i][j] == 1){
                return false;
            }
        }
        for(int i = row,j = col;i>=0 && j>=0;i--,j--){
            if(arr[i][j] == 1){
                return false;
            }
        }
        for(int i= row,j = col;i>=0 && j<arr.length;i--,j++){
            if(arr[i][j] == 1){
                return false;
            }
        }
        return true;
    }
}
