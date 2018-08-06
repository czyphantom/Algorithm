/**
 * 题目：给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。字母和数字的关系就是手机上的。
 * 难度：Medium
 * 思路：深度优先搜索
*/

class Solution {
    private String[] table = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        solve(list,digits,"",0);
        return list;
    }
    
    private void solve(List<String> list, String digits, String curr, int index) {
        if (index == digits.length()) {
            if(curr.length() != 0) 
                list.add(curr);
            return;
        }
        String temp = table[digits.charAt(index) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            String next = curr + temp.charAt(i);
            solve(list,digits,next,index+1);
        }
    }
}