/**
* 题目：根据一棵树的前序遍历与中序遍历构造二叉树。
* 难度：Medium
* 思路：略
*/

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        
        int[] r = new int[]{-1};
        return buildTree(preorder, inorder, r, 0, inorder.length);
    }
    
    TreeNode buildTree(int[] preorder, int[] inorder, int[] rIdx, int iS, int iE) {
        if(iS > iE || rIdx[0]+1 >= preorder.length)
            return null;
        
        TreeNode root = new TreeNode(preorder[++rIdx[0]]);
        int ri = findIdx(inorder, root.val);
        
        //give left of root node for left sub-tree
        root.left = buildTree(preorder, inorder, rIdx, iS, ri-1);

        //give right of root nodes for right sub-tree
        root.right = buildTree(preorder, inorder, rIdx, ri+1, iE);
        
        return root;
    }
    
		//find the index of the root node
    int findIdx(int[] nodes, int r) {
        for(int i=0; i<nodes.length; i++)
            if(r == nodes[i])
                return i;
        
        return -1;
    }
