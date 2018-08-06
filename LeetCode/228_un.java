/**
 * 题目：给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * 难度：Medium
 * 思路：双指针
 */

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums == null || nums.length < 1) {
            return list;
        }
        int begin = 0;
        int end = 0;
        while(end < nums.length) {
            if (end < nums.length - 1 && nums[end+1] == nums[end] + 1) {
                end++;
            } else {
                if(begin == end) {
                    list.add(Integer.toString(nums[begin]));
                }else {
                    String str = nums[begin] + "->" + nums[end];
                    list.add(str);
                }
                end++;
                begin = end;
            }
        }
        return list;
    }
} 