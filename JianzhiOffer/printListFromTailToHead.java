/**
* 题目：从尾到头打印链表
* 思路：水题，也可以用递归做
*/

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode tmp = listNode;
        while(tmp != null) {
            result.add(tmp.val);
            tmp = tmp.next;
        }
        Collections.reverse(result);
        return result;
    }
}
