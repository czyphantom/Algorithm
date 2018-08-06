/**
* 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
* 思路: 水题
*/

import java.util.*;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0)
            return "";
        String[] str = new String[numbers.length];
        for(int i = 0;i < numbers.length;i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>() {
            public int compare(String s1,String s2) {
                return (s1+s2).compareTo(s2+s1);
            }
        });
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i < str.length;i++){
            builder.append(str[i]);
        }
        return builder.toString();
    }
}
