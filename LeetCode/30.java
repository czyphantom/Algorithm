/**
 * 题目：给定一个字符串s和一些长度相同的单词words。找出s中恰好可以由words中所有单词串联形成的子串的起始位置。
 * 注意子串要与words中的单词完全匹配，中间不能有其他字符，但不需要考虑words中单词串联的顺序。
 * 难度：Hard
 * 思路：用两个map，一个保存字典，一个保存见过的子串
 */

class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) {
            return res;
        }
        int len = L[0].length();
        
        Map<String, Integer> map = new HashMap<String, Integer>(); 
        for (String w : L) {
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        }
        
        for (int i = 0; i <= S.length() - len * L.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++) { 
                String str = S.substring(i + j*len, i + j*len + len); 
                if (copy.containsKey(str)) { 
                    int count = copy.get(str);
                    if (count == 1) {
                        copy.remove(str);
                    } else {
                        copy.put(str, count - 1);
                    }
                    if (copy.isEmpty()) { 
                        res.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }
}