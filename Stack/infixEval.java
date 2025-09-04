
import java.util.Scanner;
import java.util.Stack;

public class infixEval {
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        System.out.println("enter the expression");
        String s = new String(scn.nextLine());
        Stack<Integer> oprnds = new Stack<>();
        Stack<Character> oprs = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                oprnds.push(ch-'0');// converts char to digit
            }else if(ch == '('){
                oprs.push(ch);
            }else if(ch == ')'){
                while (oprs.size()>0 && oprs.peek() != '(') { 
                  int v2 = oprnds.pop();
                  int v1 = oprnds.pop();
                  char chh = oprs.pop();
                  int ans = oprnd(v1, v2, chh);
                  oprnds.push(ans);
                }
                oprs.pop();
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while (oprs.size()>0 && oprs.peek() != '(' && prdnce(oprs.peek())>=prdnce(ch)) { 
                  int v2 = oprnds.pop();
                  int v1 = oprnds.pop();
                  char chh = oprs.pop();
                  int ans = oprnd(v1, v2, chh);
                  oprnds.push(ans);

                }
                oprs.push(ch);
            }
        }
        while(!oprs.isEmpty()){
            int v2 = oprnds.pop();
            int v1 = oprnds.pop();
            char chh = oprs.pop();
            int ans = oprnd(v1, v2, chh);
            oprnds.push(ans);

        }
        System.out.println(oprnds.peek());
    }
    public static int oprnd(int v1,int v2 , char ch){
        if(ch == '+'){
            v1+=v2;
        }else if(ch == '-'){
            v1-=v2;
        }else if(ch == '*'){
            v1*=v2;
        }else{
            v1/=v2;
        }
        return v1;
    }
    public static int prdnce(char ch) {
        if(ch == '+'){
            return 1;
        }else if(ch == '-'){
            return 1;
        }else if(ch == '*'){
            return 2;
        }else{
            return 2;
        }
        
    }
}
