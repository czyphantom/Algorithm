/**
 * 题目：数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，并将这些块分别进行排序。
 * 之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * 难度：Medium
 * 思路：只要当前最大值恰好和当前遍历到的元素个数相等，则之前的为一个块。
 */

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int count = 0;
        for(int i = 0;i < arr.length;i++) {
            max = Math.max(max,arr[i]);
            if(max == i) {
                count++;
            }
        }
        return count;
    }
}