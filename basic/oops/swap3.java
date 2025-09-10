public class swap3 {

    public static class person {
        int age;
        String name;
        void sayHi(){
            System.out.println(name+" ["+age+"]" +" say hi");
        }
    }
    public static void main(String[] args) {
        person p1 = new person();
        p1.age =10; p1.name = "Allu";

        person p2 = new person();
        p2.age = 20; p2.name = "dil";

        p1.sayHi(); p2.sayHi();
        swap(p1,p2);
        p1.sayHi(); p2.sayHi();
    }
    public static void swap(person p1 , person p2) {
    p1 = new person();
    int age = p1.age;
    p1.age = p2.age;
    p2.age = age;
    
    p2 = new person();
    String name = p1.name;
    p1.name = p2.name;
    p2.name = name;
    }
}
 
