import java.util.Scanner;

public class gcdLcm {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt(); 
        scn.close();

        int gcd = gcd(n1,n2);
        lcm(n1,n2,gcd);
        }
        public static int gcd(int n1,int n2) {
            if(n1>n2){
                while(n1%n2!=0){
                    int rem = n1%n2;
                    n2=n1;
                    n1= rem;
                }
            }
            System.out.println("gcd is"+n2);
            return n2;
        }
        public static void lcm(int n1,int n2, int gcd) {
            int lcm;
            lcm = n1*n2/gcd;
            System.out.println("lcm is"+lcm);
            // return lcm;
        }
    }

