
import java.util.Scanner;

public class waveTraversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the no of row");
        int row = scn.nextInt();
        System.out.println("enter the no of col");
        int col = scn.nextInt();
        int[][] arr = new int[row][col];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.err.println("enter row "+i+" col "+j);
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println("arr is:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("traversed:");
        int i=0;
        for (int j = 0; j < arr[0].length; j++) {
        if(j%2==0){
            i=0;
            while(i<arr.length){
                System.out.print(arr[i][j]+"\t");
                i++;
            }
        }
        if(j%2!=0){
            i=arr.length-1;
            while(i>-1){
                System.out.print(arr[i][j]+"\t");
                i--;
            }
        }
                          
        }

        }
    }

