/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode Middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode curr=head;
        ListNode Next=head.next;
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=Next;
            if(Next!=null){
                Next=Next.next;
            }
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode first=head;
        ListNode mid=Middle(head);
        ListNode second=reverse(mid.next);
        mid.next = null;
        ListNode p1=null;
        ListNode p2=null;
        while(first!=null && second!=null){
            //first
            p1=first.next;
            first.next=second;
            first=p1;
            //second
            p2=second.next;
            second.next=first;
            second=p2;
        }
    }
}