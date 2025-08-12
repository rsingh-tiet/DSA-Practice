import java.util.Scanner;

public class multiplication {
    public static void main(String arg[]){
        Scanner scn = new Scanner(System.in);
        System.out.println("enter matrix'1 row'size ");
        int r1 = scn.nextInt();
        System.err.println("enter matrix'1 col'size ");
        int c1 = scn.nextInt();
        System.out.println("enter matrix'2 row'size");
        int r2 = scn.nextInt();
        System.out.println("enter matrix'2 col'size");
        int c2 = scn.nextInt();

        if(c1!=r2){System.out.println("ha ha that's funny");return;}
        int[][] arr1 = new int[r1][c1];
        int[][] arr2 = new int[r2][c2];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.err.println("enter row "+i+" col "+j);
                arr1[i][j] = scn.nextInt();
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.err.print(arr1[i][j]+"\t"); 
            }
            System.out.println();
        }
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                System.err.println("enter row "+i+" col "+j);
                arr2[i][j] = scn.nextInt();
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                System.err.print(arr2[i][j]+"\t"); 
            }
            System.out.println();
        }

        System.out.println("multiplication of matrix :");
        int[][] mul = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < mul.length; i++) {
            for(int j = 0;j<mul[0].length;j++){
                for (int k = 0; k < arr2.length; k++) {
                    mul[i][j] += arr1[i][k]*arr2[k][j]; 
                }
            }
        }
        for (int i = 0; i < mul.length; i++) {
            for (int j = 0; j < mul[0].length; j++) {
                System.err.print(mul[i][j]+"\t"); 
            }
            System.out.println();
        }
        
    }
}
