/**
 * 题目：给出集合 [1,2,3,…,n]，其所有元素共有n!种排列。给定n和k，返回第k个排列。
 * 难度：Medium
 * 思路：找规律
 */

class Solution {
    public String getPermutation(int n, int k) {
        k--;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }
        int round = n - 1;
        StringBuilder sb = new StringBuilder();
        while (round >= 0) {
            sb.append(list.remove(k/factorial));
            k %= factorial;
            if (round != 0) {
                factorial /= round;
            }
            round--;
        }
        return sb.toString();
    }
}