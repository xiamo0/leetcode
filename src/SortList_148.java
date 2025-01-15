/**
 * https://leetcode.cn/problems/sort-list/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class SortList_148 {

    public static void main(String[] args) {
        ListNode1 t0=new ListNode1(5);
        ListNode1 t1=new ListNode1(6);
        ListNode1 t2=new ListNode1(-1);
        ListNode1 t3=new ListNode1(2);
        t0.next=t1;
        t1.next=t2;
        t2.next=t3;
        ListNode1 listNode = sortList(t0);
        System.out.println(listNode);


    }

    public static ListNode1 sortList(ListNode1 head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode1 middle = head;
        ListNode1 end = middle.next;
        while (end != null && end.next !=null) {
            middle = middle.next;
            end = end.next.next;
        }
        ListNode1 next = middle.next;
        middle.next = null;
        ListNode1 head1 = sortList(head);
        ListNode1 head2 = sortList(next);
        return mergeTwoLists(head1,head2);

    }

    public static ListNode1 mergeTwoLists(ListNode1 l1, ListNode1 l2) {

        ListNode1 head = new ListNode1();
        ListNode1 temp = head;
        while (l1 != null && l2 != null) {
            int val = l1.val;
            int val2 = l2.val;
            if (val < val2) {
                temp.next = new ListNode1(val);
                l1 = l1.next;
                temp = temp.next;
            } else if (val2 < val) {
                temp.next = new ListNode1(val2);
                l2 = l2.next;
                temp = temp.next;
            } else if (val == val2) {
                temp.next = new ListNode1(val);
                temp=temp.next;
                temp.next = new ListNode1(val2);
                temp=temp.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            temp.next= new ListNode1(l1.val);
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null) {
            temp.next = new ListNode1(l2.val);
            temp = temp.next;
            l2 = l2.next;

        }
        return head.next;
    }


}

class ListNode {
    int val;
    ListNode1 next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }
}