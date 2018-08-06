/**
* 题目：给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的
* 整数。假设只有一个重复的整数，找出这个重复的数。重复出现次数不1次
* 难度：Medium
* 思路：两种思路具体见下面。
*/

//思路1:类似二分，每次对mid的数进行判断，如果小于等于mid的数的个数小于等于mid，说明1-mid中不存在重复的，反之
//则在mid+1到n中
public int findDuplicate(int[] nums) {
    int low = 1, high = nums.length - 1;
    while(low <= high) {
        int mid = low + (high - low) / 2;
        int cnt = 0;
        for(int a: nums) {
            if(a <= mid)
                cnt++;
        }
        if(cnt <= mid)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return low;
}

//思路2:将重复的数看作是链表的环，利用快慢指针
public int findDuplicate(int[] nums) {
    int slow = 0, fast = 0;
    do {
        slow = nums[slow];
        fast = nums[nums[fast]];
    }while(slow != fast);

    fast = 0;
    while(slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
    }
    return slow;
}
