/**
* 题目：求出一个数组最小的k个数。
* 思路：使用堆
*/

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(k > input.length || k == 0)
            return res;
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int i = 0;i < input.length;i++) {
            p.add(input[i]);
        }
        for(int j = 0;j < k;j++) {
            res.add(p.poll());
        }
        return res;
    }
}
