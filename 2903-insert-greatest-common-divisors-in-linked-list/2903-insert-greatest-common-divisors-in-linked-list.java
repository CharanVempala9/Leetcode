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
    public int gcd(int a,int b){
        if (b == 0)
        return a;
        return gcd(b, a % b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode first=head;
        ListNode second=head.next;
        while(second!=null){
            int a=first.val;
            int b=second.val;
            int newVal=gcd(a,b);
            ListNode node=new ListNode(newVal);
            first.next=node;
            node.next=second;
            first=node.next;
            second=second.next;
        }
        return head;
    }
}