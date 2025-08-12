import java.util.Scanner;

public class diagonalTraversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter no of row");
        int row = scn.nextInt();
        System.out.println("enter no of col");
        int col = scn.nextInt();
        int[][] arr = new int[row][col];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println("enter row no "+(i+1)+" col no "+(j+1));
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();
        System.out.println("array is:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("diagonal are :");
        for (int z = 0; z < arr[0].length; z++) {
            for (int i = 0,j=z; i < arr.length&&j<arr[0].length; i++,j++) {
                System.out.println(arr[i][j]);
            }
        }
        // for (int z = 0; z < arr[0].length; z++) {
        //     for (int i = 0; i < arr.length; i++) {
        //         for (int j = 0; j < arr[0].length; j++) {
        //             if(i-j == z){
        //                 System.out.println(arr[i][j]);
        //             }
        //         }
        //     }
        // }
       
        
    }
}
