/**
 * 题目：给定一个非负索引k，其中k≤33，返回杨辉三角的第k行。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<Integer>();  
        for (int i = 0;i < rowIndex+1;i++) {  
            list.add(i, 1);  
            for(int j = i-1;j > 0;j--) {  
                list.set(j, list.get(j) + list.get(j-1));  
            }  
        }  
        return list;  
    }
}