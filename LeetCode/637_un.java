/**
 * 题目：给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 难度：Easy
 * 思路：BFS
 */

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
            long sum = 0;
            int size = queue.size();
            for(int i = 0;i < size;i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add((double)sum/size);
        }
        return res; 
    }
}