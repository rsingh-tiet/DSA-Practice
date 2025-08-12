
import java.util.Scanner;

public class basic{
    public static void main(String[] args) {
        System.out.println("enter rows");
        Scanner scn  = new Scanner(System.in);
        int r = scn.nextInt();
        System.out.println("enter columns");
        int c = scn.nextInt();
        int [][] arr = new int[r][c];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("enter element "+i+"-"+j);
                arr[i][j] = scn.nextInt();
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}