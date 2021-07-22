/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 * 题目：给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词指字母相同，但排列不同的字符串。
 * 难度：Medium
 * 思路：对每个字符串的字符进行排序，得到标准字符串，放到Map里保存。
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        if (strs == null) {
            return result;
        }
        for (int i = 0;i < strs.length;i++) {
            String s = toStandardStr(strs[i]);
            if (!resultMap.containsKey(s)) {
                resultMap.put(s, new ArrayList<String>());
            } 
            resultMap.get(s).add(strs[i]);
        }
        for (Map.Entry entry : resultMap.entrySet()) {
            result.add((List<String>)entry.getValue());
        }
        return result;
    }

    private String toStandardStr(String s) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        return new String(sArray);
    }
}
// @lc code=end

