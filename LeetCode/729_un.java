/**
 * 题目：我的日程安排表 I
 * 难度：Medium
 * 思路：用TreeMap存储即时的区间
 */

class MyCalendar {
    TreeMap<Integer, Integer> map;
 
    public MyCalendar() {
        map = new TreeMap<>();
    }
 
    public boolean book(int start, int end) {
        Integer floorKey = map.floorKey(start);
        if (floorKey != null && map.get(floorKey) > start) {
            return false;
        }
        Integer ceilingKey = map.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) {
            return false;
        }
        map.put(start, end);
        return true;
    }
}