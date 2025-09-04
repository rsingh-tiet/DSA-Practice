
import java.util.Scanner;
import java.util.Stack;

public class celebProb {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the no of persons");
        int a= scn.nextInt();
        int[][] arr = new int[a][a];
        System.out.println("elem be in binary only");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println("enter the element"+(i+1)+(j+1));
                arr[i][j] = scn.nextInt();
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        Stack<Integer> stk  = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stk.push(i);
        }
        System.out.println(stk);
        while (stk.size()>1) { 
            int i =stk.pop();
            int j = stk.pop();
            if(arr[i][j] != 0){
                stk.push(j);
                System.out.println("stack after iteration"+stk);
            }else{
                stk.push(i);
            }
        }
        // checking last elem is celeb or not
        int count =0,count1 =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[stk.peek()][i] !=0){
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][stk.peek()] != 0){
                count1++;
            }
        }
        if(count>0 && count1 == arr.length-1){
            System.out.println("no celeb");
        }else{
            System.out.println("celeb is "+(stk.peek()+1));
        }
    }
}
