import java.util.Scanner;

public class reverse1D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter no of row");
        int row = scn.nextInt();
        System.out.println("enter noeof col");
        int col = scn.nextInt();
        int[][] arr = new int[row][col];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println("enter row no "+(i+1)+" col no "+(j+1));
                arr[i][j] = scn.nextInt();
            }
        }
        
        System.out.println("array os:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("enter the row which is to be fliped range 0-"+(arr.length-1));
        int k = scn.nextInt();
        scn.close();
        int temp,z = arr[0].length-1;
        for (int j = 0; j< arr[0].length/2; j++) {
            temp = arr[k][j];
            arr[k][j] = arr[k][z];
            arr[k][z] = temp;
            z--;
        }
        System.out.println("array os:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
