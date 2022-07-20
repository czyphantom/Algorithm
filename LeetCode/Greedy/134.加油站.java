/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 * 题目：在一条环路上有n个加油站，其中第i个加油站有汽油gas[i]升。
 * 你有一辆油箱容量无限的的汽车，从第i个加油站开往第i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组gas和cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回-1。如果存在解，则保证它是唯一的。
 * 难度：Medium
 * 思路：贪心
 */

// @lc code=start
class Solution {

    //我的解法，有点像求解最长子数组和，只要某个连续子数组和小于0，那么从那个点开始就不能环绕一圈
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || gas.length != cost.length) {
            return -1;
        }
        int len = gas.length;
        int index = 0, sum = 0,total = 0;;
        for (int i = 0;i < len;i++) {
            total += gas[i]-cost[i];
            if (sum < 0) {
                index = i;
                sum = 0;
            } 
            sum += gas[i]-cost[i];
        }
        if (total < 0) {
            return -1;
        }
        return index;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int rest = 0, run = 0, start = 0;
        for (int i = 0; i < gas.length; ++i) {
            run += (gas[i] - cost[i]);
            rest += (gas[i] - cost[i]);
            if (run < 0){
                start = i + 1;
                run = 0;
            }
        }
        return rest < 0 ? -1: start;
    }


}
// @lc code=end

