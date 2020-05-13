package linkedList;

/**
 * ����һ������ÿ k ���ڵ�һ����з�ת�����㷵�ط�ת�������
 *
 * k ��һ��������������ֵС�ڻ��������ĳ��ȡ�
 *
 * ����ڵ��������� k ������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
 *
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return head;
        ListNode temp  = head;
        ListNode h = head;
        int count = 0;
        while (temp!=null&&count<k-1){
            count++;
            temp = temp.next;
        }
        if(temp==null||count!=k-1){
            return head;
        }else{
            ListNode temp1=head;
            if(temp!=null) {
                head = temp.next;
                temp.next = null;
            }else {
                head = temp;
            }
            h = reverseLinked(temp1);
            ListNode last = h;
            while(last.next!=null){
                last = last.next;
            }
            last.next=reverseKGroup(head, k);

        }
       return h;
    }
    public ListNode reverseLinked(ListNode head){
        if(head==null || head.next== null)
            return head;
        ListNode result = reverseLinked(head.next);
        head.next.next = head;
        head.next = null;
        return  result;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ReverseKGroup r = new ReverseKGroup();
        ListNode re = r.reverseKGroup(a, 3);
        System.out.println(re);

    }
}
