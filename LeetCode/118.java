/**
 * 题目：给定一个非负整数numRows，生成杨辉三角的前numRows行。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> list = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        if(numRows <= 0) {
            return list;
        }
        array.add(1);
        list.add(array);
        for(int i = 1;i < numRows;i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for(int j = 1;j < array.size();j++) {
                tmp.add(array.get(j-1) + array.get(j));
            }
            tmp.add(1);
            list.add(tmp);
            array = tmp;
        }
        return list;
    }
}