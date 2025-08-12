
import java.util.Scanner;

public class pattern10 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int a= scn.nextInt();
        int os = a/2;
        int is = -1;

        for (int i = 1; i <= a; i++) {
            if(i<=a/2){
                // System.out.print(os+is);
                System.out.print("\t".repeat(os));
                System.out.print("*\t");
                for (int j = 0; j < is; j++) {
                    System.err.print("\t");
                } 
                // System.err.print("*");   
                os--;
                is+=2;
                if(i>1){
                    System.out.print("*\t");
                }
            }
            else{
                // System.out.print(os+is);
                System.out.print("\t".repeat(os));
                System.out.print("*\t");
                for (int j = 0; j < is; j++) {
                    System.err.print("\t");
                }
                if(i<a){
                    System.out.print("*\t");
                }
                // System.err.print("*");
                os++;
                is-=2;
            }
            System.out.println();
        }
    }
}
