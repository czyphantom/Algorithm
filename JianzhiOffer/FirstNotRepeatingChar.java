/**
* 题目：找出字符串中第一个出现次数为1次的位置
* 思路：用HashMap保存
*/

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0;i < str.length();i++) {
            if(map.containsKey(str.charAt(i))) {
                int count = map.get(str.charAt(i));
                map.put(str.charAt(i),++count);
            } else {
                map.put(str.charAt(i),1);
            }
        }
        
        int res = -1;
        for(int i = 0;i < str.length();i++) {
            if(map.get(str.charAt(i)) == 1) {
                res = i;
                break;
            }
        }
        return res;
    }
}
