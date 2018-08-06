/**
 * 题目：给定两个单词（beginWord 和 endWord）和一个字典wordList，找出所有从beginWord到endWord的最短转换序列。
 * 转换需遵循如下规则：每次转换只能改变一个字母。转换过程中的中间单词必须是字典中的单词。
 * 难度：Hard
 * 思路：BFS求最短距离，DFS求路径
 */

class Solution {
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<String>(wordList);
        List<List<String>> res = new ArrayList<List<String>>();   
        Map<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        List<String> solution = new ArrayList<String>();
        dict.add(start);          
        bfs(start, end, dict, nodeNeighbors, distance);                 
        dfs(start, end, dict, nodeNeighbors, distance, solution, res);   
        return res;
     }
     
     private void bfs(String start, String end, Set<String> dict, Map<String, ArrayList<String>> nodeNeighbors, Map<String, Integer> distance) {
       for (String str : dict) {
           nodeNeighbors.put(str, new ArrayList<String>());
       }
       Queue<String> queue = new LinkedList<String>();
       queue.offer(start);
       distance.put(start, 0);
       while (!queue.isEmpty()) {
           int count = queue.size();
           boolean foundEnd = false;
           for (int i = 0; i < count; i++) {
               String cur = queue.poll();
               int curDistance = distance.get(cur);                
               List<String> neighbors = getNeighbors(cur, dict);
               for (String neighbor : neighbors) {
                   nodeNeighbors.get(cur).add(neighbor);
                   if (!distance.containsKey(neighbor)) {
                       distance.put(neighbor, curDistance + 1);
                       if (end.equals(neighbor)) {
                           foundEnd = true;
                       } else {
                           queue.offer(neighbor);
                       }
                           
                    }
                }
            }
            if (foundEnd) {
                break;
            }
        }
    }
     
    private List<String> getNeighbors(String node, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();
        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
               if (chs[i] == ch) {
                   continue;
               }
               char old_ch = chs[i];
               chs[i] = ch;
               if (dict.contains(String.valueOf(chs))) {
                   res.add(String.valueOf(chs));
               }
               chs[i] = old_ch;
           }
     
       }
       return res;
    }
    
    private void dfs(String cur, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance, List<String> solution, List<List<String>> res) {
         solution.add(cur);
         if (end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
         } else {
            for (String next : nodeNeighbors.get(cur)) {            
                 if (distance.get(next) == distance.get(cur) + 1) {
                      dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                 }
             }
         }           
        solution.remove(solution.size() - 1);
    }
}