package linked_list;


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

class TwoNumberSum {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, ptr = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10, null);
            if (result == null) {
                result = temp;
            } else {
                ptr.next = temp;
            }
            ptr = temp;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                int sum = l2.val + carry;
                carry = sum / 10;
                ListNode temp = new ListNode(sum % 10, null);
                if (result == null) {
                    result = temp;
                } else {
                    ptr.next = temp;
                }
                ptr = temp;
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                int sum = l1.val + carry;
                carry = sum / 10;
                ListNode temp = new ListNode(sum % 10, null);
                if (result == null) {
                    result = temp;
                } else {
                    ptr.next = temp;
                }
                ptr = temp;
                l1 = l1.next;
            }
        }
        if (carry != 0) {
            ListNode temp = new ListNode(carry, null);
            ptr.next = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        //ListNode listNode = addTwoNumbers();
        //[9,9,9,9,9,9,9]
        //[9,9,9,9]
    }
}

