/**
 * 题目：给定一个N叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
 * 难度：Easy 
 * 思路：水题
 */

/*
 * // Definition for a Node. class Node { public int val; public List<Node>
 * children;
 * 
 * public Node() {}
 * 
 * public Node(int _val,List<Node> _children) { val = _val; children =
 * _children; } };
 */
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                for (Node n : node.children) {
                    queue.offer(n);
                }
            }
            res.add(list);
        }
        return res;
    }
}