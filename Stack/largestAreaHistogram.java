
import java.util.Scanner;
import java.util.Stack;

public class largestAreaHistogram {
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
        // prev smallar
        Stack<Integer> stk = new Stack<>();
        int[] prev = new int[arr.length];
        stk.push(0);
        prev[0]=1;
        for (int i = 1; i < arr.length; i++) {
            // pop for larger
            while(stk.size()>0 && arr[stk.peek()]>arr[i]){
                stk.pop();
            }
            // ans
            if(stk.size() == 0){
                prev[i] = i+1;
            }else{
                prev[i] = i-stk.peek();
            }
            // push
            stk.push(i);
        }
        for (int iterable_element : prev) {
            System.out.print(iterable_element+"\t");
        }

        System.out.println();
        // next smallar
        Stack<Integer> sk = new Stack<>();
        int[] next = new int[arr.length];
        stk.push(arr.length-1);
        next[arr.length-1] = 1;
        for (int i = arr.length-2; i >=0 ; i--) {
            // pop
            while(sk.size()>0 && arr[sk.peek()] > arr[i]){
                sk.pop();
            }
            // ans
            if(sk.size()==0){
                next[i] = arr.length-i;
            }else{
                next[i] = sk.peek()-i;
            }
            // push
            sk.push(i);
        }

        for (int elem : next) {
            System.out.print(elem+"\t");
        }
        System.out.println();
        int[] max = new int[arr.length];
        for (int i = 0; i < max.length; i++) {
            max[i] = prev[i]+next[i]-1;
            max[i]*= arr[i];
        }
        for (int elem : max) {
            System.out.print(elem+"\t");
        }
    }
}
