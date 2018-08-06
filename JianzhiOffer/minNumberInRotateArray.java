/**
* 题目：在一个旋转数组里找最小值
* 思路：比较mid和end位置的数字大小，如果mid<end，说明右边严格递增，这时最小值在左半部分（注意也有可能时* mid，所以缩小范围时要包括mid，即end=mid；如果mid>end，说明右边存在最小值；如果mid=end，让end--，重新* 计算mid。
*/

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0)
            return 0;
        int begin = 0,end = array.length-1;
        while(begin < end) {
            int mid = (begin+end)/2;
            if(array[mid] < array[end]) {
                end = mid;
            } else if(array[mid] > array[end]) {
                begin = mid+1;
            } else {
                end--;
            }
        }
        return array[begin];
    }
}
