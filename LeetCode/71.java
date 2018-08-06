/**
 * 题目；给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
 * 难度：Medium
 * 思路：用栈
 */

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