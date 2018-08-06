/**
 * 题目：一条包含字母A-Z的消息通过以下方式进行了编码，A对应1，以此类推，给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 难度：Medium
 * 思路：动态规划，注意情况很多，要考虑全
 */

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