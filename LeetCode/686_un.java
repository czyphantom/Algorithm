/**
 * 题目：给定两个字符串A和B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回-1。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if(sb.toString().contains(B)) {
            return count;
        }
        if(sb.append(A).toString().contains(B)) {
            return ++count;
        }
        return -1;
    }
} 