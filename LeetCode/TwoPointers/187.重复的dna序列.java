/*
 * @lcapp=leetcode.cnid=187lang=java
 *
 * [187]重复的DNA序列
 * 题目：DNA序列由一系列核苷酸组成，缩写为'A','C','G'和'T'.。
 * 例如，"ACGAATTCCG"是一个DNA序列
 * 在研究DNA时，识别DNA中的重复序列非常有用。
 * 给定一个表示DNA序列的字符串s，返回所有在DNA分子中出现不止一次的长度为10的序列(子字符串)。你可以按任意顺序返回答案。
 * 难度：Medium
 * 思路：双指针+哈希
*/

//@lccode=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();
        int left = 0,right = 9;
        StringBuilder builder = new StringBuilder();
        while (right < s.length()) {
            if (builder.length() == 0) {
                for (int i = left;i <= right;i++) {
                    builder.append(s.charAt(i));
                }
            } else {
                builder.deleteCharAt(0);
                builder.append(s.charAt(right));
            }
            right++;
            left++;
            if (!set.add(builder.toString())) {
                result.add(builder.toString());
            }
        }
        return new ArrayList<>(result);
    }
}
//@lccode=end

