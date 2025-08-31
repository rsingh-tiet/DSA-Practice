
import java.util.Scanner;
import java.util.Stack;

public class duplicatebracket {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the equation with paranthesis only");
        
        String s = new String(scn.nextLine());
        System.out.println(s);
        Stack<Character> stk = new Stack<>();
        stk.push(s.charAt(0));
        boolean b =true;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if(s.charAt(i)==')'){
                if(stk.peek()=='('){
                    stk.pop();
                    b = false;break;
                }else{
                    while(stk.peek() != '('){
                        stk.pop();
                    }
                    stk.pop();
                }
            }else {
                stk.push(ch);
            }
        }

        System.out.println(b+" stack->"+stk);

    }
}
