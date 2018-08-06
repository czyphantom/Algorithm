/**
 * 题目：给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 难度：Hard
 * 思路：见注释
 */

class Solution {
    public int trap(int[] height) {
	    if (height == null || height.length == 0) {
		    return 0;
	    }
        int bigHeight = 0;
        int smallHeiht = 0;
		int totalNum = 0;
		//正向遍历求出每个矮的部分可能接雨水的面积
	    for (int i = 0; i < height.length; i++) {
		    if (height[i] > bigHeight) {
			    bigHeight = height[i];
		    } else {
			    totalNum += bigHeight - height[i];
		    }
		}
		//反向遍历减去多算的部分
        for (int i = height.length - 1; height[i] < bigHeight; i--) {   
		    if (height[i] > smallHeiht) {
			    smallHeiht = height[i];
		    }
	        totalNum -= bigHeight - smallHeiht;
	    }
	    return totalNum;
    }
}