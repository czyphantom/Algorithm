/**
 * 题目：给定一个整数n，生成所有由1 ... n为节点所组成的二叉搜索树。
 * 难度：Medium
 * 思路：动态规划
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
}