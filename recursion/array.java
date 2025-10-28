import java.util.Scanner;

public class array {
    public static void display(int arr[], int i){
        if(i == arr.length) return;
        System.out.print(arr[i]+"\t");
        display(arr, i+1);
    }
    public static void disRev(int arr[],int i){
        if (i == arr.length) {
            return;
        }
        disRev(arr, i+1);
        System.out.print(arr[i]+"\t");
    }
    public static int max(int arr[],int i){
        if( i == arr.length-1){
            return arr[i];
        }
        int curr = max(arr, i+1);
        if(arr[i]>curr){
            return arr[i];
        }else{
            return curr;
        }
        
    }
    public static int first(int arr[],int i,int d){
        if(i == arr.length-1){
           if(arr[i] == d){
            return i;
           } 
           return -1;
        }
        int curr = first(arr, i+1, d);
        if(arr[i] == d){
            return i;
        }else if(curr != -1){
            return curr;
        }else{
            return -1;
        }
        
    }
    public static int first2(int arr[], int i, int d) {
        if (i == arr.length) return -1;
        if (arr[i] == d) return i;
        return first2(arr, i + 1, d);
    }
    public static void all(int arr[],int i,int d){
        if(i == arr.length) return;
        if(arr[i] == d){
            System.out.println("appeared at "+i);
        }
        all(arr, i+1, d);
    }
    public static int last(int arr[],int i,int d){
        if( i == arr.length) return -1;
        int liza = last(arr, i+1, d);
        if(liza == -1){
            if(arr[i] == d){
                return i;
            }else{
                return liza;
            }
        }else{
            return liza;
        }
        
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("enter element "+(i+1));
            arr[i] = scn.nextInt();
        }
        display(arr,0);
        // disRev(arr, 0);
        // System.out.println(max(arr, 0));
        System.out.println("enter which occurance to see");
        int d = scn.nextInt();
        // System.out.println(first2(arr, 0, d));
        // System.out.println(last(arr, 0, d));
        all(arr, 0, d);
    }
}
