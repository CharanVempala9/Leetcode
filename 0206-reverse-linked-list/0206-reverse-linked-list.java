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
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode Prev=null;
        ListNode Curr=head;
        ListNode Next=head.next;
        while(Curr!=null){
            Curr.next=Prev;
            Prev=Curr;
            Curr=Next;
            if(Next!=null){
                Next=Next.next;
            }
        }
        head=Prev;
        return head;
    }
}