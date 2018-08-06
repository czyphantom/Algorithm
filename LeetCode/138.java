/**
 * 题目：给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。要求返回这个链表的深度拷贝。
 * 难度：Medium
 * 思路：先复制节点放到原链表每个节点的后面，再设置随机指针，最后移除原链表。
 */

public class Solution {
    public RandomListNode Clone(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode pCur = head;
        //先复制节点到原链表后面
        while (pCur != null) {
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }
        //加入随机指针
        pCur = head;
        while (pCur != null) {
            if (pCur.random != null) {
                pCur.next.random = pCur.random.next;
            }
            pCur = pCur.next.next;
        }
        //断开连接
        RandomListNode pHead = head.next;
        RandomListNode cur = pHead;
        pCur = head;
        while (pCur != null) {
            pCur.next = pCur.next.next;
            if (cur.next != null) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
            pCur = pCur.next;
        }
        return pHead;
    }
}