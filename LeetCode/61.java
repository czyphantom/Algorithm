/**
 * 题目：给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。
 * 难度：Medium
 * 思路：实际上只要将两部分拼接即可
 */

class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || k == 0){
            return head;
        }
        int count = 1;
        ListNode p = head;
        while(p.next != null){
            count++;
            p = p.next;
        }
        k = k % count;
		ListNode pHead = head;		
		ListNode q = head;
		for(int i = 0; i < count-k-1; i++){
			q = q.next;
		}
		p.next = pHead;
		pHead = q.next;
		q.next= null;
        return pHead;
    }
}
