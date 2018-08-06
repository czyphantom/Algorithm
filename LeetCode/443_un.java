/**
 * 题目：给定一组字符，使用原地算法将其压缩。压缩后的长度必须始终小于或等于原数组长度。数组的每个元素应该是长度为1的
 * 字符（不是 int 整数类型）。在完成原地修改输入数组后，返回数组的新长度。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int compress(char[] chars) {        
        int start = 0;
        for(int end = 0, count = 0; end < chars.length; end++) {
            count++;
            if(end == chars.length-1 || chars[end] != chars[end + 1] ) {
                
                chars[start] = chars[end]; 
                start++;
                if(count != 1) {
                 
                    char[] arr = String.valueOf(count).toCharArray();
                    for(int i=0;i<arr.length;i++, start++)
                        chars[start] = arr[i];
                }
                count = 0;
            }
        }
        return start;
    }
}