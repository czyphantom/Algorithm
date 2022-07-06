/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 * 题目：给定一个只包含数字的字符串，用以表示一个IP地址，返回所有可能从s获得的 有效IP地址。你可以按任何顺序返回答案。
 * 有效IP地址正好由四个整数（每个整数位于0到255之间组成，且不能含有前导0），整数之间用'.'分隔。
 * 难度：Medium
 * 思路：回溯
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }
    
    private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
        if (count > 4) {
            return;
        }
        if (count == 4 && idx == ip.length()) {
            solutions.add(restored);
        }
        for (int i = 1;i < 4;i++) {
            if (idx+i > ip.length()) {
                break;
            }
            String s = ip.substring(idx,idx+i);
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256)) {
                continue;
            }
            restoreIp(ip, solutions, idx+i, restored + s + (count == 3 ? "" : "."), count + 1);
        }
    }
}
// @lc code=end

