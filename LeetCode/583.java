/**
 * 题目：给定两个单词word1和word2，找到使得word1和word2相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * 难度：Medium
 * 思路：动态规划
 */

class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0)
            return word2.length();
        if(word2.length() == 0)
            return word1.length();

        int[][] dp = new int[word1.length()][word2.length()];
        for(int i = 0;i < word1.length();i++) {
            for(int j = 0;j < word2.length();j++) {
                if(i==0 || j==0) {
                    if(word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = 1;
                    } else {
                        if(i != 0) {
                            dp[i][j] = dp[i-1][j];
                        }
                        if(j != 0) {
                            dp[i][j] = dp[i][j-1];
                        }
                    }
                }
                else {
                    if(word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = Math.max(Math.max(dp[i-1][j-1]+1,dp[i-1][j]),dp[i][j-1]);
                    }
                    else {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }

        return word1.length()+word2.length()-2*dp[word1.length()-1][word2.length()-1];
    }
}