/**
* 题目：求一个数组的逆序对
* 思路；利用归并排序的思想，在归并时同时计算逆序对数
*/

public class Solution {
    private int count = 0;
 
    public int InversePairs(int[] array) {
        if (array != null)
            mergeSortUp2Down(array, 0, array.length - 1);
        return count;
    }
 
    public void mergeSortUp2Down(int[] a, int start, int end) {
        if (start >= end)
            return;
        int mid = start+(end-start)/2;
 
        mergeSortUp2Down(a, start, mid);
        mergeSortUp2Down(a, mid + 1, end);
 
        merge(a, start, mid, end);
    }
 
    public void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
 
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j])
                tmp[k++] = a[i++];
            else {
                tmp[k++] = a[j++];
                count += mid - i + 1;
                count %= 1000000007;
            }
        }
 
        while (i <= mid)
            tmp[k++] = a[i++];
        while (j <= end)
            tmp[k++] = a[j++];
        for (k = 0; k < tmp.length; k++)
            a[start + k] = tmp[k];
    }
}
