/**
 * 题目大意：给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
 * 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
 * 如果存在多种答案，你只需实现并返回其中任意一种.
 * 难度：Medium
 * 思路；规律题，构造差值分别为n-1,n-2...的数列。
 */

class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++)
            res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : (k % 2 != 0? l++ : r--);
        return res;
    }
}