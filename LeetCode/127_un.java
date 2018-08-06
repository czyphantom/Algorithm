/**
 * 题目：给定两个单词（beginWord和endWord）和一个字典，找到从beginWord到endWord的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 难度：Medium
 * 思路：BFS。
 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<String>(wordList); 
        Map<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        List<String> solution = new ArrayList<String>();
        dict.add(beginWord);         
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);   
        return distance.get(endWord) == null ? 0 : distance.get(endWord)+1;              
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
}