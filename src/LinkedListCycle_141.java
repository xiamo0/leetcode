/**
 * https://leetcode.cn/problems/linked-list-cycle/solutions/440042/huan-xing-lian-biao-by-leetcode-solution/?envType=problem-list-v2&envId=2cktkvj
 */
public class LinkedListCycle_141 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        System.out.println(hasCycle(n1));

    }

    public static boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        var slow = head;
        var fast = head.next.next;
        while (slow != fast) {
            if (fast == null) {
                return false;
            }
            if (fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
