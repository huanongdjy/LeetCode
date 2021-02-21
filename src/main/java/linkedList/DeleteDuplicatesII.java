package linkedList;

import tree.ListNode;

public class DeleteDuplicatesII {
//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) { val = x; }
//    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode no1=new ListNode(0);no1.next=head;
        ListNode p1=no1,p2=head;
        int r=0;
        while(p1.next!=null){
            while(p2.next!=null&&p2.next.val==p1.next.val){
                p2=p2.next;
                r=1;//如果有重复节点则r置为1
            }
            if(r==1){
                p1.next=p2.next;//删掉重复节点
                p2=p2.next;//再指针后移！！这时候p1不用动！
                r=0;
            }else{
                p1=p2;//指针后移!p1,p2都向后移动一下
                if(p2.next!=null)p2=p2.next;
            }
        }
        return no1.next;

    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        DeleteDuplicatesII deleteDuplicatesII = new DeleteDuplicatesII();
        deleteDuplicatesII.deleteDuplicates(p1);
    }
}
