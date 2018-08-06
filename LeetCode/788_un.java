/**
 * 题目：我们称一个数X为好数, 如果它的每位数字逐个地被旋转180度后，我们仍可以得到一个有效的，且和X不同的数。
 * 要求每位数字都要被旋转。现在我们有一个正整数N, 计算从1到N中有多少个数X是好数。
 * 难度：Medium
 * 思路：水题
 */

class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for(int i = 1; i <= N; i++ ) {
            if(isValid(i)) 
                count++;
        }
        return count;
    }

    public boolean isValid(int i) {
        boolean valid = false;

        while(i > 0) {
            if(i % 10 == 2 || i % 10 == 5 || i % 10 == 6 || i % 10 == 9) {
                valid = true;
            }
            if(i% 10 == 3 || i% 10 == 4 || i% 10 == 7) {
                return false;
            }
            i = i / 10;
        }
        return valid;
    }
}