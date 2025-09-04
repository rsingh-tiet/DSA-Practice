
import java.util.Scanner;
import java.util.Stack;

public class postfixEvalConv {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the post fix eqn");
        String s = new String(scn.nextLine());

        Stack<String> in =new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<Integer> val = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch) || Character.isAlphabetic(ch)){
                in.push(ch+"");//char to string
                pre.push(ch+"");
                val.push(ch-'0');// char to int
            }else if(ch == '+' || ch =='-' || ch == '*' || ch == '/'){
                int v2 = val.pop();
                int v1 = val.pop();
                val.push(valHelper(v1,v2,ch));

                String pv2 = pre.pop();
                String pv1 = pre.pop();
                pv1 = ch+pv1+pv2; 
                pre.push(pv1); 

                String iv2 = in.pop();
                String iv1 = in.pop();
                iv1 = "("+iv1+ch+iv2+")";
                in.push(iv1);
            }
        }
        System.out.println("val is "+val.peek()+"\n prefix is "+pre.peek()+"\n infix is "+in.peek());

    }
    public static int valHelper(int v1,int v2,char ch){
        if(ch =='+'){
            v1+=v2;
        }else if(ch =='-'){
            v1-=v2;
        }else if(ch =='*'){
            v1*=v2;
        }else if(ch == '/'){
            v1/=v2;
        }
        return v1;
    }
}
