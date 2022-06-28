/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 * 题目：给你一个字符串path，表示指向某一文件或目录的Unix风格绝对路径（以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * 在Unix风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 * 难度：Medium
 * 思路：栈
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] pathArray = path.split("/");
		int length = pathArray.length;
		Stack<String> stack = new Stack<>();
		String result = "";
		for (int i = 0;i < length;i++) {
			if (pathArray[i].equals("") || pathArray[i].equals(".")) {
                continue;
            }
			else if (pathArray[i].equals("..")) {
				if (!stack.isEmpty()) {
				    stack.pop();
				}
			}
			else {
				stack.push(pathArray[i]);
			}
		}
		if (stack.isEmpty()) {
			return "/";
		}
		while (!stack.isEmpty()) {
		    result = "/" + stack.pop() + result;
		}
		return result;   
    }
}
// @lc code=end

