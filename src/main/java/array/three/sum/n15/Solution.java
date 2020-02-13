package array.three.sum.n15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a>https://leetcode.com/problems/3sum/</a>
 * <p>
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * <p>
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution {
  public List<Integer[]> threeSum(int[] nums, int target) {
    List<Integer[]> result = new ArrayList<Integer[]>();
    if (nums == null || nums.length < 3) {
      return null;
    }

    int numsLen = nums.length;
    for (int i = 0; i < numsLen; i++) {
      for (int j = i + 1; j < numsLen; j++) {
        for (int k = j + 1; k < numsLen; k++) {
          int sum = nums[i] + nums[j] + nums[k];
          if (sum == target) {
            result.add(new Integer[]{nums[i], nums[j], nums[k]});
          }
        }
      }
    }
    return result;
  }

  public List<Integer[]> removeDuplicateTriplets(List<Integer[]> list) {
    List<Integer[]> result = new ArrayList<Integer[]>();
    int size = list.size();
    int arrayLen = 0;
    for (int i = 0; i < size; i++) {
      Integer[] integers = list.get(i);
      List<Integer> list1 = Arrays.asList(integers);
      arrayLen = integers.length;
      for (int j = i + 1; j < size; j++) {
        Integer[] integers2 = list.get(j);
        List<Integer> list2 = Arrays.asList(integers2);
        for (int k = 0; k < arrayLen; k++) {
          if (!list2.contains(list1.get(k))) {
            result.add(list.get(i));
            break;
          }
        }
      }
    }
    return result;
  }

  public static void main(String args[]) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    int target = 0;
    Solution solution = new Solution();
    List<Integer[]> result = solution.threeSum(nums, target);
    result = solution.removeDuplicateTriplets(result);
    for (Integer[] integers : result) {
      System.out.println(Arrays.toString(integers));
    }
  }
}
