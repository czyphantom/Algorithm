/**
* 题目大意：和39题类似，只不过这次每个元素只能使用一次。
* 难度：Medium
* 思路：和39也类似，不过要注意如果有相同元素前一个没有被加入到结果中，后一个要跳过去。
*/

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    findResults(res,new ArrayList<>(),candidates,0,target);
    return res;
}

private void findResults(List<List<Integer>> res,List<Integer> tmp,int[] candidates,int start,int target) {
    if(target < 0)
        return;
    if(target == 0)
        res.add(new ArrayList<Integer>(tmp));
    for(int i = start;i < candidates.length;i++) {
        if(i > start && candidates[i] == candidates[i-1])
            continue;
        tmp.add(candidates[i]);
        findResults(res,tmp,candidates,i+1,target-candidates[i]);
        tmp.remove(tmp.size()-1);
    }
}
