package contests.contest152;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        int[] arr = new int[]{6,5,0,0};
        System.out.println(dietPlanPerformance(arr, 2, 1, 5));
        //int[] arr = new int[]{1,1,2,3};
        //List<Integer> list = findDuplicates(arr);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int count = 0;
        int sum = 0;
        int n = calories.length;

        for(int i = 0; i < k; i++) {
            sum += calories[i];
        }

        if(sum < lower) {
            count -= 1;
        } else if(sum > upper) {
            count += 1;
        }

        for(int i = k; i < n; i ++) {
            sum += calories[i];
            sum -= calories[i - k];
            if(sum < lower) {
                count -= 1;
            } else if(sum > upper) {
                count += 1;
            }

        }

        return count;
    }
}
