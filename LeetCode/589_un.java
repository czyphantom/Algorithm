/**
 * 题目：给定一个N叉树，返回其节点值的前序遍历。 
 * 难度：Easy 
 * 思路：水题
 */

// 递归解法
class Solution {
    public List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null)
            return list;

        list.add(root.val);
        for (Node node : root.children)
            preorder(node);

        return list;
    }
}

// 迭代解法
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }

        return list;
    }
}