/**
 * 题目：给定一个32位正整数n，你需要找到最小的32位整数，其与n中存在的位数完全相同，并且其值大于n。如果不存在这样
 * 的32位整数，则返回-1。
 * 难度：Medium
 * 思路：参考31题下一个排列
 */

public class Solution {
    public int nextGreaterElement(int n) {
        String num = n + "";
        char[] charArray = num.toCharArray();
        if(num.length() < 2) return -1;
        int index = num.length() - 2;
        for(; index >= 0; index --){
            if(num.charAt(index) < num.charAt(index + 1)) break;
        }
        if(index == -1) 
            return -1;
        int swapIndex = index + 1;
        for(;swapIndex < num.length();swapIndex ++){
            if(num.charAt(swapIndex) <= num.charAt(index)) 
                break;
        }
        swapIndex --;
        char temp = charArray[index];
        charArray[index] = charArray[swapIndex];
        charArray[swapIndex] = temp;
        Arrays.sort(charArray,index + 1, charArray.length);
        int result = 0;
        for(char ch : charArray) {
            result = result * 10 + (ch - '0');
            if(result > Integer.MAX_VALUE / 10) 
                return -1;
        }
        
        return result;
    }
}