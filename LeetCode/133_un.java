/**
 * 题目：给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值val（Int）和其邻居的列表（list[Node]）。
 * 难度：Medium
 * 思路：dfs或者bfs均可。
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