import java.util.HashMap;
import java.util.Scanner;

public class highestFreq {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter arr size");
        int size = scn.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter element:"+(i+1));
            arr[i] = scn.nextInt();
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            if(map.containsKey(curr)){
                int freq = map.get(curr);
                map.put(curr, freq+1);
            }else{
                map.put(curr, 1);
            }
        }
        System.out.println(map);
        int key = 0;
        int max = Integer.MIN_VALUE;
        for (Integer i : map.keySet()) {
            max = Math.max(max, map.get(i));
        }
        for (int i : map.keySet()) {
            if(map.get(i) == max){
                key = i;
            }
        }
        System.out.println("highest freq:"+max+"key->"+key);
        scn.close();
    }
}
