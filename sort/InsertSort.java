package Alogorithms.sort;

/**
 * 插入排序
 */
public class InsertSort {


    /**
     *
     * 插入排序 升序
     *
     * @param arr
     */
    public static void sortAsc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i -1;
            int key = arr[i];
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];  //向后移动一位
                j --;
            }
            arr[j + 1] = key;
        }
    }


    /**
     *
     * 插入排序  降序
     *
     * @param arr
     */
    public static void sortDesc(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            int j = i + 1;
            int key = arr[i];
            while (j < arr.length && key < arr[j]) {
                arr[j - 1] = arr[j];  //向后移动一位
                j ++;
            }
            arr[j - 1] = key;
        }
    }



    public static void main(String[] args) {
        int[] arr = {2,4,13,45,18,453,12,123,87};
        InsertSort.sortAsc(arr);
        InsertSort.sortDesc(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
