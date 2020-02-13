package array.three.sum.n15;

import java.util.*;

/**
 * @see <a>https://leetcode.com/problems/3sum/discuss/507509/JAVA-Sorting-and-using-2-pointers-Runtime%3A-O(N2)-84.12-and-97.17</a>
 * <p>
 * JAVA - Sorting and using 2 pointers
 * 主要解题思路：
 * 1. 排序
 * 2. 前后双指针
 */
public class Solution1 {
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length < 3) {
      return null;
    }
    List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>> ansSet = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      // 如果nums[i]和前一个值相等，那么nums[i] + nums[start] + nums[end]必然相等，
      // 这个计算过程在“nums[i-1] + nums[start] + nums[end]”已经计算过，不需要重复计算。
      // 关键在于题目中不允许相同值得组合。 Note: The solution set must not contain duplicate triplets.
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int start = i + 1, end = nums.length - 1;
      while (start < end) {
        if (nums[i] + nums[start] + nums[end] > 0) {
          end--;
        } else if (nums[i] + nums[start] + nums[end] < 0) {
          start++;
        } else {
          // Condition: nums[i] + nums[start] + nums[end] == 0
          ansSet.add(Arrays.asList(nums[i], nums[start], nums[end]));
          start++;
        }
      }
    }
    ans.addAll(ansSet);
    return ans;
  }

  public static void main(String args[]) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
//    int[] nums = {0, 0, 0, 0, 0, 0};
    Solution1 solution = new Solution1();
    List<List<Integer>> result = solution.threeSum(nums);
    for (List<Integer> integers : result) {
      System.out.println(integers);
    }
  }
}
