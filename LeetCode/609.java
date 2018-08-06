/**
 * 题目：给定一个目录信息列表，包括目录路径，以及该目录中的所有包含内容的文件，您需要找到文件系统中的所有重复文件组的
 * 路径。一组重复的文件至少包括二个具有完全相同内容的文件。
 * 难度：Medium
 * 思路：哈希表
 */

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : paths) {
            String[] files = s.split(" ");
            String root = files[0];
            for(int i = 1; i < files.length; i++) {
                String[] content = files[i].split("[()]");
                ArrayList<String> newContent =  (ArrayList<String>) map.getOrDefault(content[1], new ArrayList<String>());
                newContent.add(root + "/" + content[0]);
                map.put(content[1], newContent);
            }
        }
        for(List<String> s: map.values()) {
            if(s.size() > 1) {
                list.add(s);
            }
        }
        return list;        
    }
}