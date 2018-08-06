/**
 * 题目：给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 难度：Medium
 * 思路：水题
 */

class Solution {
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0)
           return "";
       
        String[] numArray = new String[num.length];
        for(int i = 0; i < num.length; i++) {
            numArray[i] = String.valueOf(num[i]);
        }
        Comparator<String> comp = new Comparator<String>(){
           @Override
           public int compare(String str1, String str2) {
               String s1 = str1 + str2;
               String s2 = str2 + str1;
               return s2.compareTo(s1);
           }
        };
        Arrays.sort(numArray, comp);
        if(numArray[0].charAt(0) == '0') {
            return "0";
        }  
        StringBuilder sb = new StringBuilder();
        for(String s: numArray) {
            sb.append(s);
        }
       return sb.toString();
    }
}