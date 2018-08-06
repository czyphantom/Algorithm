/**
 * 题目：给定一个只包含数字的字符串，复原它并返回所有可能的IP地址格式。
 * 难度：Medium
 * 思路：回溯
 */

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