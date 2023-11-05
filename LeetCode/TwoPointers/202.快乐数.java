/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 * 题目：编写一个算法来判断一个数n是不是快乐数。
 * 快乐数定义：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为1，也可能是无限循环但始终变不到 1。
 * 如果这个过程结果为1，那么这个数就是快乐数。
 * 难度：Easy
 * 思路：Set判断或者快慢指针
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Long> exists = new HashSet<>();
        exists.add((long)n);
        long result = getHappy(n);
        while (result != 1) {
            if (exists.contains(result)) {
                return false;
            }
            exists.add(result);
            result = getHappy(result);
        }
        return true;
    }

    private long getHappy(long n) {
        long result = 0L;
        while (n != 0) {
            result += (n%10)*(n%10);
            n /= 10;
        } 
        return result;
    }

    //方法2：快慢指针
    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}
// @lc code=end

