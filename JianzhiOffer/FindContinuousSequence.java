/**
* 题目：找出连续的数字和为给定数的序列
* 思路：起始点和结束点按照各种情况往后挪
*/

public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
       ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
        if(sum <= 1)
            return res;
        int begin = 1,end = 2;
        int cursum = 3;
        while(begin <= sum/2) {
            if(cursum < sum) {
                end++;
                cursum += end;
            }
            else if(cursum > sum) {
                cursum -= begin;
                begin++;
            }
            else {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                for(int i = begin;i <= end;i++) {
                    tmp.add(i);
                }
                res.add(tmp);
                cursum -= begin;
                begin++;
                end++;
                cursum += end;
            }
        }
        
        return res;
    }
}