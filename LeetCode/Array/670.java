/**
 * 题目大意：给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * 难度：Medium
 * 思路：从最低位一直遍历到最高位，存储迄今为止最大的数字。如果当前数字比迄今为止最大的数字小，那么存储swap索引：当前
 * 数字的索引 和 迄今为止最大数字的索引。如果当前数字比迄今为止最大的数字大，那么重置 迄今为止最大的数字。最后，交换
 * 之前存储的两个swap索引。重新计算数字。
 */

class Solution {
    public int maximumSwap(int num) {
        int maxSeen = 0, maxIdx = -1, power = 0, swapIdx1 = 0, swapIdx2 = 0;
        List<Integer> list = new ArrayList<>();
        while(num > 0){
            int digit = num % 10;
            list.add(digit);
            if(maxSeen > digit){
                swapIdx1 = power;
                swapIdx2 = maxIdx;
            }
            else if(digit > maxSeen){
                maxSeen = digit;
                maxIdx = power;
            }
            num = num/10;
            power++;
        }
        
        Collections.swap(list, swapIdx1, swapIdx2);
 
        int result = 0;
        for(int i = 0; i < list.size(); i++){
            result += (int)(Math.pow(10, i) * list.get(i));
        }
        return result;
    }
}