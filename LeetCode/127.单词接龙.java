/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 * 题目：字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * 每一对相邻的单词只差一个字母。
 * 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * 难度：Hard
 * 思路：
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<String>(wordList); 
        Map<String, List<String>> nodeNeighbors = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        List<String> solution = new ArrayList<String>();
        dict.add(beginWord);         
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);   
        return distance.get(endWord) == null ? 0 : distance.get(endWord)+1;              
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
}
// @lc code=end

