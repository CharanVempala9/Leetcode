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
        if(head==null){
            return null;
        }
        if(head.next==null){
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
        head=prev;
        return head;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode mid=Middle(head);
        ListNode first=head;
        ListNode second=reverse(mid);
        ListNode temp=second;
        boolean flag=true;
        while(first!=null && second!=null){
            if(first.val!=second.val){
                flag =false;
                break;
            }
            first=first.next;
            second=second.next;
        }
        reverse(second);
        return flag;
    }
}