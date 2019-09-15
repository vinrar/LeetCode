package medium;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        int arr[] = new int[]{-2, 1};
        System.out.println(maxSumSubArray(arr));
    }

    public static int maxSumSubArray(int [] arr) {
        int n = arr.length;
        int prevSum = arr[0];

        int value = arr[0];

        for(int i = 1; i < n; i++) {
            if(prevSum < 0) {
                prevSum = arr[i];
            } else {
                prevSum += arr[i];
            }

            if(prevSum > value) {
                value = prevSum;
            }
        }

        return value;
    }
}