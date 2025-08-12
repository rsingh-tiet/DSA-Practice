
import java.util.Scanner;

public class pattern9 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        scn.close();
        for (int i = 1; i <= a; i++) {
            for(int j=1;j<=a;j++){
                if(i==j || i+j == a+1){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
