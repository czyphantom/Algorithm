/**
 * 并查集是一种用来管理元素分组情况的数据结构，并查集可以高效完成以下操作
 * 1.查询元素a和元素b是否为同一组。
 * 2.合并元素a和元素b所在的组。
 * 并查集使用树型结构实现，每个分组都是一棵树，不过，谁是谁的父节点和树的结构并不重要。
 * 并查集操作的复杂度是O(α(n))，α(n)是阿克曼函数的反函数，比O(log(n))还要快。 
 */

public class UnionFindSet {
    private static final int MAX = 100000;

    //记录父亲
    private int[] parent = new int[MAX];

    //记录树的高度，合并时如果两棵树的高度不同，将rank小的向rank大的连边
    private int[] rank = new int[MAX];

    //初始化n个元素，每个元素都是一个组
    public void init(int n) {
        for(int i = 0;i < n;i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    //查找元素x的根
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            //沿着树向根递归，同时使用路径压缩，将沿路的所有结点直接连向根，为了简单起见，不改变根的高度
            return parent[x] = find(parent[x]);
        }
    }

    public void unite(int x, int y) {
        //查找x和y的根
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        }
        //x的根的高度小于y，将x连到y上
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            //两个根高度相同，合并时需要对高度进行更新
            if (rank[x] == rank[y]) {
                rank[x]++;
            }
        }
    }

    public boolean isSame(int x, int y) {
        return find(x) == find(y);
    }
}