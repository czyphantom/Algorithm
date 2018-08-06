/**
 * 题目：给定两个字符串s和t，判断它们是否是同构的。如果s中的字符可以被替换得到t，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public boolean isIsomorphic(String s,String t) {
        Map<String, String> map = new HashMap<>();
        String[] sList = s.split("");
        String[] tList = t.split("");
        if(s.length() != t.length())
            return false;
        for (int i = 0; i < sList.length; i++) {
            if (!map.containsKey(sList[i])) {
                map.put(sList[i], tList[i]);
            } else {
                if (!map.get(sList[i]).equals(tList[i])) return false;
            }
        }
        return map.values().size() == new HashSet<>(map.values()).size();
    }
 } 