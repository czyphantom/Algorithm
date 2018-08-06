/**
* 题目：求带环链表中环的开始结点
* 思路：先求环的大小，再让结点先走这么多，然后再让另一个结点走
*/

public class Solution {
    //先求相遇的结点
    public static ListNode meetingNode(ListNode head) {
        if(head == null)
            return null;
        
        ListNode slow = head.next;
        if(slow == null)
            return null;
         
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if(slow == fast){
                return fast;
            }
            slow=slow.next;
            fast=fast.next;
             
            if(fast != slow){
                fast=fast.next;
            }
        }
        return null;
    }
    //求环的开始结点
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);

        if(meetingNode == null)
            return null;

        int nodesInLoop = 1;
        ListNode p1 = meetingNode;
        //计算环有多少个结点
        while(p1.next != meetingNode){
            p1 = p1.next;
            ++nodesInLoop;
        }
        //先让一个结点走环中结点的步数
        p1 = pHead;
        for(int i = 0;i < nodesInLoop;i++){
            p1 = p1.next;
        }
        //再让下一个走
        ListNode p2 = pHead;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
