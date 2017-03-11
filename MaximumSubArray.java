package Alogorithms;


public class MaximumSubArray {

    public int[] findMaximum(int A[], int low, int high) {
        int[] data = new int[3];
        if (low == high) {
            data[0] = low;
            data[1] = high;
            data[2] = A[low];
            return data;
        } else {
            int mid = (low + high) / 2;
            int[] left = findMaximum(A, low, mid);
            int[] right = findMaximum(A, mid + 1, high);
            int[] sum = findMaxCrossing(A, low, mid, high);
            if (left[2] > right[2] && left[2] > sum[2]) {
                return left;
            } else if(right[2] > left[2] && right[2] > sum[2]){
                return right;
            } else {
                return sum;
            }
        }
    }

    public int[] findMaxCrossing(int A[], int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int[] value = new int[3];
        for (int i = mid; i >= low; i--) {
            sum = sum + A[i];
            if (sum > leftSum) {
                leftSum = sum;
                value[0] = i;
            }
        }

        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum = sum + A[i];
            if (sum > rightSum) {
                leftSum = sum;
                value[1] = i;
            }
        }
        value[2] = leftSum + rightSum;
        return value;
    }

}
