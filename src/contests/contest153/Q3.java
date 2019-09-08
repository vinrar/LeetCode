package contests.contest153;

public class Q3 {

    public static void main(String args[]) {
        int arr[] = new int[] {1,2,0,3};
        //System.out.println(maximumSum(arr));

//        arr = new int[] {1,2,0,-3};
//        System.out.println(maximumSum(arr));

//        arr = new int[] {1,2,0,-3};
//        System.out.println(maximumSum(arr));

//        arr = new int[] {1,-2,0,-3};
//        System.out.println(maximumSum(arr));

//        arr = new int[] {-1,2,0,3};
//        System.out.println(maximumSum(arr));
//
//        arr = new int[] {1,11,-10,10, -1, 3};
//        System.out.println(maximumSum(arr));

//        arr = new int[] {-1, 3, -1, 3, -1, 3};
//        System.out.println(maximumSum(arr));

//        arr = new int[] {-1, -1, -2, -1, -1, -1};
//        System.out.println(maximumSum(arr));

        arr = new int[] {11,-10,-11,8,7,-6,9,4,11,6,5,0};
        System.out.println(maximumSum(arr));
    }

    public static int maximumSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int localSum = 0, remVal = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }

            localSum += arr[i];

            if(arr[i] < remVal) {
                remVal = arr[i];
            }

            if(localSum - remVal <= 0) {
                localSum = 0;
                remVal = 0;
            } else {
                if(localSum - remVal > max) {
                    max = localSum - remVal;
                }
            }
        }
        return max;
    }
}
