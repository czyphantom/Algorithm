/**
 * 题目：我的日程安排表 II
 * 难度：Medium
 * 思路：用TreeMap保存位置和出现次数
 */

class MyCalendarTwo {
    TreeMap<Integer,Integer> treeMap;
    public MyCalendarTwo() {
        treeMap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        int a = treeMap.getOrDefault(start,0);
        int b = treeMap.getOrDefault(end,0);
        treeMap.put(start,a+1);
        treeMap.put(end,b-1);
        int count = 0;

        for (Integer val : treeMap.values()) { 
            count += val;
            if (count > 2) {
                if(a == 0) {
                    treeMap.remove(start);
                } else {
                     treeMap.put(start,a);
                }
                if (b == 0) {
                    treeMap.remove(end);
                } else {
                    treeMap.put(end,b);
                }
                return false;
            }
        }
        return true;
    }
}
