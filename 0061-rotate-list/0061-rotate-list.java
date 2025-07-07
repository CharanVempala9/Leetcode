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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0 || head.next==null){
            return head;
        }
        ListNode temp=head;
        int size=1;
        while(temp.next!=null){
            temp=temp.next;
            size++;
        }
        temp.next=head;
        int rot=k%size;
        ListNode last=head;
        for(int i=0; i<size-rot-1; i++){
            last=last.next;
        }
        ListNode actual=last;
        head=actual.next;
        last.next=null;
        return head;
    }
}