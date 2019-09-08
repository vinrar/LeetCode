package contests.contest153;

public class contest153 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
//        System.out.println(distanceBetweenBusStops(arr, 0, 1));
//        System.out.println(distanceBetweenBusStops(arr, 0, 2));
//        System.out.println(distanceBetweenBusStops(arr, 0, 3));
//
//        arr = new int[]{5,20,3,4};
//        System.out.println(distanceBetweenBusStops(arr, 0, 1));
//        System.out.println(distanceBetweenBusStops(arr, 0, 2));
//        System.out.println(distanceBetweenBusStops(arr, 0, 3));

        arr = new int[]{7,10,1,12,11,14,5,0};
        System.out.println(distanceBetweenBusStops(arr, 7, 2));
    }

    public static int distanceBetweenBusStops(int[] arr, int start, int destination) {
        int n = arr.length;

        if(start > destination) {
            int temp = destination;
            destination = start;
            start = temp;
        } else if (start == destination) {
            return 0;
        }

        int forDistance = 0, backDistance = 0;

        for(int i = start; i < destination; i++) {
            forDistance += arr[i];
        }

        for(int i = destination; ; i++) {
            if( i == n) {
                i = 0;
            }
            if(i == start) {
                break;
            }
            backDistance += arr[i];
        }

        if(forDistance < backDistance)
            return forDistance;
        else
            return backDistance;
    }
}
