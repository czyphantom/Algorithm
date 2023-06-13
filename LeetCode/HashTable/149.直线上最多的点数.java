/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 * 题目：给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * 难度：Hard
 * 思路：计算任意两个点的斜率保存到map里，为了防止精度计算不精确，使用Map保存斜率的分母和分子。
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0 || points[0].length != 2) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
        int result = 0;
        for (int i = 0;i < points.length;i++) {
            map.clear();
            int overlap = 0,max = 0;
            for (int j = i+1;j < points.length;j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x,y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)){
                        map.get(x).put(y, map.get(x).get(y)+1);
                    }else{
                        map.get(x).put(y, 1);
                    }
                }else{
                    Map<Integer,Integer> m = new HashMap<Integer,Integer>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max+overlap+1);
        }
        return result;
    }

    private int generateGCD(int a,int b) {
        if (b == 0) {
            return a;
        }
        else {
            return generateGCD(b,a%b);
        }
    }
}
// @lc code=end

