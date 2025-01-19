import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        removeNthFromEnd(listNode1, 1);

    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        ListNode newHead = new ListNode(0, head);
        temp = newHead;
        for (int i = 0; i < length-n+1; i++) {
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return newHead.next;


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int nodeCount = 0;
        ListNode copyNode = head;
        List<Integer> content = new ArrayList<>();
        while (copyNode != null) {
            nodeCount++;
            content.add(copyNode.val);
            copyNode = copyNode.next;
        }
        int removeNodeIndex = nodeCount - n;
        content.remove(removeNodeIndex);
        ListNode result = null;
        ListNode tempNextNode = null;
        for (int i = 0; i < content.size(); i++) {
            Integer curVal = content.get(i);
            if (curVal == null) {
                continue;
            }
            if (result == null) {
                result = new ListNode();
                result.val = curVal;
                if (i + 1 == content.size()) {
                    result.next = null;
                } else {
                    result.next = new ListNode();
                }
                tempNextNode = result.next;
            } else {
                tempNextNode.val = curVal;
                if (i + 1 == content.size()) {
                    tempNextNode.next = null;
                } else {
                    tempNextNode.next = new ListNode();
                }
                tempNextNode = tempNextNode.next;
            }
        }
        return result;
    }

    public static class ListNode {
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

}
