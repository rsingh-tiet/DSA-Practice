import java.util.Scanner;
import java.util.Stack;

public class InfixConversion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the expression (with parentheses):");
        String s = scn.nextLine();

        Stack<Character> oprs = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') continue; // ignore spaces

            if (Character.isDigit(ch) || Character.isAlphabetic(ch)) {
                pre.push(ch + "");
                post.push(ch + "");
            } else if (ch == '(') {
                oprs.push(ch);
            } else if (ch == ')') {
                while (oprs.size() > 0 && oprs.peek() != '(') {
                    process(oprs, pre, post);
                }
                oprs.pop(); // remove '('
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (oprs.size() > 0 && oprs.peek() != '(' && precedence(ch) <= precedence(oprs.peek())) {
                    process(oprs, pre, post);
                }
                oprs.push(ch);
            }
        }

        while (!oprs.isEmpty()) {
            process(oprs, pre, post);
        }

        System.out.println("Prefix: " + pre.peek());
        System.out.println("Postfix: " + post.peek());
    }

    // process helper function
    private static void process(Stack<Character> oprs, Stack<String> pre, Stack<String> post) {
        char op = oprs.pop();

        String preV2 = pre.pop();
        String preV1 = pre.pop();
        String anspre = op + preV1 + preV2;
        pre.push(anspre);

        String postV2 = post.pop();
        String postV1 = post.pop();
        String anspost = postV1 + postV2 + op;
        post.push(anspost);
    }

    // precedence
    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        else return 2; // * or /
    }
}
