/**
* 题目：给出一个二叉搜索树的后序遍历，判断是否正确
* 思路：后序遍历序列应当满足左子树都小于根，右子树都大于根，递归判断
*/

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)
            return false;
        if(sequence.length == 1)
            return true;
        return verify(sequence,0,sequence.length-1);
    }
    
    private boolean verify(int[] sequence,int begin,int end) {
        if(begin >= end)
            return true;
        int i;
        for(i = end;i >= begin;i--) {
            if(sequence[i] < sequence[end])
                break;
        }
        int j;
        for(j = begin;j < i;j++) {
            if(sequence[j] > sequence[end])
                return false;
        }
        return verify(sequence,begin,i) && verify(sequence,i+1,end-1);
    }
}
