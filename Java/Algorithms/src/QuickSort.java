import java.util.Arrays;

public class QuickSort {
    /**
     *
     * @param arr
     * @param left 0 based
     * @param right 0 based
     * @return
     */
    public static int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int pIndex = left;
        for(int j=left; j<=right-1; j++){
            if(arr[j] < pivot) {
                swap(arr, pIndex, j);
                pIndex++;
            }
        }
        swap(arr, pIndex, right);
        return pIndex;
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void quickSort(int[] arr, int left, int right){
        if(left<right){
            int p = partition(arr, left, right);
            quickSort(arr, left, p-1);
            quickSort(arr, p+1, right);
        }
    }

    public static void main(String[] args){
        int[] a = {3,4,5,7,9,1,4};
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
