
import java.util.Scanner;

public class pattern14{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        scn.close();
        int os = a/2;
        int is = 1;
        int val=1;
        for (int i = 1; i <=a; i++) {
            int inrval= val;
            for (int j = 1; j <= os; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= is; j++) {
                System.out.print(inrval+"\t");
                if(j<=is/2){
                    inrval++;
                }
                else{inrval--;}
            }
            if(i<=a/2){
                os--;
                is+=2;
                val++;
            }
            else{
                os++;
                is-=2;
                val--;
            }
            System.out.println();
        }
    }
}