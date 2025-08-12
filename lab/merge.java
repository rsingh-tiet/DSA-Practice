
import java.util.Random;

public class merge {
    public static void main(String[] args) {
        Random rnd = new Random();
        int [] numbers = new int[3];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rnd.nextInt();
        }
        
        int[] q = {4,2,0,7,1,3};
        printArr(q);
        mergeSort(q);
        System.out.println();
        printArr(q);
    }
    public static void printArr(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void mergeSort(int [] arr){

        int length = arr.length;

        if(length<=1){
            return;
        }
        int mid = length/2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[length-mid];

        for (int index = 0; index < mid; index++) {
            leftArr[index] = arr[index];
        }
        for (int index = mid; index < arr.length; index++) {
            rightArr[index-mid] = arr[index];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);

        mergeTog(leftArr,rightArr,arr);
    }
    public static void mergeTog(int[] leftArr,int[] rightArr,int[] arr) {
        int leftSize = leftArr.length;
        int rightSize = rightArr.length;

        // for(int k = 0 ;k<arr.length;k++){
        //     int i =0, j=0;
        //     if(leftArr[i]<rightArr[j]){
        //         arr[k]=leftArr[i];
        //         i++;
        //     }
        //     else if(rightArr[j]<leftArr[i]){
        //         arr[k]= rightArr[j];
        //         j++;
        //     }
        //     while(i<leftSize){
        //         arr[k] = leftArr[i];
        //         i++;k++;
        //     }
        //     while(j<rightSize){
        //         arr[k] = rightArr[j];
        //         j++;k++;
        //     }
        // }


        //*********************************************** */
        
    
    int i = 0, j = 0, k = 0;
    
    while (i < leftSize && j < rightSize) {
      if (leftArr[i] <=arr[j]) {
        arr[k] = leftArr[i];
        i++;
      }
      else {
        arr[k] = rightArr[j];
        j++;
      }
      k++;
    }
    
    while (i < leftSize) {
      arr[k] = leftArr[i];
      i++;
      k++;
    }
    
    while (j < rightSize) {
      arr[k] = rightArr[j];
      j++;
      k++;
    }}
}
