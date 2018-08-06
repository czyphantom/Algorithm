/**
 * 题目：给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的h指数。
 * h指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的h指数是指他（她）的（N篇论文中）至多有h篇论文分别被引用了至少h次。（其余的N-h篇论文每篇被引用次数不多于h次。）”
 * 难度：Medium
 * 思路：先排序。
 */

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        for(int i = 0; i < citations.length; i++){
            if(citations[i] <= citations.length - i) {
                res = citations[i];
            } else if (citations.length - i > res) {
                res = citations.length - i;
            }
        }
        return res;
    }
}