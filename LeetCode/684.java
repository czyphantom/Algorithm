/**
 * 题目：在本问题中, 树指的是一个连通且无环的无向图。
 * 输入一个图，该图由一个有着N个节点(节点值不重复1, 2, ..., N)的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足u < v，表示连接顶点u和v的无向图的边。
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边[u, v]应满足相同的格式u < v。
 * 难度：Medium
 * 思路：并查集
 */

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges){
            int f = edge[0], t = edge[1];
            if (find(parent, f) == find(parent, t)) {
                return edge;
            }
            else {
                parent[find(parent, f)] = find(parent, t);
            }
        }
        return new int[2];
    }
    
    private int find(int[] parent, int f) {
        if (f != parent[f]) {
          parent[f] = find(parent, parent[f]);  
        }
        return parent[f];
    }
}