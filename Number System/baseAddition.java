
import java.util.Scanner;

public class baseAddition {
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
            System.out.println("can't be added direcrly");
            return;
        }
        else{
            int addedNum=0;
            int carry=0;
            int count=0;
            // System.out.println("before loop");
            while(num1>0||num2>0&&carry>0){
                // System.out.println("in else");
                int n1 = num1%10;
                int n2 = num2%10;
                int n = n1+n2+carry;
                if(n>=b1){
                    carry= n/b1;
                    n = n%b1;
                }
                addedNum+=n*(int)Math.pow(10, count);
                System.out.println("addednum->"+addedNum+" count->"+count+"carry"+carry);
                count++;
                num1=num1/10;
                num2 = num2/10;
            }
            if(carry!=0){
                System.out.println(carry+"carry in if");
                addedNum+=carry*(int)Math.pow(10, count);
            }
            System.out.println(addedNum);
        }
    }
}



// import java.util.Scanner;

// public class baseAddition {
//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         System.out.println("Enter number 1:");
//         int num1 = scn.nextInt();
//         System.out.println("Enter number 1's base:");
//         int b1 = scn.nextInt();

//         System.out.println("Enter number 2:");
//         int num2 = scn.nextInt();
//         System.out.println("Enter number 2's base:");
//         int b2 = scn.nextInt();
//         scn.close();

//         if(b1 != b2){
//             System.out.println("Can't be added directly — base mismatch.");
//             return;
//         } else {
//             int addedNum = 0;
//             int carry = 0;
//             int count = 0;

//             while(num1 > 0 || num2 > 0 || carry > 0) {
//                 int n1 = num1 % 10;
//                 int n2 = num2 % 10;

//                 int sum = n1 + n2 + carry;
//                 carry = sum / b1;
//                 int digit = sum % b1;

//                 addedNum += digit * (int)Math.pow(10, count);

//                 System.out.println("Digit sum: " + digit + ", carry: " + carry);

//                 count++;
//                 num1 /= 10;
//                 num2 /= 10;
//             }

//             System.out.println("Final sum in base " + b1 + ": " + addedNum);
//         }
//     }
// }
