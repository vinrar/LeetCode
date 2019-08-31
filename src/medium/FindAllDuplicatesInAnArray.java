package medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,6,7,9,3,10,9,5,6};
        //int[] arr = new int[]{1,1,2,3};
        List<Integer> list = findDuplicates(arr);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i + 1 && nums[i] != -1) {
                int temp = nums[i];
                if(nums[i] != nums[temp - 1]) {
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                } else {
                    list.add(nums[i]);
                    nums[i] = -1;
                    break;
                }
            }
        }

        return list;
    }
}