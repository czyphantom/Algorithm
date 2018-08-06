/**
 * 题目：给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的h指数。
 * h指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的h指数是指他（她）的 （N篇论文中）至多有h篇论文分别被引用了至少h次。（其余的N-h篇论文每篇被引用次数不多于h次。）"
 * 难度：Medium
 * 思路：二分
 */

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int begin = 0;
        int end = citations.length-1;
        int index = end;
        while (begin < end) {
            int mid = (begin+end)/2;
            if(citations[mid] == index-mid+1) {
                return citations[mid];
            }
            else if(citations[mid] < index-mid+1) {
                begin = mid+1;
            } else {
                end = mid;
            }
        }
        if (citations[begin] < index-begin+1) {
            return 0;
        }
        else {
            return index-begin+1;
        }
    }
}