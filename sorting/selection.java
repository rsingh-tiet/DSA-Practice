import java.util.Random;

public class selection {
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
        selectionSort(q);
        for (int num : q) {
            System.out.print(num + " ");
        }
        

    }
    public static void selectionSort(int[] arr){
        int t1;
        for (int i = 0; i < arr.length; i++) {
            int smallest= i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    smallest = j;
                }
            }
            t1=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=t1;
        }
    }
}
