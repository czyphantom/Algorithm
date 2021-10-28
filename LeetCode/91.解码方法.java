/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 * 题目：一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * A->1,B->2...Z->26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回解码方法的 总数 。
 * 难度：Medium
 * 思路：dp
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if(s.length() == 1 && Integer.parseInt(s ) >= 1) {
            return 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if(s.charAt(1) == '0') {
            if(s.charAt(0)=='1' || s.charAt(0)=='2') {
                dp[1] = 1;
            }
            else {
                return 0;
            }
        } else {
            dp[1] = Integer.parseInt(s.substring(0, 2)) <= 26 && Integer.parseInt(s.substring(0, 2))>=1 ? 2 : 1;
        }
        for(int i = 2;i < s.length();i++) {
            StringBuilder builder = new StringBuilder();
            String str = builder.append(s.charAt(i-1)).append(s.charAt(i)).toString();
            if(s.charAt(i) == '0') {
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    dp[i] = dp[i-2];
                } else {
                    return 0;
                }
            } else {
                if(s.charAt(i-1) == '0') {
                    dp[i] = dp[i-1];
                }
                else if (Integer.parseInt(str) >=1 && Integer.parseInt(str) <= 26) {
                    dp[i] = dp[i-2]+dp[i-1];
                } else {
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[s.length()-1];
    }
}
// @lc code=end

