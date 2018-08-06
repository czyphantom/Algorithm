/**
 * 题目：反转从位置m到n的链表。请使用一趟扫描完成反转。
 * 难度：Medium
 * 思路：使用一个冗余节点。
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n) {
            return null;
        }
        //设置一个dummyNode便于操作
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        head = dummyNode;
        //到m-n区间前面一个节点
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        // 保存n-m区间前一个节点
        ListNode pre = head;
        // 保存n-m区间第一个节点
        ListNode fNode = head.next;
        ListNode lastNode = null;
        ListNode curNode = fNode;
        for (int i = m; i <= n; i++) {
            ListNode tmp = curNode.next;
            curNode.next = lastNode;
            lastNode = curNode;
            curNode = tmp;
        }
        pre.next = lastNode;
        fNode.next = curNode;
        return dummyNode.next;
    }
}