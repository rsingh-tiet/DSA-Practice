import java.util.HashMap;
import java.util.Scanner;

public class common {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter arr1 size");
        int size1 = scn.nextInt();
        System.out.println("enter array2 size");
        int size2 = scn.nextInt();

        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];

        for (int i = 0; i < arr1.length; i++) {
            System.out.println("enter element:"+(i+1));
            arr1[i] = scn.nextInt();
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("enter element:"+(i+1));
            arr2[i] = scn.nextInt();
        }
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            hm2.put(arr2[i], 1);
        }
        for (int i = 0; i < arr1.length; i++) {
            hm1.put(arr1[i], 1);
        }
        System.out.println("hm1"+hm1);
        System.out.println("hm2"+hm2);
        System.out.println("multiple keys");
        for (int i = 0; i < arr2.length; i++) {// print multiple times
            if(hm1.containsKey(arr2[i]) && hm2.containsKey(arr2[i])){
                System.out.println(arr2[i]);
            }
        }
        System.out.println("single keys");
        for (int i : hm1.keySet()) {
            if(hm2.containsKey(i)){
                System.out.println(i);
            }
        }
    }
}
