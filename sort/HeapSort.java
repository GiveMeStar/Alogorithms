package Alogorithms.sort;

public class HeapSort {


    public static int heap_size; // 堆大小

    public static int left(int i) {
        return 2 * i;
    }

    public static int right(int i) {
        return (2 * i) + 1;
    }


    /**
     *
     * 维护最大堆得特性
     *
     * @param arr
     * @param i
     */
    public static void maxHeap(int[] arr, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        // 选取三个中的最大一个成为跟节点
        if (l < heap_size) {
            if (arr[l] > arr[i]) largest = l;
            else largest = i;
        }
        if (r < heap_size) {
            if (arr[r] > arr[largest]) {
                largest = r;
            }
        }
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            maxHeap(arr, largest);
        }
    }


    /**
     *
     * 构建最大堆
     *
     * @param arr
     */
    public static void buildMaxHeap(int[] arr) {
        heap_size = arr.length;
        for (int i = arr.length / 2; i >= 0 ; i--) {
            maxHeap(arr, i);
        }
    }


    /**
     *
     * 排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[heap_size - 1];
            arr[heap_size - 1] = tmp;
            heap_size = heap_size - 1;
            maxHeap(arr, 0);
        }
    }


    public static void main(String[] args) {
        int[] arr = {123,54,2342,3445,231,123456,432,2,4,13,45,18,453,12,123,87,1};
        HeapSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
