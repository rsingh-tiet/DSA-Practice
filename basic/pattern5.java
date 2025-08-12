
import java.util.Scanner;

public class pattern5 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int space=a/2 ;
        int star =1;
        for (int i = 0; i < a; i++) {
            if(i<a/2){
                System.out.println("\t".repeat(space)+"*\t".repeat(star));
                // System.out.print(space+"\t"+star);
                // System.out.println("");
                space--;
                star+=2;
            }
            else{
                // System.out.println("");
                // System.out.print(space+"\t"+star);
                System.out.println("\t".repeat(space)+"*\t".repeat(star));
                space++;
                star-=2;
            }
        }
    }
}