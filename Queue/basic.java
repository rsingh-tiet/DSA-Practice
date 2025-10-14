import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class basic{
    public static void main(String[] args) {
        // Scannar scn = new Scannar(System.in);
        Scanner scn = new Scanner(System.in);
        Queue<Integer> q = new ArrayDeque<>();
        System.out.println("enter the no of elements that u want");
        int a = scn.nextInt();
        for (int i = 0; i < a; i++) {
            System.out.println("enter element"+(i+1));
            q.add(scn.nextInt());
        }
        System.out.println(q);
        System.out.println("removing from queue q.remove() "+q.remove()+"\n"+q);
        System.out.println("accecsing from queue which can be removed/pop "+q.peek()+"\n"+q);
    }
}