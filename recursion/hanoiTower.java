import java.util.Scanner;

public class hanoiTower {
    public static void hanoi (int n,char a,char b,char c){
        if(n == 0) return;
        hanoi(n-1, a, c, b);
        System.out.println(n+"["+a+"->"+b+"]");
        hanoi(n-1, c, b, a);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();


        char a = scn.next().charAt(0);
        char b = scn.next().charAt(0);
        char c = scn.next().charAt(0);

        hanoi(n, a, b, c);

    }
}
