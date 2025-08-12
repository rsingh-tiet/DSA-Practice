import java.util.Scanner;

// public class debug {
//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         int a = scn.nextInt();
//         scn.close();

//         int val = 1;
//         int inrsp = 2 * a - 3;

//         for (int i = 0; i < a; i++) {
//             int inrval = val;

//             // Last line: print all numbers
//             if (i == a - 1) {
//                 for (int j = 1; j <= 2 * val - 1; j++) {
//                     System.out.print(inrval + "\t");
//                 }
//             } else {
//                 // Left numbers
//                 for (int j = 0; j < val; j++) {
//                     System.out.print(inrval + "\t");
//                 }

//                 // Stars
//                 for (int j = 0; j < inrsp; j++) {
//                     System.out.print("*\t");
//                 }

//                 // Right numbers
//                 for (int j = 0; j < val; j++) {
//                     System.out.print(inrval + "\t");
//                 }
//             }

//             System.out.println();
//             val++;
//             inrsp -= 2;
//         }
//     }
// }

public class debug{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
                int n = scn.nextInt();
                scn.close();

                int sp = 2 * n - 3;
                int st = 1;

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= st; j++){
                    System.out.print("*\t");
                }

                for(int j = 1; j <= sp; j++){
                    System.out.print("\t");
                }

                if(i == n){
                    st --;
                }

                for(int j = 1; j <= st; j++){
                    System.out.print("*\t");
                }

                st++;
                sp -= 2;
                System.out.println();
            }
    }
}
