/**
 * 题目：给定一个数组nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口k内的数字。滑动窗口每次只向右移动一位。返回滑动窗口最大值。
 * 难度：Hard
 * 思路：使用双端队列保存最大值，窗口滑动时，比较值是否过期。
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int index = 0;
        if (k == 0)
            return result;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            begin = i - k + 1;
            if (q.isEmpty()) {
                q.add(i);
            }
            if (begin > q.peekFirst()) {
                q.pollFirst();
            }
            while ((!q.isEmpty()) && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.add(i);
            if (begin >= 0) {
                result[index++] = nums[q.peekFirst()];
            }
        }
        return result;
    }
}