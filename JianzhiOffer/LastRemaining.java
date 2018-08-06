/**
* 题目：约瑟夫环
* 思路：可以容易求得递归关系
*/

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(m <= 0 || n <= 0)
            return -1;
        if(n == 1)
            return 0;
        else 
            return (LastRemaining_Solution(n-1,m)+m)%n;
    }
}