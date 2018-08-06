/**
 * 题目：在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 * 难度：Medium
 * 思路：水题，注意不重叠的情况
 */

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);
        int common = solve(A, C, E, G)*solve(B, D, F, H);
        return area1 + area2 - common;
    }

    private int solve(int a, int b, int c, int d) {
        if (a > d || c > b) {
            return 0;
        }
        int max = Math.max(Math.max(Math.max(a, b), c), d);
        int min = Math.min(Math.min(Math.min(a, b), c), d);
        return b - a + d - c - (max-min);
    }
}