import java.util.Scanner;
import java.util.Stack;

public class basic {
    public static void main(String Args[]){
        Scanner scn = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        s.push(5);
        System.out.println(s+"\n enter the no of element that u want to add");
        int a =scn.nextInt();
        for (int i = 0; i < a; i++) {
            System.out.println("enter the element"+(i+1));
            s.push(scn.nextInt());
            System.out.println(s+"size is->"+s.size()+" at top ->"+s.peek());
        }
        if(s.size()>a){
            s.pop();
        }
        System.out.println(s);

        
    }
}
