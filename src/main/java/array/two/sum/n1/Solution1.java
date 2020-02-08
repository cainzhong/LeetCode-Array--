package array.two.sum.n1;

import java.util.Arrays;

/**
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        System.out.println("Given nums...");
        System.out.println(Arrays.toString(nums));
        if (nums == null || nums.length < 2) {
            return null;
        }

        int[] corresponding_nums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            corresponding_nums[i] = target - nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < corresponding_nums.length; j++) {
                if (nums[i] == corresponding_nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String args[]) {
        Solution1 solution = new Solution1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
