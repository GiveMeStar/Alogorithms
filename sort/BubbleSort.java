package Alogorithms.sort;


/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int key = arr[j];
                    arr[j] = arr[i];
                    arr[i] = key;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {123,54,2342,3445,231,123456,432,2,4,13,45,18,453,12,123,87};
        BubbleSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
