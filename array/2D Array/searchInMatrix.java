import java.util.Scanner;

public class searchInMatrix {
    public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
        System.out.println("enter  no of row");
        int r = scn.nextInt();
        System.out.println("enter  no of col");
        int col = scn.nextInt();
        int[][] arr = new int[r][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println("enter row "+(i+1)+" col "+(j+1));
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println("enter which is to be founded");
        int k = scn.nextInt();
        scn.close();
        System.out.println("array is");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        int i=0,j=arr[0].length-1;
        while(i<arr.length&&j>=0){
            {
                if(arr[i][j] == k){
                    System.out.println("founded at row "+(i+1)+" col "+(j+1));
                    return;
                }
                else if(arr[i][j]>k){
                    j--;
                }else if(arr[i][j]<k){
                    i++;
                }
                
            }
        }
        System.out.println("i am lazy");
    }
}
