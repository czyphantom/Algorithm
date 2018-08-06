/**
 * 题目：给定两个整数，分别表示分数的分子numerator和分母denominator，以字符串形式返回小数。如果小数部分为循环小数，则将循环的部分括在括号内。
 * 难度：Medium
 * 思路：用map保存小数部分，如果有重复的就是循环小数
 */

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        res.append(num/den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        
        res.append(".");
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num/den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}