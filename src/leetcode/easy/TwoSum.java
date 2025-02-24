package leetcode.easy;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2:
 * 
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Example 3:
 * 
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 */

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {

    if (nums.length == 2) {
      if (nums[0] + nums[1] == target) {
        return new int[] { 0, 1 };
      }
    }

    var values = new HashMap<Integer, Integer>();

    for (int i = 0; i < nums.length; i++) {
      values.put(nums[i], i);
    }

    var result = new int[2];

    for (int i = 0; i < nums.length; i++) {
      var second = values.get(target - nums[i]);
      if (second != null && second != i) {
        result[0] = i;
        result[1] = second;
        break;
      }
    }

    return result;
  }
}
