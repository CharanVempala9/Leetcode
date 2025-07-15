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
    public ListNode partition(ListNode head, int x) {
        ListNode A=new ListNode(-1);
        ListNode B=new ListNode(-1);
        ListNode temp=head;
        ListNode first=A;
        ListNode second=B;
        while(temp!=null){
            if(temp.val<x){
                first.next=temp;
                first=temp;
            }
            else{
                second.next=temp;
                second=temp;
            }
            temp=temp.next;
        }
        first.next=B.next;
        second.next=null;
        return A.next;
    }
}