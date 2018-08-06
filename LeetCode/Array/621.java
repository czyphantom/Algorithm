import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目大意：给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任
 * 务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务
 * ，或者在待命状态。然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执
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
            }else if(freq[i] == maxFreq){
                maxFreqCount++;
            }
        }
        return Math.max(tasks.length,(maxFreq-1)*(n+1)+maxFreqCount);
    }
}