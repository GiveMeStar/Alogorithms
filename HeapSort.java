package Alogorithms;

public class HeapSort {

    private int parent(int i) {
        return i/2;
    }

    private int left(int i) {
        return i * 2;
    }

    private int right(int i) {
        return i * 2 + 1;
    }

    private void maxHeapIfy(int[] A, int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l <= A[A.length - 1] && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= A[A.length - 1] && A[r] > A[largest]) largest = r;
        if (largest != i) {
            int tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;
            maxHeapIfy(A, largest);
        }
    }

    public void buildMaxHeap(int[] A) {
        A[A.length - 1] = A.length - 2;
        for (int i = (A.length - 2)/2; i > 0; i--) maxHeapIfy(A, i);
    }

    public void HeapSort(int[] A) {
        buildMaxHeap(A);
        for (int i = A.length - 2; i > 1; i--) {
            int tmp = A[i];
            A[i] = A[1];
            A[1] = tmp;
            A[A.length - 1] = A[A.length - 1] - 1;
            maxHeapIfy(A, 1);
        }
    }
}
