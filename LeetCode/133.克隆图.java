/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 * 题目：给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * 难度：Medium
 * 思路：bfs或者dfs
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
   private Map<Node, Node> map = new HashMap<>();
   
   public Node cloneGraph(Node node) {
       if (node == null) {
           return null;
       }   
       Node clone = new Node(node.val, new ArrayList<Node>());
       map.put(node, clone);
       for (Node neighbor : node.neighbors) {
           if (!map.containsKey(neighbor)) {
               Node newNeighbor = cloneGraph(neighbor);
               clone.neighbors.add(newNeighbor);
           } else {
               clone.neighbors.add(map.get(neighbor));
           }
       }
       
       return clone;
   }
}
// @lc code=end

