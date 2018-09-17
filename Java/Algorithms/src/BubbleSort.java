import java.util.Arrays;

public class BubbleSort {
    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++)
            for(int j=1; j<arr.length-i; j++)
                if(arr[j-1]>arr[j])
                    swap(arr, j-1, j);
    }


    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
