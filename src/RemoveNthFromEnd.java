import java.util.Objects;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nodeCount = 0;
        ListNode copyNode = head;
        while (copyNode != null) {
            nodeCount++;
            copyNode = copyNode.next;
        }
        int removeNodeIndex = nodeCount - n + 1;
        copyNode = head;
        ListNode result = null;
        ListNode temp = null;
        int curIndex = 1;
        while (curIndex <= nodeCount) {
            int val = copyNode.val;
            copyNode = copyNode.next;


            if (result == null) {
                result = new ListNode(val);
                result.next = new ListNode();
                temp = result.next;
            } else {
                temp.val = val;
                temp.next = new ListNode();
                temp = temp.next;
            }
            if (curIndex == removeNodeIndex) {

            }else if


            if (result == null) {
                result = new ListNode(val);
                result.next = new ListNode();
                if ((curIndex + 1) == romoveNodeIndex) {
                    result.next = null;
                }
                temp = result.next;
            } else {
                temp.val = val;
                temp.next = new ListNode();
                if (curIndex == nodeCount) {
                    temp.next = null;
                }
                temp = temp.next;
            }

            curIndex++;
        }
        return result;


    }

    public class ListNode {
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
