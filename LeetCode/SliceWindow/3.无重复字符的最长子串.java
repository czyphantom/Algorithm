/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 * 题目：给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * 难度：Medium
 * 思路：采用滑动窗口的思想，出现重复字符时，将窗口的开始移动到重复的字符上次出现的位置后一位。
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> deque = new LinkedList<>();
        int result = 0, begin = 0;
        for (int i = 0;i < s.length();i++) {
            deque.offer(s.charAt(i));
            if (map.containsKey(s.charAt(i))) {
                result = Math.max(result, i-begin);
                begin = map.get(s.charAt(i))+1;
                map.put(s.charAt(i), i);
                while (!deque.isEmpty() && deque.peek() != s.charAt(i)) {
                    char c = deque.poll();
                    map.remove(c);
                }
                if (!deque.isEmpty()) {
                    deque.poll();
                }
            } else {
                map.put(s.charAt(i), i);
                result = Math.max(result, i-begin+1);
            }
        }
        return result;
    }

    //标答
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
// @lc code=end

