/**
 * 题目：给定一个24小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
 * 难度：Medium
 * 思路：先排序，注意最小值也可能是第一个和最后一个的差值。
 */

class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String a,String b) {
                String[] timea = a.split(":");
                String[] timeb = b.split(":");
                int aHour = Integer.parseInt(timea[0]);
                int aMinute = Integer.parseInt(timea[1]);
                int bHour = Integer.parseInt(timeb[0]);
                int bMinute = Integer.parseInt(timeb[1]);

                if(aHour == 0)
                    aHour = 24;
                if(bHour == 0)
                    bHour = 24;

                return aHour-bHour==0 ? aMinute-bMinute : aHour-bHour;
            }
        });
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < timePoints.size()-1;i++) {
            min = Math.min(min,getDifference(timePoints.get(i), timePoints.get(i+1)));
        }
        return Math.min(min,getDifference(timePoints.get(0), timePoints.get(timePoints.size()-1)));
    }

    private int getDifference(String a,String b) {
        String[] timea = a.split(":");
        String[] timeb = b.split(":");
        int aHour = Integer.parseInt(timea[0]);
        int aMinute = Integer.parseInt(timea[1]);
        int bHour = Integer.parseInt(timeb[0]);
        int bMinute = Integer.parseInt(timeb[1]);

        if(aHour == 0)
            aHour = 24;
        if(bHour == 0)
            bHour = 24;

        return Math.min(bMinute-aMinute+(bHour-aHour)*60,1440-(bMinute-aMinute+(bHour-aHour)*60));
    }
}