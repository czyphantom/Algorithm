/**
 * 题目：给定一个整数数组a，其中1≤a[i]≤n （n为数组长度）, 其中
 * 有些元素出现两次而其他元素出现一次。找到所有出现两次的元素。
 * 难度：Medium
 * 思路：先把第i位放i+1，再找不在位置上的。
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i < nums.length;) {
            if(nums[nums[i]-1] != nums[i]) {
                swap(nums,i,nums[i]-1);
            } else
                i++;
        }
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] != i+1) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}