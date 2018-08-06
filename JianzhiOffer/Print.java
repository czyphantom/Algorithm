/**
* 题目：层序打印二叉树
* 思路：注意层次。
*/

public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
        if(pRoot == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while(!queue.isEmpty()) {
            int low = 0,count = queue.size();
            ArrayList<Integer> layer = new ArrayList<>();
            while(low++ < count) {
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);
                layer.add(queue.poll().val);
            }
            res.add(layer);
        }
        return res;
    }
}