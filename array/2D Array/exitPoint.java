
import java.util.Scanner;

public class exitPoint {
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
        scn.close();
        System.out.println("array os:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

        int i = 0, j = 0 ,dir =0;
        while (true) { 
            dir += arr[i][j];
            dir = dir%4;

            if(dir ==0 ){//east go j++
                j++;
            }else if(dir==1){//south go i++
                i++;
            }else if(dir == 2){//west go j--
                j--;
            }else if(dir == 3){//north go i--
                i--;
            }
            // breaking condition
            if(i<0){//out of top
                i++;break;
            }else if(i==arr.length){//leaks to botton
                i--;break;
            }else if(j<0){//leaks to left
                j++;break;
            }else if(j==arr[0].length){//leaks to right
                j--;break;
            }
            
        }
        System.out.println("exit point is i->"+i+" j->"+j);
    }
}
