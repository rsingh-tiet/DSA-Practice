import java.util.Scanner;

public class basics {
    public static void printDec(int k){
        if(k == 0) return;
        System.out.println(k);
        // if(k>1)
        printDec(k-1);
    }
    public static void printInc(int n){
        if(n == 0) {
            // System.out.println(n);
            return;}
        printInc(n-1);
        System.out.println(n);
    }
    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        int ans  = n*factorial(n-1);
        return ans;
    }

    public static int fibonaci(int n){
        if(n == 1){
            return 1;
        }else if(n == 0){
            return 0;
        }
        int f = fibonaci(n-1); int s = fibonaci(n-2);
        int sum = f+s;
        // System.out.println(sum);
        return sum;
        
    }
    public static int poLin(int n,int x){
        if(n == 0){
            return 1;
        }
        int ans  = x*poLin(n-1,x);
        return ans;
    }
    public static int poLog(int x,int n){
        if(n == 0){
            return 1;
        }
        int ans;
        if(n%2 ==0){
             ans = poLog(x, n/2)*poLog(x,n/2);
        }else{
             ans = x*poLog(x, n/2)*poLog(x,n/2);
        
        }
        return ans;
    }
    public static void decInc2(int n){
        if (n == 0){
            // System.out.println("1\n1");
            return;
        }
        System.out.println(n);
        decInc2(n-1);
        System.out.println(n);
    }
    public static void decInc(int n){
        printDec(n);
        printInc(n);
    }
    public static void display(int arr[],int i){
        if(i>arr.length-1){return;}
        System.out.println(arr[i]);
        display(arr, i+1);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // System.out.println("enter no");
        // int num = scn.nextInt();
        // for (int i = 0; i < num; i++) {
        //     System.out.print(fibonaci(i)+" ");
        // }

        // System.out.println(decInc(scn.nextInt()));
        
        // System.out.println("enter power then number ");
        // long startTime = System.nanoTime();
        // int a = scn.nextInt(),b = scn.nextInt();
        // System.out.println(poLin(a,b));
        
        // long endTime = System.nanoTime();
        // long durationInNanoseconds = endTime - startTime;
        // double durationInMilliseconds = (double) durationInNanoseconds / 1_000_000.0; 
        // System.out.println("Execution time: " + durationInMilliseconds + " milliseconds");

        
        // System.out.println("enter num x then pow n");
        // long startTime2 = System.nanoTime();
        // int a1 =scn.nextInt(),b1 = scn.nextInt();
        // System.out.println(poLog(a1,b1));
        // long endTime2 = System.nanoTime();
        // long durationInNanoseconds2 = endTime2 - startTime2;
        // double durationInMilliseconds2 = (double) durationInNanoseconds2 / 1_000_000.0; 
        // System.out.println("Execution time: " + durationInMilliseconds2 + " milliseconds");

        System.out.println("enter size of array");
        int size = scn.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter element "+(i+1));
            arr[i] = scn.nextInt();
        }
        display(arr, 0);

    }
}
