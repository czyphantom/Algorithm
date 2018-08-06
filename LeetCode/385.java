/**
 * 题目：给定一系列嵌套的字符串(代表数字），返回嵌套的整数数组
 * 难度：Medium
 * 思路：用栈存储
 */

public class Solution {
    public NestedInteger deserialize(String s) {
        if (s.isEmpty()) {
             return null;
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        //保存上一个NestedInteger对象
        Stack<NestedInteger> stack = new Stack<>();
        //当前NestedInteger对象
        NestedInteger curNi = null;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++ ) {
            char c = s.charAt(i);
            if(c == '[') {
                //如果当前不为空，则临时push进stack
                if(curNi != null) {
                   stack.push(curNi);
                }
                //并且遇到'['之后要实例化新的 curNi
                curNi = new NestedInteger();
            } else if (c == ']') {
                //遇到']'之后，就要把之前的字符串解析成int了
                if(sb.length() >0) {
                    curNi.add(new NestedInteger(Integer.parseInt(sb.toString())));
                    sb.setLength(0);
                }
                //如果stack不为空则把 curNi添加到stack的顶层中。
                if(!stack.empty()) {
                    NestedInteger popNi = stack.pop();
                    popNi.add(curNi);
                    curNi = popNi;
                }
            } else if (c == ','){
                //如果前一个元素是]，则已经处理；如果不是，则要把前面的元素解析成int
                if(s.charAt(i-1) != ']') {
                    curNi.add(new NestedInteger(Integer.parseInt(sb.toString())));
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }
        return curNi;
    }
}
