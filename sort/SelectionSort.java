package Alogorithms.sort;


/**
 * 简单选择排序
 */
public class SelectionSort {


    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[k] > arr[j]) {
                    k = j;
                }
            }
            if (k != i) {
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {123,54,2342,3445,231,123456,432,2,4,13,45,18,453,12,123,87};
        SelectionSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
