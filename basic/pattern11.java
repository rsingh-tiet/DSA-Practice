
import java.util.Scanner;

public class pattern11 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a= scn.nextInt();
        scn.close();
        int count=1;
        for (int i = 0; i <=a; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(count+"\t");
                count++;
            }
            System.out.println();
            
        }
    }
}
