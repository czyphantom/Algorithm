/**
 * 题目：给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。
 * 难度：Medium
 * 思路：使用中序遍历计算子树和，使用map存储出现次数。
 */

class Solution {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();;
    private int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        postOrder(root);
        List<Integer> res = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
                res.add(key);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private int postOrder(TreeNode root) {
        if (root == null)
            return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        int sum = left + right + root.val;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);

        maxCount = Math.max(maxCount, count);

        return sum;
    }
}