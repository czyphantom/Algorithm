/**
 * 题目：给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums[i]=nums[j]，并且i和j的差的绝
 * 对值最大为k。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      Map<Integer, Integer> left = new HashMap<Integer, Integer>();
      for (int i = 0; i < nums.length; i ++){
          if (left.containsKey(nums[i])){
              if (i-left.get(nums[i]) <= k){
                  return true;
              }
          }
          left.put(nums[i], i);
      }
      return false;
  }
}