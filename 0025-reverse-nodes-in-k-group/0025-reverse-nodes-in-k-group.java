class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0); // For consistent head update
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (size >= k) {
            ListNode last = prev;
            ListNode newEnd = curr;
            ListNode next = curr.next;

            // Reverse k nodes
            ListNode p = null, c = curr, n = null;
            for (int i = 0; i < k; i++) {
                n = c.next;
                c.next = p;
                p = c;
                c = n;
            }

            // Fix connections
            last.next = p;
            newEnd.next = c;

            // Move pointers
            prev = newEnd;
            curr = c;
            size -= k;
        }

        return dummy.next;
    }
}
