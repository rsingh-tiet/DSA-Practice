
import java.util.Scanner;

public class pattern13 {
    public static void main(String[] args) {
        Scanner  scn = new Scanner(System.in);
        int a= scn.nextInt();
        scn.close();

        for (int i = 0; i <= a; i++) {
            int icj=1;
            for (int j = 0; j <= i; j++) {
                
                int icjpi;
                System.out.print(icj+"\t");
                icjpi = icj*(i-j)/(j+1);
                icj = icjpi; 
            }
            System.err.println();
        }
    }
}
