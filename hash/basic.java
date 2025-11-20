import java.util.HashMap;
import java.util.Set;
// import java.util.*;
public class basic {
    public static void main(String[] args) {
        // PUT                      GET (similarly)        CONTAINKEy
        // h.put -> add key pair
        //       \ >   if present change val

        //  keySet  gives all the keys
        HashMap<String,Integer> h = new HashMap<>();
        h.put("alpha", 4);
        h.put("beta", 3);
        h.put("gamma", 8);
        System.out.println(h);
        h.put("alpha", 5);
        System.out.println(h);
        h.put("omega", 7);
        System.out.println(h);
        h.put("lamda", 0);
        System.out.println(h);
        System.out.println(h.get("gamma"));
        System.out.println(h.containsKey("lamda"));
        h.put("test", null);
        System.out.println(h);
        Set<String>  key = h.keySet();
        System.out.println(key);
        for (String alluString : h.keySet()) {
            System.out.print(alluString +"\t");
        }
    }
}
