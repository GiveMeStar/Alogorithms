package Alogorithms.sort;

/**
 * 归并排序
 */
public class MergeSort {


    /**
     *
     * 合并
     *
     * @param arr
     * @param p
     * @param q
     * @param r
     *  p <= q < r
     */
    public static void merge(int[] arr, int p, int q, int r) {
        int[] L = new int[q - p + 2];
        for (int i = 0; i < q - p + 1; i++) {
            L[i] = arr[p + i];
        }
        L[q - p + 1] = Integer.MAX_VALUE;
        int[] R = new int[r - q + 1];
        for (int i = 0; i < r - q; i++) {
            R[i] = arr[q + i + 1];
        }
        R[r - q] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
        }
    }


    /**
     *
     * 递归分解 在合并
     *
     * @param arr
     * @param p
     * @param r
     */
    public static void mergeSort(int[] arr, int p, int r) {
        if (p < r) {
            mergeSort(arr, p, (p + r) / 2);
            mergeSort(arr, ((p + r) / 2) + 1, r);
            merge(arr, p, (p + r) / 2, r);
        }
    }




    public static void main(String[] args) {
        int[] arr = {2,4,13,45,18,453,12,123,87};
        MergeSort.mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
