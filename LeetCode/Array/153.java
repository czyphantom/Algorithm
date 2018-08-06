/**
* 题目大意：求旋转数组的最小值（不含重复元素）
* 难度：Medium
* 思路：后一个比前一个小就是最小值，二分变形
*/

public int findMin(int[] nums) {
      int begin = 0;
      int end = nums.length-1;
      int result = nums[0];
      while(begin <= end) {
          int mid = (end-begin)/2+begin;
          if(nums[mid] < nums[begin]) {
              if(mid-1>=0 && nums[mid]<nums[mid-1]) {
                  result = nums[mid];
                  break;
              }
              end = mid;
          }
          else if(nums[mid] > nums[end]) {
              if(mid-1>=0 && nums[mid]<nums[mid-1]) {
                  result = nums[mid];
                  break;
              }
              begin = mid+1;
          }
          else {
              result = nums[begin];
              break;
          }
      }
      return result;
}
