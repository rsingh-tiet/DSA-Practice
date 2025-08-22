import java.util.ArrayList;

public class basics{
    public static void main(String[] args) {
        ArrayList <Integer> hathi = new ArrayList<>();
        System.out.println(hathi+"size->"+hathi.size());
        hathi.add(45);
        System.out.println(hathi+"size->"+hathi.size());
        hathi.add(1, 0);
        System.out.println(hathi+"size->"+hathi.size());
        
    }
}