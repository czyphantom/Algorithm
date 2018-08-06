/**
* 题目：在一个有序数组中找两个数的和为给定数，如果有多对，找积最小的
* 思路：两个指针一个从前找，一个从后找
*/

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0,j = array.length-1;
        while(i < j) {
            if(array[i] + array[j] > sum)
                j--;
            else if(array[i] + array[j] < sum)
                i++;
            else {
                if(!result.isEmpty()) {
                    if(array[i]*array[j] < result.get(0)*result.get(1)) {
                        result.clear();
                        result.add(array[i]);
                        result.add(array[j]);
                    } else {
                        i++;
                    }
                } else {
                    result.add(array[i]);
                    result.add(array[j]);
                }
            }
        }
        return result;
    }
}
