
import java.util.Scanner;

public class rotateNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int a = scn.nextInt();
        // scn.close();
        int rotNum;
        int dubNum = num;
        int count = 0;

        while(dubNum>0){
            count++;
            dubNum= dubNum/10;
        }
        
            a=a%count;
        
        if(a<0){
            a+=count;
        }
        int mul = count-a;
        System.out.println(count +" "+mul);
        rotNum = (num%(int)Math.pow(10, a))*(int)Math.pow(10, mul);
        num=num/(int)Math.pow(10, a);
        rotNum+=num;
        System.out.println(rotNum); 
    }
}
