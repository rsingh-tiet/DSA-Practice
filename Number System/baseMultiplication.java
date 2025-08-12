
import java.util.Scanner;

public class baseMultiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
         System.out.println("enter number 1");
        int num1 = scn.nextInt();
        System.out.println("enter number base");
        int b1 = scn.nextInt();
        System.out.println("enter number 2");
        int num2 = scn.nextInt();
        System.out.println("enter number's base");
        int b2 = scn.nextInt();
        scn.close();
        if(b1!=b2){
            System.out.println("can't be * direcrly");
            return;
        }
        else{
            System.out.println("in else");
            int count1 = 0,count2 = 0,d1,d2,mulNum=0,intNum=0,d,carry=0;
            while(num2>0){
                System.out.println("in while num2");
                int dubNum=num1;
                d2 = num2%10;
                num2/=10;
                count1=0;
                intNum=0;
                carry = 0;
                while(dubNum>0){

                    System.out.println("in while num1");
                    
                    d1 = dubNum%10;
                    dubNum/=10;
                    d = d1*d2+carry;
                    if(d>=b1){
                        carry = d/b1;
                        d%=b1;
                    }
                     
                    intNum += d*(int)Math.pow(10, count1);
                    System.out.println("intermediatory num"+intNum);
                    count1++;
                }
                if(carry!=0){
                    
                    intNum+=carry*(int)Math.pow(10, count1);
                    System.out.println("inter num in carry->"+intNum+"carry->"+carry+"count"+count1);
                    carry=0;
                }
                
                System.out.println("inter num berfore correction"+intNum);
                // intNum*=10;
                intNum*=(int)Math.pow(10, count2);
                System.err.println("interm num after correction->"+intNum+" count2->"+count2);
                mulNum+=intNum;
                System.out.println("mulnum->"+mulNum);
                count2++;
            }
            System.out.println(mulNum);
        }
        
    }
}
