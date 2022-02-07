/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 * 题目：按字典wordList完成从单词beginWord到单词endWord转化，一个表示此过程的转换序列是形式上像beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典wordList中的单词。注意，beginWord不必是字典wordList中的单词。
 * sk == endWord
 * 给你两个单词beginWord和endWord，以及一个字典wordList。请你找出并返回所有从beginWord到endWord的最短转换序列，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表[beginWord, s1, s2, ..., sk]的形式返回。
 * 难度：Hard
 * 思路：
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<String>(wordList);
        List<List<String>> res = new ArrayList<List<String>>();   
        Map<String, List<String>> nodeNeighbors = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        List<String> solution = new ArrayList<String>();
        dict.add(start);          
        bfs(start, end, dict, nodeNeighbors, distance);                 
        dfs(start, end, dict, nodeNeighbors, distance, solution, res);   
        return res;
     }
     
     private void bfs(String start, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
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
// @lc code=end

