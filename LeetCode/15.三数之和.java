/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 * 题目：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 难度：Medium
 * 思路：我的思路是固定前两个数，然后第三层循环用二分，更简单的方式是只固定一个数，后面两个数双指针去枚举
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0;i < nums.length;) {
            int target = -nums[i];
            for (int j = i+1;j < nums.length;) {
                int target2 = -nums[i]-nums[j];
                int begin = j+1,end = nums.length-1;
                while (begin < nums.length && begin <= end) {
                    int mid = (begin+end)/2;
                    if (nums[mid] > target2) {
                        end = mid-1;
                    } else if (nums[mid] < target2) {
                        begin = mid+1;
                    } else {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(nums[i]);
                        triple.add(nums[j]);
                        triple.add(nums[mid]);
                        result.add(triple);
                        break;
                    }
                }
                while (j+1 < nums.length  && nums[j+1] == nums[j]) {
                    j++;
                }
                j++;
            }
            while (i+1 < nums.length  && nums[i+1] == nums[i]) {
                i++;
            }
            i++;
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

