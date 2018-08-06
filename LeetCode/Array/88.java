/**
* 题目大意：给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
* 难度：Medium
* 思路：先排序再求子集
*/

public List<List<Integer>> subsetsWithDup(int[] nums) {
    final List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    res.add(new ArrayList<>());
    int l =0;
    for(int i = 0; i < nums.length; i++){
      int z = res.size();
      if(i==0 || nums[i-1] !=nums[i] )  l = res.size();
      for(int j=z - l; j<z; j++){
        List<Integer> subset = new ArrayList<>(res.get(j));
        subset.add(nums[i]);
        res.add(subset);
      }
    }
    return res;
  }
