/**
* 题目：跳台阶的升级版，一次可以跳1,2，...n级台阶。
* 思路：分析得递推关系为f(n)=2×f(n-1)
*/

public class Solution {
    public int JumpFloorII(int target) {
        if(target == 1)
            return 1;
        else
            return 2*JumpFloorII(target-1);
    }
}
