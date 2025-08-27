
import java.util.ArrayList;
import java.util.Scanner;

public class removeprime {
    public static void main(String[] args) {
        
        ArrayList<Integer> al = new ArrayList<>();
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the initial size of list");
        int a =scn.nextInt();
        for (int i = 0; i < a; i++) {
            System.out.println("enter initial element");
            int b = scn.nextInt();
            al.add(b);
        }
        System.out.println(al);
        for (int i = al.size()-1; i >=0; i--) {// problem in forward loop is that it skips element after removal so best is to use loop backwards

            if(isprime(al.get(i))){
                al.remove(i);
            }
        }
        System.out.println(al);
    }
    public static boolean isprime(int k){
        boolean b =true;int count=0;
        for (int i = 2; i*i <= k; i++) {
            if(k%i == 0){
                count++;
            }
        }
        if(count>0){
            b= false;
        }
        return b;
    }
}
