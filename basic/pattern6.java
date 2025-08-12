import java.util.Scanner;

public class pattern6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        scn.close();
        int star=a/2+1;
        int space=1;
        for (int i = 0; i < a; i++) {
            if(i < a/2){
                System.out.println("*\t".repeat(star)+"\t".repeat(space)+"*\t".repeat(star));
                space+=2;
                star--;
            }
            else{
                System.out.println("*\t".repeat(star)+"\t".repeat(space)+"*\t".repeat(star));
                space-=2;
                star++;
            }
        }
    }
}
