/**
* 题目：从数组中找出三个数的和与目标数最接近，返回这个和。
* 难度：Medium
* 思路：思路类似第15题
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0x7fffffff;
        boolean flag = false;
        for (int begin = 0; begin < nums.length - 2; begin++) {
            int mid = begin + 1, end = nums.length - 1;
            while (mid < end) {
                if(nums[begin]+nums[mid]+nums[end] > target) {
                    if(nums[begin]+nums[mid]+nums[end]-target < res) {
                        res = nums[begin]+nums[mid]+nums[end]-target;
                        flag = true;
                        end--;
                    } else {
                        end--;
                    }
                }
                else {
                    if(target-(nums[begin]+nums[mid]+nums[end]) < res) {
                        res = target-(nums[begin]+nums[mid]+nums[end]);
                        flag = false;
                        mid++;
                    }else
                        mid++;
                }
            }
        }
        return flag ? (res+target) : (target-res);
    }
}