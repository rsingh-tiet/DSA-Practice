import java.util.Scanner;

public class diff2array {
    public static void main(String[] args) {
        System.out.println("the assumption is that the user will add\n only greator number early then a smaller number\nif user don't follow it then we will enforce this condition and will see u as ..");
       Scanner scn = new Scanner(System.in);
        System.out.println("enter size 1");
        int a = scn.nextInt();
        System.out.println("enter size 2");
        
        int b = scn.nextInt();

        int[] arr1 = new int[a]; 
        int[] arr2= new int[b];

        for (int i = 0; i < arr1.length; i++) {
            System.err.println("enter element"+i);
            arr1[i] = scn.nextInt();
        }
        System.out.println("--");
        for (int i = 0; i < arr2.length; i++) {
            System.err.println("enter element"+i);
            arr2[i] = scn.nextInt();
        }
        for (int i = 0; i < arr1.length; i++) {
            System.err.print(arr1[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.err.print(arr2[i]+" ");   
        }
        System.out.println(); 
        //  int[] diff = new int[a>b ? a:b]; this is bogus
        int[] diff = new int[a];

         int carry = 0,dig,i = a-1,j=b-1,k = a-1;

         for ( k = a-1; k >= 0; k--) {
             dig = i>=0?arr1[i]+carry:carry;
             int sub = j>=0? arr2[j]:0;
             if(dig>=sub){
                dig -= sub;
                carry=0;
             }
             else{
                carry = -1;
                dig-=sub-10;
             }
             diff[k] = dig;
            //  System.out.print(dig);
             i--;j--;
         }
         System.out.println();
         for ( i = 0; i < diff.length; i++) {
             System.out.print(diff[i]);
         }
    }
}
