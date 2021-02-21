package linkedList;

import tree.ListNode;

import java.security.spec.RSAOtherPrimeInfo;

/**
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;

//        if(head==null||head.next==null)return head;
//        int num = 1;
//        ListNode p = head.next;
//        while (p!=null){
//            ListNode next = p.next;
//            ListNode pre = null;
//            ListNode tail = head;
//            for(int i=0; i<num; i++){
//                if(p.val<tail.val){
//                    if(pre!=null){
//                        p.next = pre.next;
//                        pre.next = p;
//                    }else {
//                        if(num==1){
//                            tail.next=null;
//                        }
//                        p.next = tail;
//                    }
//                    if(pre==null){
//                        head=p;
//                    }
//                    break;
//                }
//
//                pre = tail;
//                tail = tail.next;
//            }
//            num++;
//            p=next;
//        }
//        return head;
    }

    public static void main(String[] args) {
//        ListNode a = new ListNode(4);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(1);
//        ListNode d = new ListNode(3);
        ListNode a = new ListNode(-1);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(0);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode ret = insertionSortList.insertionSortList(a);
        System.out.println(ret.toString());

    }
}
