package medium;

public class KConcatenationMaxSum {
    public static void main(String[] args) {
        int[] arr = new int[10];
    }

    public int kConcatenationMaxSum(int[] arr, int k) {
        int out = 0;

        int totalSum = 0;

        int n = arr.length;
        int prevSum = arr[0];

        int value = arr[0];

        for(int i = 1; i < n; i++) {
            totalSum += arr[i];

            if(prevSum < 0) {
                prevSum = arr[i];
            } else {
                prevSum += arr[i];
            }

            if(prevSum > value) {
                value = prevSum;
            }
        }

        if(totalSum < 0)
            return 0;

        int[] revSum = new int[n + 1];
        revSum[n] = 0;

        int localTotal = totalSum;

        for(int i = n-1; i >= 0; i--) {
            revSum[i] += arr[i] + revSum[i + 1];
            if(revSum[i] > localTotal) {
                localTotal = revSum[i];
            }
        }

        out = localTotal + totalSum * (k - 1);

        return out;
    }
}