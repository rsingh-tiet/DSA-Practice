import java.util.Scanner;

public class subset {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter sample size");
        int size = scn.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("enter target");
        int sum  = scn.nextInt();
        subset(arr,"",0,0,sum);
    }
    public static void subset(int[] arr,String ans, int ssf,int i,int sum){
        if(i == arr.length && ssf == sum){
            System.out.println(ans);
            return;
        }else if(i == arr.length && ssf != sum){
            return;
        }
        
            subset(arr, ans+arr[i]+" ", ssf+arr[i], i+1, sum);
            subset(arr, ans, ssf, i+1, sum);
        
    }
}
