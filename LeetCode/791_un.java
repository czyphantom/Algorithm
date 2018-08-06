/**
 * 题目：字符串S和T只包含小写字符。在S中，所有字符只会出现一次。S已经根据某种规则进行了排序。
 * 我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。返回任意一种符合条件的字符串T。
 * 难度：Medium
 * 思路：水题
 */

class Solution {
    public String customSortString(String S, String T) {
        char[] sc = S.toCharArray();
        char[] tc = T.toCharArray();
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for (char c : tc) {
            freq[c-'a']++;
        }
        Set<Character> aset = new HashSet<>();
        for (char c : sc) {
            for (int i = 0;i < freq[c-'a'];i++) {
                sb.append(c);
            }
            aset.add(c);
        }
        for (int i = 0;i < freq.length;i++) {
            if(!aset.contains((char)('a'+i))) {
                for(int j = 0;j < freq[i];j++) {
                    sb.append((char)('a'+i));
                }
            }
        }
        return sb.toString();
    }
}