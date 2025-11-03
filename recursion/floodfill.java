// import java.sql.Array;
import java.util.Scanner;

public class floodfill {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter maze dimension");
        int row = scn.nextInt();
        int col = scn.nextInt();
        int maze[][] = new int[row][col];
        System.out.println("enter maze in binary ie 0/1");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("enter row "+(i+1) +" col "+(j+1));
                maze[i][j] = scn.nextInt();
            }
        }
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]+"\t");
            }
            System.out.println();
        }
        boolean[][] visited = new boolean[row][col];
        
        if(maze[0][0] == 0 && maze[maze.length-1][maze[0].length-1] == 0){
            path(maze, "", 0, 0,visited);
        }
        scn.close();
    }
    public static void path(int[][] maze,String ans,int row,int col,boolean[][] visited){
        if(row<0 || col<0 || row==maze.length || col==maze[0].length 
        || maze[row][col] ==1 || visited[row][col] == true){
            return;
        }
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(ans);
            return;
        }
        visited[row][col] =true;
        path(maze, ans+"R", row, col+1,visited);
        path(maze, ans+"D", row+1, col, visited);
        path(maze, ans+"L", row, col-1, visited);
        path(maze, ans+"T", row-1, col, visited);
        visited[row][col] = false;
    }
}
