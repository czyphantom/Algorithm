/** 
* 题目：斐波那契数列
* 思路：水题
*/

public class Solution {
    public int Fibonacci(int n) {
        if(n == 0)
            return 0;
        int x = 1,y = 0;
        int res = 1;
        while(n > 1) {
            res = x + y;
            y = x;
            x = res;
            n--;
        }
        return res;
    }
}
