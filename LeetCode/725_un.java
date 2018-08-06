/**
 * 题目：给定一个头结点为root的链表, 编写一个函数以将链表分隔为k个连续的部分。
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过1，也就是说可能有些部分为null。
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * 返回一个符合上述规则的链表的列表。
 * 难度：Medium
 * 思路：水题
 */

class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        ListNode p = root;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        int avgLen = count / k;
        int moreThanAvg = count - avgLen * k;
        int cnt = 1;
        ListNode q = root;
        for (int i = 0; i < k; i++) {
            result[i] = q;
            if (q == null) {
                continue;
            }
            int len = avgLen;
            if (cnt <= moreThanAvg)
                len++;
            cnt++;
            for (int j = 0; j < len - 1; j++) {
                q = q.next;
            }
            ListNode r = q.next;
            q.next = null;
            q = r;
        }
        return result;
    }
}