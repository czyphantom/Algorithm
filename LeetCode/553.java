/**
 * 题目：给定一组正整数，相邻的整数之间将会进行浮点除法操作。但是，你可以在任意位置添加任意数目的括号，来改变算数的优
 * 先级。你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应该含有冗余的括号。
 * 难度：Meidium
 * 思路：水题
 */

class Solution {
    public String optimalDivision(int[] nums) {
        int sum = 1;
        StringBuilder sb = new StringBuilder();
        if (nums == null ||nums.length == 0) {
            return new String();
        }
        if (nums.length == 1) {
            return nums[0] + "";
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        for (int i = 0; i < nums.length; i++) {
            if(i == 1) {
                sb.append("(");
                sb.append(nums[i]);
                sb.append("/");
            } else if(i == nums.length - 1) {
                sb.append(nums[i]).append(")");
            } else {
                sb.append(nums[i]).append("/");
            }
        }
        return sb.toString();     
    }
}