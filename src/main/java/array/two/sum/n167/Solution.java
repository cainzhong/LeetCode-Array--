package array.two.sum.n167;

import java.util.Arrays;

/**
 * @see <a>https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/</a>
 *
 * Given an array of integers that is already sorted in ascending order, find array.sum.two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the array.sum.two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Solution {
    public int[] towSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            }
            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String args[]) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] result = solution.towSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
