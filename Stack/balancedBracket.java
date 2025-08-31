
import java.util.Scanner;
import java.util.Stack;

public class balancedBracket {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the eqn with {}[]()");
        String s =new String(scn.nextLine());

        Stack<Character> stk = new Stack<>();
        boolean b = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch =='[') {
                stk.push(ch);
            }else if (ch == ')') {
                if(stk.size()>0 && stk.peek() =='('){
                    stk.pop();
                }else{
                    b= false;break;
                }
            }else if(ch == '}'){
                if(stk.size()>0 && stk.peek() =='{'){
                    stk.pop();
                }else{
                    b= false;break;
                }
            }else if (ch ==']') {
                if(stk.size()>0 && stk.peek() =='['){
                    stk.pop();
                }else{
                    b= false;break;
                }
            }
        }
        if(stk.size()>0){
            b=false;
        }
        System.out.println(b);
    }
}
