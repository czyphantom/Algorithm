/**
* 题目：找出一个数组中出现次数为1的两个数，其他都为2次
* 思路：我用的HashMap，另外还有一种及其巧妙的方法，因为两个相同的数字其异或结果为0，先对整个数组进行异或
* ，所得结果为两个只出现一次的数字的异或结果，其必不为0，因此至少有一位为1，设第N位为1，这样把原数组划分
* 为两个子数组，一个第N位为1，一个第N位为0，这样每个子数组都有一个数字只出现一次，再做异或即可。
*/

public class Solution {
  public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
          if(array == null || array.length <= 1){
              num1[0] = num2[0] = 0;
              return;
          }
          int len = array.length, index = 0, sum = 0;
          //计算所有数异或的结果
          for(int i = 0; i < len; i++){
              sum ^= array[i];
          }
          //找到sum中第一个不为0的位置
          for(index = 0; index < 32; index++){
              if((sum & (1 << index)) != 0)
                  break;
          }
          //将数组按照该位置是否为1分成两个部分，分别对这两个部分做异或即可得到结果
          for(int i = 0; i < len; i++){
              if((array[i] & (1 << index))!=0){
                  num2[0] ^= array[i];
              }else{
                  num1[0] ^= array[i];
              }
          }
      }
}
