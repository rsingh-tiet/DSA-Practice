
import java.util.Scanner;

public class multiplication {
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        // Scanner scn = new Scanner(System.in);
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
            System.out.println("can't be added direcrly");
            return;
        }
        else{
            int dubNum1,carry=0,n1,n2,dig,count1=0,count2=0,mulNum=0,intNum=0;
            
            while(num2>0){
                dubNum1 = num1;
                n2 = num2%10;
                 num2/=10;
                //  carry=0;
                 count1 = 0;
                while(dubNum1>0||carry>0){
                    n1 = dubNum1%10;
                    dubNum1/=10;
                    dig = n1*n2+carry;
                    
                        carry = dig/b1;
                        dig = dig%b1;
                    
                    
                    intNum += dig*(int)Math.pow(10, count1);
                    count1++;
                    System.out.println("in 2nd while");
                }
                intNum *= Math.pow(10, count2);
                count2++;
                mulNum = addInBase(mulNum, intNum, b2);
                 intNum=0;
            }
            System.out.println(mulNum);
        }
      
    }
    public static int addInBase(int n1, int n2, int base) {
        int result = 0;
        int carry = 0;
        int place = 1;

        while (n1 > 0 || n2 > 0 || carry > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 /= 10;
            n2 /= 10;

            int sum = d1 + d2 + carry;
            carry = sum / base;
            sum = sum % base;

            result += sum * place;
            place *= 10;
        }

        return result;
    }
        
    
    }

