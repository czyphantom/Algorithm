/**
 * 题目：给定一个二叉树，返回其按层次遍历的节点值。（即逐层地，从左到右访问所有节点）。
 * 难度：Medium
 * 思路：用队列
 */

class Solution {
    public List <List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue =new LinkedList<>();
        if(root == null){
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i < size;i++){
                TreeNode node = queue.remove();
                temp.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}