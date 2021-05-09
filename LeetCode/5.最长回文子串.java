/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 * 题目：给你一个字符串s，找到s中最长的回文子串。
 * 难度：Medium
 * 思路：从中心向外拓展去看是否是回文串。更好的解法为Manacher解法。也可以用动态规划做。
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        String result = null;
        if (s == null || s.length() <= 1) {
            return s;
        }
        int max = 1;
        for (int i = 0;i < s.length()-1;i++) {
            int before = i-1;
            int after = i+1;
            while (before >= 0 && after <= s.length()-1 && s.charAt(before) == s.charAt(after)) {
                before--;
                after++;
            }
            if (after-before-1 >= max) {
                result = s.substring(before+1, after);
                max = after-before-1;
            }
            before = i-1;
            after = i+1;
            if (before >= 0 && s.charAt(before) == s.charAt(i)) {
                before--;
            }
            while (before >= 0 && after <= s.length()-1 && s.charAt(before) == s.charAt(after)) {
                before--;
                after++;
            }
            if (after-before-1 >= max) {
                result = s.substring(before+1, after);
                max = after-before-1;
            }
            before = i-1;
            after = i+1;
            if (after < s.length() && s.charAt(after) == s.charAt(i)) {
                after++;
            }
            while (before >= 0 && after <= s.length()-1 && s.charAt(before) == s.charAt(after)) {
                before--;
                after++;
            }
            if (after-before-1 >= max) {
                result = s.substring(before+1, after);
                max = after-before-1;
            }
        }
        return result;
    }

    /**
     * 动态规划解法
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 中心拓展标准解答
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    
    /**
     * Manacher算法
     */
    public String longestPalindrome(String s) {
        int start = 0, end = -1;
        StringBuffer t = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

        List<Integer> arm_len = new ArrayList<Integer>();
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int cur_arm_len;
            if (right >= i) {
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }
}
// @lc code=end

