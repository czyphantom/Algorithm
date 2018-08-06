/**
 * 题目：给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不
 * 超过10000。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int l = str.length();
        for(int i = l/2;i >= 1;i--) {
            if(l%i == 0) {
                int m = l/i;
                String subS = str.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j < m;j++) {
                    sb.append(subS);
                }
                if(sb.toString().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}