
import java.util.Scanner;

public class ceilNfloor {
    public static void main(String[] args) {
        Scanner scn  =new Scanner(System.in);
        System.out.println("you can make your own scale to find the\nciel and floor but make sure that the range is uniform for uniform\nscale");
        System.out.println("enter the size ");
        int a = scn.nextInt();
        int[] arr = new int[a];
        for (int idx = 0; idx < arr.length; idx++) {
            System.out.println("enter element "+idx);
            arr[idx] = scn.nextInt();
        }
        for(int maxy:arr){
            System.out.print(maxy+"\t");
        }
        System.out.println();
        System.out.println("enter element to be founded");
        int k  = scn.nextInt();
        scn.close();
        int first=0,last=arr.length-1,mid = (first+last)/2;
        int ceil = Integer.MAX_VALUE,floor = Integer.MIN_VALUE;
        System.out.println(ceil+"\nfloor->"+floor);
        // thing to remember here is that we have to update ceil and floor before applying binary search logic 
        // as it will help in non uniform scale
        while (first<=last) {
            if(k<arr[mid]){//in first half
                ceil = arr[mid];
                last = mid-1;
                mid = (first+last)/2;
                
                continue;
            }else if(k>arr[mid]){//in second half
                floor = arr[mid];
                first = mid+1;
                mid = (first+last)/2;
                
                continue;
            }
            else{
                ceil = arr[mid];
                floor = arr[mid];
                break;
            
            }

        // System.out.println("ceil is "+arr[ceil]+" floor is "+arr[floor]);
        }
        System.out.println("ceil is "+ceil+" floor is "+floor);
    }
}
