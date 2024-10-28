import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/reverse-linked-list/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class ReverseLinkedList_206 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode listNode1 = reverseList(listNode);
        System.out.println(listNode1);


    }
    public static ListNode reverseList2(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;

        }
        return pre;

    }
    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        Stack<Integer>stack=new Stack<>();
        while (curr !=null){
            stack.push(curr.val);
            curr = curr.next;
        }
        ListNode result = null;
        ListNode temp = null;
        while (!stack.isEmpty()){
            ListNode listNode = new ListNode(stack.pop());
            if (result ==null){
                result=listNode;
            }else {
                temp.next = listNode;
            }
            temp=listNode;

        }
        return result;

    }

    static class ListNode {
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
