import java.util.Scanner;
import java.util.*;

public class longestSecquence {

    public static int ls(int[] arr) {
        int Length = 0;
        int stpoint = Integer.MIN_VALUE;

        HashMap<Integer, Boolean> hm = new HashMap<>();

        // Mark all numbers as potential starting points
        for (int value : arr) {
            hm.put(value, true);
        }

        // Any number that has a predecessor cannot be a starting point
        for (int value : arr) {
            if (hm.containsKey(value - 1)) {
                hm.put(value, false);
            }
        }

        // Find longest sequence starting from each true start point
        for (int start : hm.keySet()) {
            if (hm.get(start)) {
                int tempLength = 1;

                while (hm.containsKey(start + tempLength)) {
                    tempLength++;
                }

                if (tempLength > Length) {
                    Length = tempLength;
                    stpoint = start;
                }
            }
        }

        System.out.println(stpoint);
        return Length;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the size");
        int size = scn.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("enter element " + (i+1) + ":");
            arr[i] = scn.nextInt();
        }

        int length = ls(arr);
        System.out.println(length);
    }
}
