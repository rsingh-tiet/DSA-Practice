import java.util.Random;

public class bubble{
    public static void main(String[] args) {
            Random rand = new Random();
        int[] unsortArr = new int[5];
        
        for (int i = 1; i < unsortArr.length; i++) {
            unsortArr[i] = rand.nextInt(i);
        }
        int[] q = {1,4,3,2,5};
        for (int num : q) {
            System.out.print(num + " ");
        }
        
        System.out.println();
        bubbleSort(q);
        for (int num : q) {
            System.out.print(num + " ");
        }
        

}
public static void bubbleSort(int[] arr){
    int t1;
    // int t2;

    for (int i = 0; i < arr.length; i++) {
       for (int j = 0; j < arr.length; j++) {
           if(arr[i]>arr[j]){   //  >  means sorting in des <  is sorting in asc order
            t1=arr[i];
            arr[i]=arr[j];
            arr[j]=t1;
           }
       } 
    }
}
}