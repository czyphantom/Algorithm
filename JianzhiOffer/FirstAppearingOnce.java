/**
* 题目：求一个数据流第一个出现一次的字符
* 思路；用一个hashmap和队列保存
*/

public class Solution {
    LinkedList<Character> q = new LinkedList<>();
    HashMap<Character,Integer> map = new HashMap<>();
    
    public void Insert(char ch) {
        if(map.containsKey(ch)) {
            int count = map.get(ch);
            map.put(ch,++count);
        }else {
            map.put(ch,1);
            q.offer(ch);
        }
    }

    public char FirstAppearingOnce() {
        while(!q.isEmpty()) {
            if(map.get(q.peek()) >= 2)
                q.poll();
            else
                return q.peek();
        }
        return '#';
    }
}
