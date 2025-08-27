import java.util.ArrayList;

public class basics{
    public static void main(String[] args) {
        ArrayList <Integer> hathi = new ArrayList<>();
        // TO ADD THE ELEMENT .add(,) or .add()
        System.out.println(hathi+"size->"+hathi.size());
        hathi.add(45);
        System.out.println(hathi+"size->"+hathi.size());
        hathi.add(1, 0);
        System.out.println(hathi+"size->"+hathi.size());

        // TO GET THE ELEMENT .get
        System.out.println(hathi.get(0));

        // TO SET THE ELEMENT .set(,)
        System.out.println(hathi.set(0, 151));

        // TO REMOVE THE ELEMENT .remove()
        System.out.println(hathi.remove(0));

        // HAS BOTH THE LOOPS AVAILABLE LIKE IN ARRAY
hathi.add(45);hathi.add(45);hathi.add(45);hathi.add(45);

        for(int chamach : hathi){
            System.out.println(chamach);
        }
        for (int i = 0; i < hathi.size(); i++) {
            System.out.print(hathi.get(i)+"\t");
        }
        
    }
}