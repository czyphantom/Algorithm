/**
* 题目：求出一个数中二进制表示所有1的个数
* 思路：对数n进行算数右移与1相与或对1进行左移与n相与，最好的方法为令n=n&(n-1)，因为每次循环会使从右往左
* 第一个1及其之后的全变为0，每次如此操作直到这个数为0
*/

public class Solution {
    public int NumberOf1(int n) {
        int res = 0;
        while(n != 0) {
            if((n&1) == 1) {
                res++;
            }
            n = n >>> 1;
        }
        return res;
    }
}
