
import java.util.Scanner;

public class pattern4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int space=0;
        int star = a;
        for(int i=1;i<=a;i++){
            for(int j=1;j<=space;j++){System.out.print("\t");}
            //  System.out.println(i);
            // System.out.print(space);
            for(int j=1;j<=star;j++){System.out.print("*\t");}
            
            space++;
            star--;
            System.out.println("");
            
        }
    }
}
