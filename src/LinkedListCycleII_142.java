import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class LinkedListCycleII_142 {

    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (slow != fast) {
            if (fast==null){
                return null;
            }
            if (fast.next == null) {
                return null;
            }
            if (fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        var end = fast;
        while (slow != fast) {
            if (slow == end) {
                slow = head;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;


    }

    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> cache = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {

            if (cache.contains(cur)) {
                return cur;
            }
            cache.add(cur);
            cur = cur.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode begin = head;
        while (begin != null) {
            var temp = begin.next;
            while (temp != null) {
                if (temp == begin) {
                    break;
                }
                temp = temp.next;
            }
            if (temp == begin) {
                return begin;
            }
            begin = begin.next;
        }
        return null;

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
