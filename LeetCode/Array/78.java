/**
* 题目大意：找出一个数组的所有子集
* 难度：Medium
* 思路：回溯
*/

public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    sub(nums,res,new ArrayList<Integer>(),0);
    return res;
}

private void sub(int[] nums,List<List<Integer>> res,List<Integer> tmp,int begin) {
    res.add(new ArrayList<Integer>(tmp));

    for(int i = begin;i < nums.length;i++) {
        tmp.add(nums[i]);
        sub(nums,res,tmp,i+1);
        tmp.remove(tmp.size()-1);
    }
}
