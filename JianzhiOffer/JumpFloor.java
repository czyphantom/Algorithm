/**
* 题目：斐波那契数列
* 思路：用迭代做
*/

public class Solution {
    public int JumpFloor(int target) {
        int m = 1,n = 1;
        int res = 1;
        while(target > 1) {
            res = m + n;
            n = m;
            m = res;
            target--;
        }
        return res;
    }
}
