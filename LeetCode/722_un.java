/**
 * 题目：删除注释
 * 难度：Medium
 * 思路：繁琐的处理
 */

class Solution {
    public List<String> removeComments(String[] source) {

        List<String> res = new ArrayList<>();
        if (source.length == 0) return res;

        StringBuilder sb = new StringBuilder();
        int index = 0, i = 0, tag = 0;
        while (index < source.length) {
            i = 0;
            if (source[index].length() == 0) {
                index++;
                continue;
            }
            if (source[index].length() == 1) {
                if (tag == 0) {
                    res.add(source[index++]);
                } else {
                    index++;
                }
                continue;
            }
            while (i < source[index].length() - 1) {
                char c1 = source[index].charAt(i);
                char c2 = source[index].charAt(i + 1); 
                if (c1 == '/' && c2 == '/' && tag == 0) {
                    if (sb.length() != 0) {
                        res.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    index++;
                    break;
                } else if (c1 == '/' && c2 == '*' && tag == 0) {
                    i = i + 1;
                    tag = 1;
                    if (i >= source[index].length() - 2) {
                        index++;
                        break;
                    }
                } else if (c1 == '*' && c2 == '/' && tag == 1) {
                    i = i + 1;
                    tag = 0;
                    if (i == source[index].length() - 1) {
                        if (sb.length() != 0) {
                            res.add(sb.toString());
                            sb = new StringBuilder();
                        }
                        index++;
                        break;
                    }
                } else {
                    if (tag == 0) {
                        sb.append(c1);
                    } 
                }
                i++;
                if (i == source[index].length() - 1) {
                    if (tag == 0) {
                        sb.append(source[index].charAt(i));
                        res.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    index++;
                    break;
                }
            }
        }
        return res;
    }
}