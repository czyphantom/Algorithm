/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 * 题目：给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 难度：Medium
 * 思路：根据前一个计算下一个字符串
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String res = "1";
        for (int i = 2;i <= n;i++) {
            res = nextString(res);
        }
        return res;
    }

    private String nextString(String s) {
        StringBuilder builder = new StringBuilder();
        int count = 1, i = 0;
        while (i < s.length()) {
            int j = i+1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
                count++;
            }
            builder.append(count);
            builder.append(s.charAt(i));
            count = 1;
            i = j;
        }
        return builder.toString();
    }

    public String countAndSay(int n) {
	    StringBuilder curr = new StringBuilder("1");
	    StringBuilder prev;
	    int count;
	    char say;
	    for (int i = 1;i < n;i++){
	        prev = curr;
	 	    curr = new StringBuilder();       
	 	    count = 1;
	 	    say = prev.charAt(0);
	 	    for (int j = 1,len = prev.length();j < len;j++){
	 	        if (prev.charAt(j) != say) {
	 	        	curr.append(count).append(say);
	 	        	count = 1;
	 	        	say = prev.charAt(j);
	 	        }
	 	        else {
					count++;
				}
	 	    }
	 	    curr.append(count).append(say);
	    }	       	        
	    return curr.toString();  
    }
}
// @lc code=end

