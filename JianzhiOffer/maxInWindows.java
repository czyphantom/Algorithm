/**
* 题目：求一个数组的各个滑动窗口的最大值
* 思路：使用双端队列保存最大值，窗口滑动时，比较值是否过期。
*/

public class Solution {
   public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0) 
            return res;
        int begin; 
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            begin = i - size + 1;
            if(q.isEmpty())
                q.add(i);
            if(begin > q.peekFirst())
                q.pollFirst();
         
            while((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);  
            if(begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }
}