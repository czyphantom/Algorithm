/**
 * 题目：给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 难度：Medium
 * 思路：动态规划
 */

class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        for(int i = 1;i < len;i++){
            int tmpNum = 0;
            for(int j = 0;j < i;j++)
                if(s.charAt(i)== s.charAt(j)){
                    String subStr = s.substring(j,i+1);
                    if(isPalindromic(subStr)) {
                        tmpNum++;
                    }
                }
            dp[i] = dp[i-1] + tmpNum;
        }
        return dp[len-1] + len;
    }

    private boolean isPalindromic(String s) {
        for (int i = 0;i < s.length()/2;i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) {
                return false;
            }
        } 
        return true;
    }
}