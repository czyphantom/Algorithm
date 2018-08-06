/**
* 题目：求一个double型数值的幂，幂是int型
* 思路：快速幂，注意幂是负数的情况
*/

public class Solution {
    public double Power(double base, int exponent) {
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        
        if(exponent > 0) {
            if((exponent & 1) == 0)
                return Power(base,exponent/2)*Power(base,exponent/2);
            else
                return base*Power(base,(exponent-1)/2)*Power(base,(exponent-1)/2);
        }
        else
            return 1/(Power(base,-exponent));
  }
}
