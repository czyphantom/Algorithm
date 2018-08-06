/**
 * 题目：编写一个算法来判断一个数是不是“快乐数”。一个“快乐数”定义为：对于一个正整数，
 * 每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为1，也可能是无限循环但始终变不到1。
 * 如果可以变为 1，那么这个数就是快乐数。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public boolean isHappy(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        while(n != 1) {
            if(!map.containsKey(squareSum(n))) {
                map.put(squareSum(n),n);
                n = squareSum(n);
            }
            else
                return false;      
        }
        return true;
    }
    private int squareSum(int num) {
        int sum = 0;
        while(num != 0) {
            int temp = num%10;
            sum += temp*temp;
            num /= 10;
        }
        return sum;
    }
} 