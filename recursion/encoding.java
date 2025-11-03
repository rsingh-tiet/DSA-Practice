import java.util.Scanner;

public class encoding {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the code");
        String s = scn.next();
        System.out.println("entered code is "+s+"some encodes will be");
        encode(s,"");
        scn.close();
    }
    public static void encode(String s,String ans){
        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }
        if(s.length() == 1){
            char ch = s.charAt(0);
            if(ch == '0'){
                return;
            }else{
                char toadd = (char)('a'+(ch-'0')-1);
                ans+= toadd;
                System.out.println(ans);
            }
        }else{
            char ch = s.charAt(0);
            String rest = s.substring(1 );
            if(ch == '0'){
                return;
            }else{
                char toadd = (char)('a'+(ch-'0')-1);
                ans+= toadd;
                encode(rest, ans);
            }
            String ch12 = s.substring(0,2);
            String rest12 = s.substring(2);
            int intcode = Integer.parseInt(ch12);
            if(intcode<=26){
                encode(rest12, ans+(char)('a'+intcode-1));
            }
        }
    }
}
