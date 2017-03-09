package Alogorithms;

public class Sort {


    //插入排序（升序）
    public void insertionSortUp(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && key < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }


    //归并排序
    public void mergeSort(int A[], int p, int r) {
        if (p < r) {
            int q = (p + r)/2;
            //分解
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public void mergeSort(int A[]) {
        this.mergeSort(A, 0, A.length - 1);
    }

    //归并排序合并
    public void merge(int A[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int L[] = new int[n1 + 1];
        int R[] = new int[n2 + 1];
        for (int i = 0; i < n1; i++) L[i] = A[p + i];
        for (int i = 0; i < n2; i++) R[i] = A[q + i + 1];
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++){
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }
}
