public class basic2 {
    public static void main(String[] args) {
        String s1 = "helloo";
        System.out.println(s1);
        String s2 = "helloo";
        System.out.println(s2);
        

        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        // s1+="change in s1";
        System.out.println("this is to check the effect of interning->"+ s2+System.identityHashCode(s2));
        System.out.println(s1+System.identityHashCode(s1));
        String s3 = new String("helloo");
        System.out.println(s3+System.identityHashCode(s3));
        int a;
        if(s1 != s2){
            a=1;
            System.out.println(a);
        }else if(s1!=s3){
            a=2;
            System.out.println(a);
        }
        if(s1.equals(s3)){
            a=5;
        }
        System.out.println(5);

        // string are immutable bcz of interning 
        // String has performance issue as changing string changes its reference and new instance is creaed every time so not
        // good for majority of tasks where changing string are required


    }
}
