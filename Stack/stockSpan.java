
import java.util.Scanner;
import java.util.Stack;

public class stockSpan {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the number of days");
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter the stock price on day "+i);
            arr[i] = scn.nextInt();

        }
        for (int elem : arr) {
            System.out.print(elem+"\t");
        }
        System.out.println();
        // logic
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[arr.length];
        ans[0] =1;
        stk.push(0);
        for (int i = 1; i < arr.length; i++) {
            
                while(stk.size()>0 && arr[stk.peek()]<=arr[i]){
                    stk.pop();
                }
                if(stk.size()==0){
                    ans[i] = i+1;
                }else{
                    ans[i] = i-stk.peek();
                }
                stk.push(i);
            // System.out.println("stock span for day "+i+" is "+(i-stk.peek()));
        }
        for (int elem : ans) {
            System.out.print(elem+"\t");
        }
    }
}
