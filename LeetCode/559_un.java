/**
 * 题目：给定一个N叉树，找到其最大深度。
 * 难度：Easy 
 * 思路：DFS
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
    private int max = 0;

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        maxDepth(root, 1);
        return max;
    }

    public void maxDepth(Node node, int depth) {
        if (node == null)
            return;
        max = Math.max(max, depth);
        for (Node child : node.children) {
            maxDepth(child, depth + 1);
        }
    }
}