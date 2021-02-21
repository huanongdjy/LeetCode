package linkedList;

import tree.ListNode;

public class Partition {
//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) { val = x; }
//    }
    public ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode(-1);
        ListNode r = new ListNode(-1);
        ListNode p1 = l;
        ListNode p2 = r;
        while (head!=null){
            if(head.val>=x){
                p2.next =  new ListNode(head.val);
                p2 = p2.next;
            }else {
                p1.next = new ListNode(head.val);
                p1 = p1.next;
            }
            head = head.next;
        }
        p1.next = r.next;
        return l.next;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(4);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(2);
        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(2);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        Partition pt = new Partition();
        pt.partition(p1,3);

    }
}
