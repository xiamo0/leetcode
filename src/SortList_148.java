import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * https://leetcode.cn/problems/sort-list/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class SortList_148 {

    public static void main(String[] args) {
        ListNode t0=new ListNode(5);
        ListNode t1=new ListNode(6);
        ListNode t2=new ListNode(-1);
        ListNode t3=new ListNode(2);
        t0.next=t1;
        t1.next=t2;
        t2.next=t3;
        ListNode listNode = sortList(t0);
        System.out.println(listNode);


    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode middle = head;
        ListNode end = middle.next;
        while (end != null && end.next !=null) {
            middle = middle.next;
            end = end.next.next;
        }
        ListNode next = middle.next;
        middle.next = null;
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(next);
        return mergeTwoLists(head1,head2);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            int val = l1.val;
            int val2 = l2.val;
            if (val < val2) {
                temp.next = new ListNode(val);
                l1 = l1.next;
                temp = temp.next;
            } else if (val2 < val) {
                temp.next = new ListNode(val2);
                l2 = l2.next;
                temp = temp.next;
            } else if (val == val2) {
                temp.next = new ListNode(val);
                temp=temp.next;
                temp.next = new ListNode(val2);
                temp=temp.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            temp.next= new ListNode(l1.val);
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null) {
            temp.next = new ListNode(l2.val);
            temp = temp.next;
            l2 = l2.next;

        }
        return head.next;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}