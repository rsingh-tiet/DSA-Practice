
import java.util.Scanner;

public class pattern15 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a= scn.nextInt();
        scn.close();

        for (int i = 0; i <=10;i++){
            int c = a*i;
            System.out.println(a+"\t*\t"+i+"\t=\t"+c);
        }
    }
}

