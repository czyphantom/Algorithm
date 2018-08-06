/**
* 题目：从一个数组里找出三个数，使得和为0，返回所有结果，不能重复。
* 难度：Medium
* 思路：固定开始的位置,然后双指针
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int begin = 0; begin < nums.length - 2; begin++) {
            //跳过重复的数
            if (begin > 0 && nums[begin] == nums[begin - 1]) {
                continue;
            }
            int mid = begin + 1, end = nums.length - 1;
            int target = -nums[begin];
            while (mid < end) {
                if (nums[mid] + nums[end] == target) {
                    res.add(Arrays.asList(nums[begin], nums[mid], nums[end]));
                    mid++;
                    end--;
                    //跳过重复的部分
                    while (mid < end && nums[mid] == nums[mid - 1]) {
                        mid++;
                    }

                    while (mid < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (nums[mid] + nums[end] > target) {
                    end--;
                } else {
                    mid++;
                }
            }
        }
        return res;
    }
}