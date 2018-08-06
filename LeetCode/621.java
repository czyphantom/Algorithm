/**
 * 题目：给定一个用字符数组表示的CPU需要执行的任务列表。其中包含使用大写的A - Z字母表示的26种不同种类的任
 * 务。任务可以以任意顺序执行，并且每个任务都可以在1个单位时间内执行完。CPU在任何一个单位时间内都可以执行一个任务
 * ，或者在待命状态。然而，两个相同种类的任务之间必须有长度为n的冷却时间，因此至少有连续n个单位时间内CPU在执
 * 行不同的任务，或者在待命状态。你需要计算完成所有任务所需要的最短时间。
 * 难度：Medium
 * 思路：找到词频倒数第二个的即可
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0,maxFreqCount = 0;
        for(int i = 0;i < tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        for(int i = 0;i < 26;i++){
            if(freq[i] > maxFreq){
                maxFreq = freq[i];
                maxFreqCount = 1;
            } else if(freq[i] == maxFreq){
                maxFreqCount++;
            }
        }
        return Math.max(tasks.length,(maxFreq-1)*(n+1)+maxFreqCount);
    }
}