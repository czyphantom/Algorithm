/**
 * 题目：报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。给定一个正整数n，输出报数序列的第n项。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
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