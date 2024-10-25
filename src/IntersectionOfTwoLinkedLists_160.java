import java.util.Objects;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/?envType=problem-list-v2&envId=2cktkvj
 * <p>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class IntersectionOfTwoLinkedLists_160 {
    public static void main(String[] args) {
        ListNode headA = null;
        ListNode headB = null;
        getIntersectionNode(headA, headB);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (Objects.isNull(headA) || Objects.isNull(headB)) {
            return null;
        }
        ListNode headC = headA;
        while (!Objects.isNull(headC)) {
            ListNode temp = headB;
            while (!Objects.isNull(temp)) {
                if (temp ==headC){
                    temp = headC;
                    break;
                }
                if (temp.next == headC) {
                    temp = headC;
                    break;
                }
                temp = temp.next;
            }
            if (temp == headC) {
                return headC;
            }
            headC = headC.next;
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
