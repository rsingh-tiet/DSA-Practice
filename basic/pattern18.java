
import java.util.Scanner;

public class pattern18 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int star = a;
        int os =0;

        for (int i = 1; i <= a; i++) {
            // System.out.print("\t".repeat(os));
            for (int j = 1; j <= os; j++) {
                System.out.print("\t");
            }
            // System.out.print("*\t".repeat(star));
            for (int j = 1; j <= star; j++) {
                if(i>1 && i<=a/2 && j>1 && j<star){
                    System.out.print("\t");
                }
                else{
                    System.out.print("*\t");
                }
            }
            if(i<=a/2){
                os++;
                star-=2;
            }
            else{
                os--;
                star+=2;
            }
            System.out.println();
        }
    }
}
