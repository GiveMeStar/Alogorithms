package Alogorithms.sort;


/**
 * 快速排序
 */
public class QuickSort {


    /**
     *
     * 一次排序
     *
     * @param arr
     * @param p
     * @param r
     * @return
     */
    public static int partition(int[] arr, int p, int r) {
        int key = arr[r];
        int i = p - 1;
        for (int k = p; k < r; k++) {
            if (arr[k] > key) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;
            }
        }
        int tmp = arr[r];
        arr[r] = arr[i + 1];
        arr[i + 1] = tmp;
        return i + 1;
    }


    /**
     *
     * 先排序 在分 在排
     *
     * @param arr
     * @param p
     * @param r
     */
    public static void sort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            sort(arr, p, q - 1);
            sort(arr, q + 1, r);
        }
    }



    public static void main(String[] args) {
        int[] arr = {123,54,2342,3445,231,123456,432,2,4,13,45,18,453,12,123,87};
        QuickSort.sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
