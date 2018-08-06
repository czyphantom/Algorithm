/**
 * 图算法
 */
public class GraphAlgorithm {
    //邻接表表示图
    private Vertex[] vertex = new Vertex[10000];

    //cost[u][v]表示边(u,v)权值
    private int[][] cost = new int[10000][10000];

    //某个顶点v出发的最短距离
    private int[] distance = new int[10000];

    //已经使用过的顶点
    private boolean[] used = new boolean[10000];

    /**
    * 深度优先搜索从某个状态开始，不断转移状态直到无法转移，然后回退到前一步的状态，继续转移到其他状态，如此重复直到找到最终的解。
    */
    public void dfs() {
        for (int i = 0;i < vertex.length;i++) {
            if (!vertex[i].visited) {
                dfs(vertex[i]);
            }
        }
    }

    private void dfs(Vertex v) {
        v.visited = true;
        for (int i = 0;i < v.edge.size();i++) {
            //没有访问过的结点递归访问
            if (!v.edge.get(i).visited) {
                dfs(v.edge.get(i));
            }
        }
    }

    /**
    * 广度优先搜索总是先搜索距离初始状态最近的状态，需要使用到队列进行辅助。
    * 广度优先搜索可以用来求解最短路径、最少操作之类的问题
    */
    public void bfs() {
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(vertex[0]);
        while (!queue.isEmpty()) {
            Vertex p = queue.poll();
            p.visited = true;
            for (int i = 0;i < p.edge.size();i++) {
                if (p.edge.get(i).visited = false) {
                    queue.offer(p.edge.get(i));
                }
            }
        }
    }

    /**
     * Dijkstra算法用于求解单源最短路径问题，每次从未使用过的顶点中选取一个距离最小的顶点，接着根据distance[i] = min(distanc[i], distance[chooose][i])更新到每个顶点的最小值
     * @param v 某个出发的顶点
     */
    public void dijkstra(int v) {
        distance[v] = 0;
        while (true) {
            int temp = -1;
            //从未使用的顶点选取一个距离最小的顶点
            for (int i = 0;i < 10000;i++) {
                if (!uses[i] && (temp == -1 || distance[i] < distanc[temp])) {
                    temp = i;
                }
            }
            if (temp == -1) {
                break;
            }
            used[temp] = true;
            //更新到每个顶点的最小值
            for (int i = 0;i < 10000;i++) {
                distance[i] = Math.min(distance[i], distance[temp] + cost[temp][i]);
            }
        }
    }
}

class Vertex {
    public int num;
    public List<Vertex> edge;
    public boolean visited;
}