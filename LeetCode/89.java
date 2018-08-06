/**
 * 题目：格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。给定一个代表编码总位数的非负整数n，打印其格雷编码序列。格雷编码序列必须以0开头。
 * 难度：Medium
 * 思路：格雷码的计算公式为G(i) = i^(i/2)，这是最快的方法，另外也可以使用回溯。
 */

 //法1，公式
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1<<n; i++) {
            result.add(i ^ i>>1);
        }
        return result;
    }
}

//法2，回溯
class Solution2 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        helper(result,list,n);
        return result;
    }

    private void helper(List<Integer> result,List<Integer> list,int n){
        if(list.size() == Math.pow(2,n)){
            result.addAll(list);
            return;
        }
        int last = list.get(list.size() - 1);
        for(int i = 0; i < n; i++){
            int off = 1 << i;
            int cur = last ^ off;
            
            if(list.contains(cur)) {
                continue;
            }
            list.add(cur);
            helper(result,list,n);
            if(result.size() > 0) 
                return;
            list.remove(list.size() - 1);
        }
    } 
}