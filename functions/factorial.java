import java.util.Scanner;

public class factorial{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int r = scn.nextInt();
        scn.close();
        // System.out.print(fact(5));
        int a=fact(n);
        System.out.println(a);
        System.out.println(perm(n,r));
    }
    public static int fact(int x) {
        int a =1;
        for (int i = 1; i <= x; i++) {
            a *=i;
        }
        // System.out.println(a);
        return a;
    }
    public static int perm(int x,int y){        // int show that the function will sreturn iteger
        
        if(x>y){
         return  fact(x)/fact(y);}
        else{System.err.println("x should be greator");
        return 0;}
    }
    public static void g() {// here return is void ie it doesn't return anything
        
    }
}