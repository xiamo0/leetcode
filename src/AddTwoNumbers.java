public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode1 l1 = new ListNode1();
        l1.val = 2;
        ListNode1 l11 = new ListNode1();
        l11.val = 4;
        l1.next = l11;
        ListNode1 l111 = new ListNode1();
        l111.val = 3;
        l11.next = l111;


        ListNode1 l2 = new ListNode1();
        l2.val = 5;
        ListNode1 l22 = new ListNode1();
        l22.val = 6;
        l2.next = l22;
        ListNode1 l222 = new ListNode1();
        l222.val = 4;
        l22.next = l222;
        addTwoNumbers(l1, l2);
    }

    public static ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {

        int num1 = 0;
        int num2 = 0;
        int bit = 0;
        while (l1 != null) {
            int val = l1.val;
            int curV = (int) (val * Math.pow(10, bit));
            num1 = num1 + curV;
            bit += 1;
            l1 = l1.next;
        }
        bit = 0;
        while (l2 != null) {
            int val = l2.val;
            int curV = (int) (val * Math.pow(10, bit));
            num1 = num1 + curV;
            bit += 1;
            l2 = l2.next;
        }
        int sum = num1 + num2;
        ListNode1 result = null;
        ListNode1 cur = null;

        while (sum != 0) {
            int i = sum % 10;
            sum = sum / 10;
            if (result == null) {
                result = new ListNode1();
                result.val = i;
                result.next = new ListNode1();
                cur = result.next;
            } else {
                cur.val = i;
                if (sum != 0) {
                    cur.next = new ListNode1();
                }
                cur = cur.next;
            }
        }
        if (result == null) {
            result = new ListNode1();
        }
        return result;
    }
}

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1() {
    }

    ListNode1(int val) {
        this.val = val;
    }

    ListNode1(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }
}