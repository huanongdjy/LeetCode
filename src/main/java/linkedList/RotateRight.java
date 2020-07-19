package linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode p = head;
        List<ListNode> list = new ArrayList<ListNode>();
        while (head.next!=null){
            list.add(head);
            head = head.next;
        }
        list.add(head);
        int len = list.size();
        k = k%len;
        if(k==0||p==null||p.next==null)return p;

        list.get(len - k - 1).next=null;
        list.get(len - 1 ).next = p;
        return list.get(len - k);
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        RotateRight rr = new RotateRight();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        rr.rotateRight(a, 7);
    }
}
