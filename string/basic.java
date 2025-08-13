
import java.util.Scanner;

public class basic{// its memory allocation is same like array in the stack an address is stored
                    //  and it will point out that in the heap
    public static void main(String[] args) {
        // to decleare simply use String n -> assign = "abc" -> declare
        String a= "this is a sting";
        // to print this just use sys out 
        System.out.println(a);
        // String is like a arraylist

        // to get from the user we will use Scanner but have two things next => just read till space & 
        // nextline => read this next line or enter
        Scanner scn  = new Scanner(System.in);
       
       
        // System.out.println("enter string 1");
        // String b = scn.next();
        // scn.nextLine(); // this helped to have written the correct for next string
        
        // System.out.println("enter string 2");
        // String c = scn.nextLine();

        // System.out.println(b);
        // System.out.println(c);
        // String d = c;
        // c= "changed";
        // System.out.println(d);
        // System.out.println(c);



        // in this deep copy is done so it is not fully like array

        // length function and assesing single character
        System.out.println(a.length());

        System.out.println(a.charAt(a.length()-1));

        // here we can't change the char at a place this is not possible ie a.charAt(6) = 'a' X

       System.out.print( a.substring(3, 9));// it is [start,end)
        //    [1,1) -> _ &[2,1) is error

        // split function
        System.out.println("split function start here");
        String z = "this is a vast set of data,made,to7make7the,user afrq,I7mean,u under,stand";
        String[] arr = z.split(" ");
        String[] arr2 = z.split(",");
        String[] arr3 = z.split("7");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("_________________________________________________________");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        System.out.println("_________________________________________________________");
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
    }
}