/**
 * 题目：给定两个大小为m和n的有序数组nums1和nums2。请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为O(log(m + n))。
 * 难度：Hard
 * 思路：两种思路如下所示。
 */

 //O(log(min(m,n)))解法
 //主要思想是将两个数组分为左右两部分，两部分长度相同，且左数组的最大值小于等于右数组的最小值，此时中间值即为(max(左数组)+min(右数组))/2
class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int n = A.length;
        int m = B.length;
        if (n > m) {
            return findMedianSortedArrays(B, A);
        }
        int k = (n + m - 1) / 2;
        int l = 0, r = Math.min(k, n);
        //以下循环直到左数组的最大值小于等于右数组的最小值
        while (l < r) {
            int midA = (l + r) / 2;
            //保证左数组的长度等于右数组
            int midB = k - midA;
            if (A[midA] < B[midB]) {
                l = midA + 1;
            }
            else {
                r = midA;
            }
        }
        //中间数必定是A[l-1], A[l], B[k-l], B[k-l+1]中的一个
        //n+m是奇数, 中间数就是A[l-1]和B[k-l]大的一个
        int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
        if (((n + m) & 1) == 1) {
            return (double) a;
        }
        //n+m是偶数的话，中间数就是(max(A[l-1], B[k-l]) + min(A[l], B[k-l+1])/2.0
        int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
        return (a + b) / 2.0;
    }
}

//O(log(m+n))解法
//思路是在两个数组中找第(m+n)/2和(m+n)/2+1位置的数
class Solution2 { 
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, sumLen = len1+len2;
        if (sumLen % 2 != 0) {
            return findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen/2+1);
        } else {
            return (findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen/2)+findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen/2 + 1)) / 2.0;
        }
    }

    private int findKthSmallest(int[] a, int m, int begin1, int[] b, int n, int begin2, int k) {
        if (m > n) {
            return findKthSmallest(b, n, begin2, a, m, begin1, k);
        }
        if (m == 0) {
            return b[begin2 + k - 1];
        }
        if (k == 1) {
            return Integer.min(a[begin1], b[begin2]);
        }
        int partA = Integer.min(k/2, m), partB = k - partA;
        if (a[begin1 + partA - 1] == b[begin2 + partB - 1]) {
            return a[begin1 + partA - 1];
        }
        else if (a[begin1 + partA - 1] > b[begin2 + partB - 1]) {
            return findKthSmallest(a, m, begin1, b, n - partB, begin2 + partB, k - partB);
        }
        else {
            return findKthSmallest(a, m - partA, begin1 + partA, b, n, begin2, k - partA);
        }
    }
}