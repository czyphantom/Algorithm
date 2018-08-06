/**
* 题目：只含有2,3,5的质因子为丑数，求第n个，第一个为1。
* 思路：动态规划求解，因为当前某一个丑数一定为前面某一个*2，*3,*5得来
*/

public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0)
            return index;
        int[] dp = new int[index];
        dp[0] = 1;
        int n2 = 0,n3 = 0,n5 = 0;
        for(int i = 1;i < index;i++) {
            dp[i] = Math.min(Math.min(dp[n2]*2,dp[n3]*3),dp[n5]*5);
            if(dp[i] == dp[n2]*2)
                n2++;
            if(dp[i] == dp[n3]*3)
                n3++;
            if(dp[i] == dp[n5]*5)
                n5++;
        }
        return dp[index-1];
    }
}
