import java.util.Arrays;

public class InsertionSort {

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    /**
     * Loop variant of insertionSort
     * @param arr
     */
    static void insertionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<i; j++){
                if(arr[j] > arr[i])
                    swap(arr, i, j);
            }
        }
    }

    /**
     * Recursive variant of insertionSort
     */
    static void insertionSort(int[] arr, int left, int right){
        int len = right - left;
        if(len == 0)
            return;
        insertionSort(arr, left, right-1);

        int last = arr[right];
        len--;
        while(len>=0 && arr[len]>last){
            arr[len+1] = arr[len];
            len--;
        }
        arr[len+1] = last;
    }

    public static void main(String[] args){
        int[] arr = {3,2,1,9,0,4,8};
//        insertionSort(arr);
        insertionSort(arr, 0, 6);
        System.out.println(Arrays.toString(arr));
    }
}
