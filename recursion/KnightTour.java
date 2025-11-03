import java.util.Scanner;

public class KnightTour {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the size pf board");
        int size = scn.nextInt();
        int[][] arr = new int[size][size];
        boolean[][] visited = new boolean[size][size];
        tour(arr, visited, 0, 0, "",1);
    }
    public static void tour(int[][] arr,boolean[][] visited,int row,int col,String ans,int move){
        if(row<0 || col <0 || row >=arr.length || col  >= arr.length || arr[row][col]>0){
            display(arr);
            return;
            
        }
        if(move == arr.length*arr[0].length){
            ans+=" "+row+col+" ";
            System.out.println(ans);
            arr[row][col] = 1;
            display(arr);
            return;
        }
        arr[row][col] =1;
        visited[row][col] = true;
        tour(arr, visited, row-2, col+1, ans+" "+row+col+" ",move+1);
        tour(arr, visited, row-1, col+2, ans+" "+row+col+" ",move+1);
        tour(arr, visited, row+1, col+2, ans+" "+row+col+" ",move+1);
        tour(arr, visited, row+2, col+1, ans+" "+row+col+" ",move+1);
        tour(arr, visited, row+2, col-1, ans+" "+row+col+" ",move+1);
        tour(arr, visited, row+1, col-2, ans+" "+row+col+" ",move+1);
        tour(arr, visited, row-1, col-2, ans+" "+row+col+" ",move+1);
        tour(arr, visited, row-2, col+1, ans+" "+row+col+" ",move+1);
        visited[row][col] = false;
        arr[row][col] =0;
    }
    public static void display(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}

