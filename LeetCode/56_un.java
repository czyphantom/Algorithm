/**
 * 题目：给出一系列区间，返回合并有相交部分的区间。
 * 难度：Medium
 * 思路：把各个区间按照开始点排序，如果相等按结束点排序。然后得到排序后的数组，接着逐步归并区间加入到结果中。
 */

class Solution {
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1,Interval i2) {
            return i1.start - i2.start == 0 ? (i1.end-i2.end) : (i1.start-i2.start);
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals,new IntervalComparator());
        for (int i = 0;i < intervals.size();i++) {
            if (res.size() == 0 || res.get(res.size()-1).end < intervals.get(i).start) {
                res.add(intervals.get(i));
            } else {
                res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, intervals.get(i).end);
            }
        }
        return res;
    }
}