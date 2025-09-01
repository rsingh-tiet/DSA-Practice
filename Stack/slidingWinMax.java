import java.util.Scanner;
import java.util.Stack;

public class slidingWinMax {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the size pf array");
        int[] arr = new int[scn.nextInt()];
        System.out.println("enter the window size");
        int k = scn.nextInt();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter the element "+(i+1));
            arr[i] = scn.nextInt();
        }
        for (int elem : arr) {
            System.out.print(elem+"\t");
        }
        System.out.println();
        Stack<Integer> stk = new Stack<>();
        stk.push(arr.length-1);
        int[] nge = new int[arr.length];
        nge[arr.length-1] = arr.length;
        for (int i = arr.length-2; i >= 0; i--) {
            // pop
            while(stk.size()>0  && arr[stk.peek()]<=arr[i]){
                stk.pop();
            }
            // ans
            if(stk.size()==0){
            nge[i] = arr.length;
          } else{
                nge[i] = stk.peek();
            }
            // push
            stk.push(i);
        }
        for (int elem : nge) {
            System.out.print(elem+"\t");
        }
        int j=0;
        for (int i = 0; i <= arr.length-k; i++) {
            
            if(j<i){ j =i;}
            while (nge[j]<i+k) { 
                j = nge[j]; 
            }
            System.out.println("max sliding is "+arr[j]);
        }
    }

}
