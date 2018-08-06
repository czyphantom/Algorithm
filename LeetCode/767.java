/**
 * 题目：给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。若可行，输出任意可行的结果。若不可行，
 * 返回空字符串。
 * 难度：Medium
 * 思路：保存字符的频数，每次放一个最大的在放一个第二大的，频数保存到堆里。
 */

class Solution {
    public String reorganizeString(String S) {
        int[] counts = new int[26];
        for (int i = 0; i < S.length(); i++) {
            counts[S.charAt(i)-'a'] ++;
        }
 
        PriorityQueue<NewChar> pq = new PriorityQueue<>(new Comparator<NewChar>() {
            @Override
            public int compare(NewChar o1, NewChar o2) {
                return o2.count-o1.count;
            }
        });
 
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && counts[i] <= (S.length()+1)/2){
                pq.add(new NewChar(counts[i], (char)(i+'a')));
            }else if (counts[i] > (S.length()+1)/2){
                return "";
            }
        }
 
        String str = "";
 
        while (pq.size() > 1) {
            NewChar c1 = pq.poll();
            NewChar c2 = pq.poll();
            if (str.length()==0 || c1.letter != str.charAt(str.length()-1)){
                str += c1.letter;
                str += c2.letter;
            }
            if (--c1.count > 0) {
                pq.add(c1);
            }
            if (--c2.count > 0) {
                pq.add(c2);
            }
        }
 
        if (pq.size()>0) {
            str += pq.poll().letter;
        }
        return str;
    }
    
    static class NewChar{
        int count;
        char letter;
        NewChar(int count, char letter){
            this.count = count;
            this.letter = letter;
        }
    }
    
}