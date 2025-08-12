
import java.util.Scanner;

public class downwardSpiral {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter row no");
        int row = scn.nextInt();
        System.out.println("enter col no");
        int col = scn.nextInt();

        int[][] arr = new int[row][col];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println("enter row no "+(i+1)+" col no "+(j+1));
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();
        System.out.println("array os:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println("traversed:");

        int top=0,bottom = arr.length-1,left = 0, right = arr[0].length-1;

        while(top<=bottom || right>= left){
            for (int i = top; i <=bottom ; i++) {
                System.out.print(arr[i][left]+"\t");
            }
            left++;
            for (int j = left; j <= right; j++) {
                System.out.print(arr[bottom][j]+"\t");
            }
            bottom--;
            
            for (int i = bottom; i >=top; i--) {
                System.out.print(arr[i][right]+"\t");
            }
            right--;
            for (int j = right; j >= left; j--) {
                System.out.print(arr[top][j]+"\t");
            }
            top++;
        }
    }
}
