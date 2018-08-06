/**
 * 题目：给定一个N叉树，返回其节点值的后序遍历。 
 * 难度：Easy 
 * 思路：水题
 */

// 递归
class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null)
            return list;

        for (Node node : root.children)
            postorder(node);

        list.add(root.val);

        return list;
    }
}

// 迭代
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for (Node node : root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }
}