import java.util.LinkedList;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=new ListNode(-1);
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode temp=head;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next=head1;
                head1 = head1.next;
            } else {
                temp.next=head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while (head1 != null) {
            temp.next=head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next=head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return head.next;
    }
}
