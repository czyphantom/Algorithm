/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 * 题目：给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 难度：Medium
 * 思路：根据前一个计算下一个字符串
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2;i <= n;i++) {
            StringBuilder builder = new StringBuilder();
            char[] strArray = result.toCharArray();
            int count = 1;
            char cur = strArray[0];
            for (int j = 1;j < strArray.length;j++) {
                if (strArray[j] == cur) {
                    count++;
                } else {
                    builder.append(count).append(cur);
                    count = 1;
                    cur = strArray[j];
                }
            }
            builder.append(count).append(cur);
            result = builder.toString();
        }
        return result;
    }
}
// @lc code=end

