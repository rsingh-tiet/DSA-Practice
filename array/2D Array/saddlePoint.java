
import java.util.Scanner;

public class saddlePoint {
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
        scn.close();
        System.out.println("array is");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println("saddle point ");
        int min = Integer.MAX_VALUE,max = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int MinI = 0;
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]<arr[i][MinI]){
                    MinI = j;
                }
                
            }
            boolean flag =true;
            for (int k = 0; k < arr.length; k++) {
                if(arr[k][MinI]>arr[i][MinI]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("saddle point is row "+(i+1)+" col "+(MinI+1)+" and is "+arr[i][MinI]);
                return;
            }
        }
        System.out.println("invalid input");
        
    }
}
