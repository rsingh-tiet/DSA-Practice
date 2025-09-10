public class basic{
    public static class hathi{// members nad data functions are putted together in class ie encapsulated
        int age;              // 
        String nako;
        int alwaysAdd(){
            return 1;
        }
    }
    public static  class animal{
        String species;
        boolean intelegence;
        boolean size;
        void danger(){
            if (intelegence || size) {
                System.out.println("stay alert");
            }
        }
    }
    public static void main(String[] args) {
        hathi cirpole = new hathi();
        cirpole.age = 450;
        cirpole.nako ="huma";
        System.out.println(cirpole.alwaysAdd()+" "+cirpole.age);

        //  cirpole & one are REFERENCE to the OBJECT see memory.png
        //  new ``creates`` INSTANCE ie heap memory
        animal one = new animal();
        one.species = "lion"; one.intelegence =true; one.size = false;
        one.danger();

        animal two = one;
        two.size = true;
        System.out.println(one.size +" "+ two.size);


        // CONSTRUCTOR & THIS
        
    }
}