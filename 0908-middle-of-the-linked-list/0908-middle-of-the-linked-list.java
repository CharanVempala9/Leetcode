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
    public ListNode middleNode(ListNode head) {
        ListNode temp=head;
        int size=0;
        if(temp.next==null){
            return head;
        }
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int ans=size/2;
        int cnt=0;
        temp=head;
        while(temp!=null){
            cnt++;
            if(cnt==ans)
            return temp.next;
            temp=temp.next;
        }
        return temp;
    }
}