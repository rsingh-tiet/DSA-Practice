import java.util.Scanner;
import java.util.Stack;

public class nextGreator2 {
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
        stk.push(arr[arr.length-1]);
        for (int i = arr.length-2; i >= 0*arr.length; i--) {
            // pop
            
            while(stk.size()>0  && stk.peek()<=arr[i]){
                stk.pop();
            }
            // ans
            if(stk.size()>0){
            System.out.println("next greator for "+arr[i]+" is "+stk.peek());}
            else{
                System.out.println("next greator for "+arr[i]+" is -1");
            }
            // push
            stk.push(arr[i]);
        }

    }
}
