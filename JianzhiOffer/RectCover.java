/**
* 题目：用2*1的举行覆盖2*n的矩形，问有多少种方法
* 思路：得到递推关系类似斐波那契数列
*/

public class Solution {
    public int RectCover(int target) {
        if(target <= 0)
            return 0;
        else if(target == 1)
            return 1;
        else if(target == 2)
            return 2;
        else {
            int m = 1,n = 2;
            int res = m+n;
            while(target > 3) {
                m = n;
                n = res;
                res = m+n;
                target--;
            }
            return res;
        }
    }
}
