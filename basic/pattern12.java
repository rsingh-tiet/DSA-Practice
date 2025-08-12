
import java.util.Scanner;

public class pattern12 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a= scn.nextInt();
        int ist= 0;
        int scnd=1;

        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= i; j++) {
                
                System.out.print(ist+"\t");
                int fibo = ist+scnd;
                ist=scnd;
                scnd = fibo;
            }
            System.out.println();
        }


    }
}
