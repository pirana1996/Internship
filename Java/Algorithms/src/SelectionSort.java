import java.util.Arrays;

public class SelectionSort {

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void selectionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++)
            for(int j=i+1; j<arr.length; j++)
                if(arr[i] > arr[j])
                    swap(arr, i, j);
    }

    public static void main(String[] args){
        int[] arr = {6,5,4,3,2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
