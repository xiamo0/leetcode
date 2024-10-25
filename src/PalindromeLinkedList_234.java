import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class PalindromeLinkedList_234 {
    public static void main(String[] args) {


    }

    public static boolean isPalindrome(ListNode head) {

        if (Objects.isNull(head)){
            return false;
        }
        List<Integer> list =new ArrayList<>();
        ListNode temp=head;
        while (!Objects.isNull(temp)){
            list.add(temp.val);
            temp=temp.next;
        }
        for (int i = 0; i <list.size()/2 ; i++) {
            if (list.get(i)!=list.get(list.size()-i-1)){
                return false;
            }
        }
        return true;


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
}