import java.util.Scanner;

public class rotate90 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter no of row");
        int row = scn.nextInt();
        // System.out.println("enter noeof col");
        // int col = scn.nextInt();
        int[][] arr = new int[row][row];

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

        //ttranpose
        for (int i = 0; i < arr.length; i++) {
            for(int j=i;j<arr[0].length;j++) {
                int temp;
                temp = arr[i][j] ;
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        // reverse
        for (int i = 0; i < arr.length; i++) {
            int z = arr[0].length-1,temp;
            for (int j = 0; j < arr[0].length/2; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[i][z];
                arr[i][z] = temp;
                z--;
            }
        }
        System.out.println("array is:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
