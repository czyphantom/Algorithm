/**
* 题目大意：从一个数组里找出三个数，使得和为0，返回所有结果，不能重复。
* 难度：Medium
* 思路：固定开始的位置，然后从后面找两个数的和为开始位置数的相反数，不过要注意排除重复的情况，将数组按从* 小到大排序后注意跳过相同的值即可。
*/

public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int begin = 0; begin < nums.length - 2; begin++) {
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
                while (mid < end && nums[mid] == nums[mid - 1])
                    mid++;
                while (mid < end && nums[end] == nums[end + 1])
                    end--;
            } else if (nums[mid] + nums[end] > target) {
                end--;
            } else {
                mid++;
            }
        }
    }
    return res;
}
