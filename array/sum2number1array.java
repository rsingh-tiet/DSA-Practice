import java.util.Scanner;

public class sum2number1array {
    public static void main(String[] args) {
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
        
        int max;
        if(a>b){
            max = a;
        }
        else{max=b;}

        int[] addArr = new int[max];
        int i=arr1.length-1,j= arr2.length-1,carry=0,sum=0;

        for(int k = addArr.length-1;k >= 0; k--){
           System.out.println("in for loop");
            
            sum =carry;
            if(i>=0){sum+=arr1[i];}
            if(k>=0){sum+=arr2[k];}
            carry = sum/10;
            sum %=10;
            System.err.print(sum+" ");
            addArr[k] = sum;
            i--;j--;
        }
        System.out.println();
        if(carry>0){System.out.print(carry);}
        for (i = 0; i < arr2.length; i++) {
            System.err.print(addArr[i]+" ");   
        }
    }
}
