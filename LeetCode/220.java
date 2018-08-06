/**
 * 题目：给定一个整数数组，判断数组中是否有两个不同的索引i和j，使得nums[i]和nums[j]的差的绝对值最大为t，并且i和j之间的差的绝对值最大为ķ。
 * 难度：Medium
 * 思路：两种思路，见下。
 */

 //思路1，滑动窗口
 class Solution {
    public boolean containsNearbyAlmostDuplicate(final int[] nums, int k, long t) {
        if (nums.length < 2) {
            return false;
        }
        if (k == 0) {
            return true;
        }
        TreeSet<Long> window = new TreeSet<Long>();
        for(int i = 0;i < nums.length;i++) {
            if (window.floor(nums[i] + t) != null && window.floor(nums[i]+t) >= nums[i]-t) {
                return true;
            }
            window.add(new Long(nums[i]));        
            if (i >= k) {
            	window.remove(new Long(nums[i-k]));
            }
        }
        return false;
    }
}

//思路2，桶，将数组中的几个元素映射到一个桶中，复杂度O(n)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t)) {
                return true;
            }
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}