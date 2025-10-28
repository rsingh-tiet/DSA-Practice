import java.util.Scanner;
/*
 * in the cose where one recursive call is there like
 * code(above) call code(below) above is called when stack is growing and below when stack is shrinking/ coming back
 * 
 * where as in pre call in call post there are 3 regions in the code to effectively analize it we mke a tree and see the euler path
 */
public class zigzag {
    public static void zigzag(int n){
        if(n == 0){
            return;
        }
        System.err.println("pre"+n);
        zigzag(n-1);
        System.out.println("in"+n);
        zigzag(n-1);
        System.out.println("post"+n);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        zigzag(scn.nextInt());
    }
}
