import java.util.Scanner;
import java.util.Stack;

public class nextGreator3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the size pf array");
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter the element "+(i+1));
            arr[i] = scn.nextInt();
        }
        for (int elem : arr) {
            System.out.print(elem+"\t");
        }
        System.out.println();
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        int[] ans = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            // pop & ans
            while(stk.size()>0 && arr[stk.peek()]<arr[i]){
                int idx = stk.peek();
                ans[idx] = arr[i];
                stk.pop();
            }
            stk.push(i);
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+"\t");
        }


    }
}

