import java.util.Random;

public class insertion {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] unsortArr = new int[10];
        
        for (int i = 1; i < unsortArr.length; i++) {
            unsortArr[i] = rand.nextInt(i);
        }
        
        for (int num : unsortArr) {
            System.out.print(num + " ");
        }

        System.out.println();
        insertionSort(unsortArr);
        for (int num : unsortArr) {
            System.out.print(num + " ");
        }

    }
    public static void insertionSort(int [] arr) {
        for(int i=1;i<arr.length;i++){
            int temp = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>temp) { 
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
}
