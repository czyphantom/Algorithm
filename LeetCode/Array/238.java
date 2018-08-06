/**
* 题目：求一个数组的除了自身以外其他数的乘积
* 难度：Medium
* 思路：剑指offer原题
*/

public int[] productExceptSelf(int[] nums) {
    int length = nums.length;
    int[] res = new int[length];
    if(length != 0) {
        res[0] = 1;
        for(int i = 1; i < length; i++){
            res[i] = res[i-1] * nums[i-1];
          }
        int temp = 1;
        for(int j = length-2; j >= 0; j--){
            temp *= nums[j+1];
            res[j] *= temp;
        }
    }
    return res;
}
