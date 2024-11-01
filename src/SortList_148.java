/**
 * https://leetcode.cn/problems/sort-list/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class SortList_148 {


    public static ListNode sortList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if(pre !=null && pre.val>=cur.val){
                cur.next=pre;
                pre=cur;
                cur=next;
            }else if (pre ==null){
                cur.next=pre;
                pre=cur;
                cur=next;
            }else{

            }


        }
        return pre;
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