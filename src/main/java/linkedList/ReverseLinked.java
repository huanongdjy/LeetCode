package linkedList;

import java.util.List;


/**
 * 反转链表
 *
 */
public class ReverseLinked {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseLinked(ListNode head){
        if(head==null || head.next== null)
            return head;
        ListNode result = reverseLinked(head.next);
        head.next.next = head;
        head.next = null;
        return  result;
    }
}
