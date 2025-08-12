
import java.util.Scanner;

public class getFreq {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int dig = scn.nextInt();
        scn.close();
        System.out.print(getDigFreq(num, dig));

    }
    public static int getDigFreq(int x, int d) {
       
        int counter=0;
         while(x>0){
        int dig = x%10;
        x=x/10;
        if(dig == d){
        counter++;
        // System.out.print(counter);
        }
            
       }
       return counter;
    }
}
