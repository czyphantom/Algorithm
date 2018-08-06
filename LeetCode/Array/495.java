/**
 * 题目大意：反正是水题
 * 难度：Medium
 * 思路：水题
 */
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0)
            return 0;
        int result = duration;
        for(int i = 1;i < timeSeries.length;i++) {
            result = result + duration - (duration+timeSeries[i-1]>timeSeries[i]?(duration+timeSeries[i-1]-timeSeries[i]):0);
        }
        return result;
    }
}