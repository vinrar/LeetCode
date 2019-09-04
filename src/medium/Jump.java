package medium;

public class Jump {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,0,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        return jumper(nums, 0);
    }

    public static int jumper(int[] nums, int index) {
        if(index >= nums.length)
            return Integer.MAX_VALUE- 1;

        if(index == nums.length - 1)
            return 0;

        int count = Integer.MAX_VALUE - 1;
        int val = nums[index];

        for(int j = 1; j <= val; j++) {
            int localCount = 1 + jumper(nums, index + j);
            if(localCount < count) {
                count = localCount;
            }
        }

        return count;
    }
}
