package array.two.sum.n1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @see <a>https://leetcode.com/problems/two-sum/</a>
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        System.out.println("Given nums...");
        System.out.println(Arrays.toString(nums));
        if (nums == null || nums.length < 2) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        System.out.println("map...");
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
            System.out.println("key: " + (target - nums[i]) + ", value: " + i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer v = map.get(nums[i]);
            if (v != null && v != i) {
                return new int[]{i, v};
            }
        }
        return null;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
