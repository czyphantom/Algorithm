/**
* 题目大意：一个只有0,1,2的数组进行排序。
* 难度：Medium
* 思路：我是直接排序的==，但是可以用O（n）的算法求得，遍历数组时，记录两个索引，一个保存最后一个0的后
* 位，一个保存最开始的2的前一位。遇到0，把0和第一个索引的值交换，同时更新索引；遇到2，把2和第二个索引
* 值交换，同时更新索引和当前指针减一（因为当前指针还需要看是否为0）。
*/

public void sortColors(int[] nums) {
    Arrays.sort(nums);
}

public void sortColors(int[] nums) {
    int begin = 0;
    int end = nums.length-1;
    int i = 0;
    while(i <= end) {
        if(nums[i] == 0) {
            nums[i] = nums[begin];
            nums[begin] = 0;
            begin++;
        }

        if(nums[i] == 2) {
            nums[i] = nums[end];
            nums[end] = 2;
            end--;
            i--;
        }
        i++;
    }
}
