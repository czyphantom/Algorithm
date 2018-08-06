/**
 * 题目：给定一种pattern(模式)和一个字符串str，判断str是否遵循相同的模式。
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应模式。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public boolean wordPattern(String pattern,String str) {
       String[] temp = str.split(" ");
        int length = pattern.length();
        if(temp.length != length)
            return false;
        Map<Character,String> map = new Hashtable<>();
        for(int i = 0;i < length;i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c) && !map.get(c).equals(temp[i]))
                return false;
            else if(!map.containsKey(c) && map.containsValue(temp[i]))
                return false;
            else
                map.put(c,temp[i]);
        }
        return  true;
    }
}