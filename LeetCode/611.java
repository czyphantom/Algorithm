/**
 * 题目：给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * 难度：Medium
 * 思路：排序后二分查找
 */

class Solution {
    public int triangleNumber(int[] nums) {
		int count = 0;
		int mid = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		Collections.sort(list);
		for (int i = 0; i < list.size() - 1; i++)
			for (int j = i + 1; j < list.size(); j++) {
				int sum = (int) list.get(i) + (int) list.get(j);
				int left = j;
				int right = list.size();
				while (right - 1 > left) {
					mid = (right + left) / 2;
					if (sum <= (int) list.get(mid)) {
						right = mid;
					}
					if (sum > (int) list.get(mid)) {
						left = mid;
					}
				}
				count += left - j;
			}
		return count;
	}
}