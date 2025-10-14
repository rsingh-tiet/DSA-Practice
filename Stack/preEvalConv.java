import java.util.Scanner;
import java.util.Stack;

public class preEvalConv {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the expression in prefix form");
        String s = new String(scn.nextLine());

        Stack<Integer> val = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<String> in = new Stack<>();

        for (int i = s.length()-1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                val.push(ch-'0');
                post.push(ch+"");
                in.push(ch+"");
            }else if(ch == '+' || ch == '-' || ch == '*'  || ch == '/'){
                int val2 = val.pop();
                int val1 = val.pop();
                val.push(valHelper(val1,val2,ch));

                String pv2 = post.pop();
                String pv1 = post.pop();
                pv1 = pv1+pv2+ch; 
                post.push(pv1); 

                String iv2 = in.pop();
                String iv1 = in.pop();
                iv1 = "("+iv1+ch+iv2+")";
                in.push(iv1);
            }
        }
        System.out.println("val is "+val.peek()+"\n postfix is "+post.peek()+"\n infix is "+in.peek());
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
