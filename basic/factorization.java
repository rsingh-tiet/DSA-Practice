
import java.util.Scanner;

public class factorization {
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        int a = scn.nextInt();
        scn.close();
        // for(int div = 2;div<=a;div++){
        //     while (a%div == 0) { 
        //         System.out.print(div+" ");
        //         // System.out.println("in loop");
        //         a = a/div;
                
        //     }}
        // }
        for(int div = 2;div*div<a;div++){
            while(a%div==0){
                System.out.print(div+" ");
                a = a/div;
            }
            
        }
        if(a>0){
            System.out.print(a);
        }
    }}

