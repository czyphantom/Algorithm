/**
 * 题目：给定两个表示复数的字符串。返回表示它们乘积的字符串。
 * 难度：Medium
 * 思路：水题
 */

class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] numa = a.split("\\+");
        String[] numb = b.split("\\+");
        int aReal = Integer.parseInt(numa[0]);
        int aComplex = Integer.parseInt(numa[1].substring(0,numa[1].length()-1));
        int bReal = Integer.parseInt(numb[0]);
        int bComplex = Integer.parseInt(numb[1].substring(0,numb[1].length()-1));
        int resReal = aReal*bReal-aComplex*bComplex;
        int resComplex = aReal*bComplex+aComplex*bReal;
        StringBuilder builder = new StringBuilder();
        builder.append(Integer.toString(resReal)).append("+").append(Integer.toString(resComplex)).append("i");
        return builder.toString();
    }
}