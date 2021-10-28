/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 * 题目：给你一个整数n，请你生成并返回所有由n个节点组成且节点值从1到n互不相同的不同二叉搜索树 。
 * 可以按任意顺序返回答案。
 * 难度：Medium
 * 思路: 回溯或者动态规划
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
       List<TreeNode>[] res = new List[n+1];
		res[0] = new ArrayList<>();
		if(n == 0) {
			return res[0];
		}
		res[0].add(null);
		for(int i = 1;i <= n;i++) {
			res[i] = new ArrayList<>();
			for(int j = 1;j <= i;j++) {
				for (TreeNode left : res[j-1]) {
					for(TreeNode right : res[i-j]) {
						TreeNode root = new TreeNode(j);				
						root.left = left;									
						root.right = Clone(right,j);
						res[i].add(root);
					}
				}
			}
		}
		return res[n];
    }
    public TreeNode Clone(TreeNode root, int index){
		if(root == null) {
			return null;
		}
		TreeNode res = new TreeNode(root.val+index);
		res.left = Clone(root.left, index);
		res.right = Clone(root.right, index);
		return res;		
	}

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
// @lc code=end

