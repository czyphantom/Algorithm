/**
* 题目：复制一个链表，链表的结点除了next，还有一个random指针指向随机结点
* 思路：先复制结点加入到原链表中，接着加入random，最后拆分
*/

public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null)
            return null;
        RandomListNode pCur = pHead;
        //首先复制链表加入到原链表的后面
        while(pCur!=null){
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }
        //复位，准备添加randon指针
        pCur = pHead;
        //将随机指针加入到复制链表
        while(pCur!=null){
            if(pCur.random!=null)
                pCur.next.random = pCur.random.next;
            pCur = pCur.next.next;
        }
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        pCur = pHead;
        //准备分离两个结点
        while(pCur!=null){
            pCur.next = pCur.next.next;
            if(cur.next!=null)
                cur.next = cur.next.next;
            cur = cur.next;
            pCur = pCur.next;
        }
        return head;
    }
}
