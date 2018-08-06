/**
* 题目：找出一个排序数组中给定数的出现次数
* 思路：用二分找出给定数的begin位置和end位置
*/

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int length = array.length;
        if(length == 0){
            return 0;
        }
        int firstK = getFirstK(array, k, 0, length-1);
        int lastK = getLastK(array, k, 0, length-1);
        if(firstK != -1 && lastK != -1){
             return lastK - firstK + 1;
        }
        return 0;
    }
    
    private int getFirstK(int [] array , int k, int start, int end){
        int length = array.length;
        while(start <= end){
            int mid = (start + end)/2;
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid-1 >= 0 && array[mid-1] == k){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    
    private int getLastK(int [] array , int k, int start, int end){
        int length = array.length;
        while(start <= end){
            int mid = (start + end)/2;
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid+1 < length && array[mid+1] == k){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
