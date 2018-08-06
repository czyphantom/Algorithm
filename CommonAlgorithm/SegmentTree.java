/**
 * 线段树擅长处理区间，线段树是一棵完美二叉树，树上每个节点都维护一个区间。根维护整个区间，每个节点维护父节点的区间二等分后的其中一个子区间，对区间的操作复杂度O(logn)
 */

public class SegmentTree {
    private static final int MAX = 1<<16;

    private int n;
    private int[] data = new int[2*MAX-1];

    public void init(int num) {
        n = 1;
        //简单起见，将元素扩大到2的幂次，保证是一棵完美二叉树
        while (n < num) {
            n *= 2;
        }
        for (int i = 0;i < 2*n-i;i++) {
            data[i] = Integer.MAX_VALUE;
        }
    }

    /**
     * 将第k个元素更新为a
     * @param k
     * @param a
     */
    public void update(int k, int a) {
        k += n-1;
        //更新叶子节点
        data[k] = n - 1;
        //向上更新
        while (k > 0) {
            k = (k-1)/2;
            data[k] = Math.min(data[k*2+1], data[k*2+2]);
        }
    }

    /**
     * 求[a,b)的最小值，k是结点编号，l,r表示这个结点对应的是[l,r）区间
     * 外部调用时使用query(a, b, 0, 0, n)
     * @param a
     * @param b
     * @param k
     * @param l
     * @param r
     * @return
     */
    public int query(int a, int b, int k, int l, int r) {
        //区间不相交，返回最大值
        if (r <= a || b <= l) {
            return Integer.MAX_VALUE;
        }
        //[a,b)包含[l,r),返回当前结点的值
        if (a <= l && r <= b) {
            return data[k];
        } else {
            //否则返回两个儿子中的较小值
            int vl = query(a, b, k*2+1, l, (l+r)/2);
            int vr = query(a, b, k*2+2, (l+r)/2, r);
            return Math.min(vl, vr); 
        }
    }
}