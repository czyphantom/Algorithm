/**
 * 题目：在一个m*n的二维字符串数组中输出二叉树，并遵守以下规则：
 * 行数m应当等于给定二叉树的高度。
 * 列数n应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。
 * 你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。
 * 然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。使用相同的规则输出子树。
 * 难度：Medium
 * 思路：深度优先搜索
 */

class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int size = (int)Math.pow(2, height)-1;
        List<List<String>> result=new ArrayList<List<String>>();
        for(int i = 0;i < height;i++) {
            List<String> list = new ArrayList<String>();
            for(int j = 0;j < size;j++) {
                list.add("");
            }
            result.add(list);
        }
        helper(result, root, 0, 0, size-1);
        return result;
    }
     
    public void helper(List<List<String>> result, TreeNode node, int level, int left, int right) {
        if(node == null) {
            return;
        }
        int index = (left+right)/2;
        result.get(level).set(index, node.val+"");
        helper(result, node.left, level+1, left, index-1);
        helper(result, node.right, level+1, index+1, right);
    }
     
    public int getHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return Math.max(1+getHeight(node.left), 1+getHeight(node.right));
    }
}