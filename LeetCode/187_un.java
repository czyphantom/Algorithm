/**
 * 题目：所有DNA由一系列缩写为A，C，G和T的核苷酸组成，例如：“ACGAATTCCG”。在研究DNA时，识别DNA中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来查找DNA分子中所有出现超过一次的10个字母长的序列（子串）。
 * 难度：Medium
 * 思路：用Set存储10个字母长的子序列或者
 */

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten)) {
                repeated.add(ten);
            }
        }
        return new ArrayList<String>(repeated);
    }
}