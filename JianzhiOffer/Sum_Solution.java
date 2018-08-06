/**
* 题目：不能用乘除，循环，条件判断，计算1+2+...+n
* 思路：利用&&的特性：如果第一个为false，后面的就不计算
*/

public class Solution {
    public int Sum_Solution(int n) {
        int res = n;
        boolean flag = (n > 0) && ((res += Sum_Solution(n-1)) > 0);
        return res;
    }
}
