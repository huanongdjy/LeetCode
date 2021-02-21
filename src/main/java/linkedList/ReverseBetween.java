package linkedList;

import tree.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 */
public class ReverseBetween {
//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) { val = x; }
//    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode l = head;
        ListNode p = head;
        ListNode q = new ListNode(-1);
        ListNode temp = q;
        ListNode r = null;
        int i = 1;
        while (p!=null){
            if(i<m){
                l=p;
            }
            if(i==m){
                r = p;
            }
            if(i>n){
                break;
            }
            if(i>=m&&i<=n){
//                l.next = p.next;
                q = temp.next;
                temp.next = p;
                p = p.next;
                temp.next.next = q;
//                p = p.next;
            }/*else if(i<m){
                p = p.next;
                l = p;
            }*/else {
                p = p.next;
            }

            i++;
        }
        if(r!=null)
            r.next = p;
        if(1==m){
            head = temp.next;
        }else
            l.next = temp.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
        ReverseBetween r = new ReverseBetween();
        ListNode re = r.reverseBetween(a, 1,1);
        System.out.println(re);

    }
}
