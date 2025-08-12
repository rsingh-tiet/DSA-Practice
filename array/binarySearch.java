
import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        System.out.println("enter array size");
        int a = scn.nextInt();
        int[] arr = new int[a];

        for (int idx = 0; idx < arr.length; idx++) {
            System.out.println("enter element "+idx);
            arr[idx] = scn.nextInt();
            
        }
        Arrays.sort(arr);
        for(int maxy:arr){
            System.out.print(maxy+"\t");
        }

        System.out.println("enter element to be founded");
        int k  = scn.nextInt();
        scn.close();
        int first=0,last=arr.length-1,mid = (first+last)/2;
        boolean l = false;
        while (first<=last) {
            if(k<arr[mid]){
                last = mid-1;
                mid = (first+last)/2;
                continue;
            }else if(k>arr[mid]){
                first = mid+1;
                mid = (first+last)/2;
                continue;
            }
            else{
                System.out.println("element founded at"+mid);
                return;
            }
        }
    }
}
