/**
 * 题目：验证前序遍历二叉搜索树
 * 难度：Medium
 * 思路：前序遍历序列应当满足左子树都小于根，右子树都大于根，递归判断。
 */

class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int begin, int end) {
        if (begin >= end) {
            return true;
        }
        int i;
        for (i = begin; i <= end; i++) {
            if (sequence[i] > sequence[begin]) {
                break;
            }
        }
        int j;
        for (j = end; j > i; j--) {
            if (sequence[j] < sequence[begin]) {
                return false;
            }
        }
        return verify(sequence, begin, i) && verify(sequence, i + 1, end - 1);
    }
}