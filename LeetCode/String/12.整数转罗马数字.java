/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马
 * 数字罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。给你一个整数，将其转为罗马数字。
 * 难度：Medium
 * 思路：水题
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb=new StringBuilder();
        
        for(int i = 0;i < values.length;i++){
            while(num >= values[i]){
                sb.append(rom[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}
// @lc code=end

